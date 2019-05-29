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

    public static String getCallerClassAndMethodName() {
        String strReturn;
        StackTraceElement elStackTrArr[];
        try{
            throw new IOException();
        }catch(IOException e){
            elStackTrArr = e.getStackTrace();
            strReturn = elStackTrArr[1].getClassName();
            if(strReturn != null)
            {
                strReturn = strReturn + "#" + elStackTrArr[1].getMethodName();
            }
        }
        return strReturn;
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
}
