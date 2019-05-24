

public class MainClass {
    private static Object retObject(){
        String retS = "Except";
        return retS;
    }

    public static void main(String[] args) {

        String a = "Hello world";
        Double b = (Double) MainClass.retObject();
    }
}
