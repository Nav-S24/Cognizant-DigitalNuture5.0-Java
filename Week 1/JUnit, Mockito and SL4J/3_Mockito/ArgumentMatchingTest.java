import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class ArgumentMatchingTest {
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.sendDataToApi("Hello World");

        // Exact match
        verify(mockApi).sendData("Hello World");

        // Matcher-based verification (any non-null string)
        verify(mockApi).sendData(anyString());

        // Matcher checking string content
        verify(mockApi).sendData(argThat(str -> str.startsWith("Hello")));
    }
}
