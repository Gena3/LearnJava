import java.util.logging.*;

public class ClassA {
    private static final Logger logger = Logger.getLogger(ClassB.class.getName());
    public static void SomeFunction(){
        logger.info("ClassA info message");
    }
}