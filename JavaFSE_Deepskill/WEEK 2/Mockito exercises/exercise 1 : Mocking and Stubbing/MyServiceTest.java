package com.example.Mockito;  
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mocked Data");

        MyService service = new MyService(mockApi);
        assertEquals("Mocked Data", service.fetchData());
    }
}