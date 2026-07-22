import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Navya";
        int loginAttempts = 3;

        // Single parameter
        logger.info("User {} logged in", userName);

        // Multiple parameters
        logger.warn("User {} failed login {} times", userName, loginAttempts);

        // Parameterized logging avoids the cost of string concatenation
        // when the log level is disabled, since SLF4J only builds the
        // final message if the level is actually enabled.
        int orderId = 1024;
        double amount = 599.99;
        logger.debug("Order {} processed with amount {}", orderId, amount);

        // Logging an exception with a parameterized message
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Failed to process order {} due to: {}", orderId, e.getMessage(), e);
        }
    }
}
