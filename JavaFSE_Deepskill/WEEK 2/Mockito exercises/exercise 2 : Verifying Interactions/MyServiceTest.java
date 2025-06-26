package com.example1.Mockito1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    void setUp() {
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    void fetchData_ReturnsMockedData() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mocked Data");

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mocked Data", result);
        verify(mockApi).getData();
    }

    @Test
    void processAndSave_ValidInput_ReturnsTrue() {
        // Arrange
        when(mockApi.saveData(anyString())).thenReturn(true);

        // Act
        boolean result = service.processAndSave("test");

        // Assert
        assertTrue(result);
        verify(mockApi).saveData("TEST"); // Verify uppercase conversion
    }
}
