import org.apache.log4j.Logger;

public class Example2 {

    private static final Logger logger = Logger.getLogger(Example2.class);

    public static void main(String[] args) {

        int a = 5;
        int b = 6;

        logger.debug("a = 5, b = 6");

        int result = a + b;

        logger.debug("a + b = " + result);
    }
}
