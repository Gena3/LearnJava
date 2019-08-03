import java.util.logging.*;

public class ClassB {
    private static final Logger logger = Logger.getLogger(ClassB.class.getName());
    public static void SomeFunction(){
        logger.fine("ClassB fine message");
    }
}
