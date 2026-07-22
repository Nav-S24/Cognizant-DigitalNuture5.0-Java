import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Note: logback.xml (included alongside this file) must be placed on the
// classpath -- typically src/main/resources/logback.xml -- for these
// appenders to take effect.
public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        // These messages will be written to BOTH the console appender
        // and the file appender ("app.log"), as configured in logback.xml.
        logger.debug("Debug message: application starting up");
        logger.info("Info message: application initialized");
        logger.warn("Warning message: low disk space detected");
        logger.error("Error message: failed to connect to database");
    }
}
