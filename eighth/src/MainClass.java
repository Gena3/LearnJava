import java.util.function.DoubleUnaryOperator;

public class MainClass {
    public static double integrateConst(DoubleUnaryOperator f, double a, double b) {
        double dRetValue = 0, dStep = 0.0000001;
        for(double dI = a; dI < b; dI += dStep){
            dRetValue += f.applyAsDouble(dI);
        }
        dRetValue *= dStep;
        return dRetValue;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double dRetValue = 0, dStep = 1, firstSquare, dDelta;
        final double dAccuracy = 0.0000001;
        for(double dI = a; dI < b; dI += dStep){
            dRetValue += dStep * f.applyAsDouble(dI);
        }
        // dRetValue *= dStep;
        dStep = dStep/2;
        dDelta = dAccuracy + 1;
        firstSquare = dRetValue;
        while(dAccuracy <= dStep && dDelta > dAccuracy){
            dRetValue = 0;
            for(double dI = a; dI < b; dI += dStep){
                dRetValue += dStep * f.applyAsDouble(dI);
            }
            // dRetValue *= dStep;
            if(firstSquare != 0) {
                dDelta = Math.abs(dRetValue - firstSquare) / firstSquare;
            }else if(dRetValue != 0){
                dDelta = Math.abs(dRetValue - firstSquare) / dRetValue;
            }else{// Значит равны :-)
                break;
            }
            firstSquare = dRetValue;
            dStep = dStep/2;
        }
        return dRetValue;
    }


    public static void main(String[] args){

        System.out.println(integrateConst(x -> 1,0, 1));
        System.out.println(integrate(x -> 1,0, 10));
        System.out.println(integrateConst(x -> Math.sin(x) / x , 1, 5));
        System.out.println(integrate(x -> Math.sin(x) / x , 1, 5));

    }
}
