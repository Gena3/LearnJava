

public class MainClass {
    private static Object retObject(){
        String retS = "Except";
        return retS;
    }
    private static double sqrt(double x) {
        if (x < 0){
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x); // your implementation here
    }
    public static void main(String[] args) {
        // Double b = (Double) MainClass.retObject();
        Double b = 10.0;
        for(int i = 0; i < 2; i++){
            System.out.println("Arg = " + b + "; result = " + sqrt(b));
            b -= 15.0;
        }

    }
}
