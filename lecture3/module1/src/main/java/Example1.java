import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1 {

    private static final Logger logger
            = LoggerFactory.getLogger(Example1.class);

    public static void main(String[] args) {

        int a = 4;
        logger.debug("a = {}", a);

        int b = 5;
        logger.debug("b = {}", b);

        int result = a + b;
        logger.debug("a + b = {}", result);

        User user = new User("di", "go");
        logger.debug("created : {}", user);
    }
}
