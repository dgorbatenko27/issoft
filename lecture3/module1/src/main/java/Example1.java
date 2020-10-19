import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1 {

    private static final Logger logger
            = LoggerFactory.getLogger(Example1.class);

    public static void main(String[] args) {

        int a = 4;
//        System.out.println("a = 4");
        logger.debug("a = {}", a);

        int b = 5;
//        System.out.println("b = 5");
        logger.info("b = {}", b);

        int result = a + b;
//        System.out.println("a + b = " + result);
        logger.info("a + b = {}", result);

    }
}
