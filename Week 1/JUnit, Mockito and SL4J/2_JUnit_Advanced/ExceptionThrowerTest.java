import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                thrower::throwException
        );
        assertEquals("Invalid argument provided", exception.getMessage());
    }
}
