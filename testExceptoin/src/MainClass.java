

public class MainClass {
    private static Object retObject(){
        String retS = "Except";
        return retS;
    }

    public static void main(String[] args) {
        Double b = (Double) MainClass.retObject();
    }
}
