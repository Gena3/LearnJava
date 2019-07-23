import java.io.IOException;

public class MainClass {
    public static String getCallerClassAndMethodName() {
        String strReturn;
        StackTraceElement elStackTrArr[];
        try{
            throw new IOException();
        }catch(IOException e){
            elStackTrArr = e.getStackTrace();
            if(elStackTrArr.length < 3){
                strReturn = null;
            } else {
                strReturn = elStackTrArr[2].getClassName();
            }
            if(strReturn != null)
            {
                strReturn = strReturn + "#" + elStackTrArr[2].getMethodName();
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
