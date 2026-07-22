import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;

public class VoidMethodsTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the void method to do nothing (this is the default,
        // but shown explicitly here with doNothing())
        doNothing().when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);
        service.sendDataToApi("Test Data");

        verify(mockApi).sendData("Test Data");
    }
}
