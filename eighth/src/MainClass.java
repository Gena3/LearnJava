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
        double dRetValue = 0, dStep, firstSquare, dDelta;
        final double dAccuracy = 0.0000001;
        int             iCountOfSteps = 2;
        final int       iMaxSteps = 10000000;
        boolean         boolNotBreak = true;

        firstSquare = f.applyAsDouble(a) * (b - a);
        dDelta = dAccuracy + 1;
        for(; boolNotBreak && Math.abs(dDelta) > dAccuracy; iCountOfSteps *= 2){
            if((iCountOfSteps < 0) || iCountOfSteps >= iMaxSteps){
                boolNotBreak = false;
                iCountOfSteps = iMaxSteps;
            }
            dStep = (b - a) / iCountOfSteps;
            dRetValue = 0;
            for(int i = 0; i < iCountOfSteps; i++){
                dRetValue += f.applyAsDouble(a + dStep * i);
            }
            dRetValue *= dStep;
            if(firstSquare != 0) {
                dDelta = Math.abs(dRetValue - firstSquare) / firstSquare;
            }else if(dRetValue != 0){
                dDelta = Math.abs(dRetValue - firstSquare) / dRetValue;
            }else{// Значит равны :-)
                break;
            }
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
