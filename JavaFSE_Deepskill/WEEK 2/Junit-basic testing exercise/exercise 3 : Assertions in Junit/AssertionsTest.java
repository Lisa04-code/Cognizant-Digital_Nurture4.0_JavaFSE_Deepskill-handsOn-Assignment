package Assertions;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    
    @Test
    public void testBasicAssertions() {
        // Test equality with message (expected, actual)
        assertEquals("Addition should work correctly", 5, 2 + 3);
        
        // Test boolean conditions with messages
        assertTrue("5 should be greater than 3", 5 > 3);
        assertFalse("5 should not be less than 3", 5 < 3);
        
        // Test null checks
        assertNull("Null check failed", null);
        
        // Test not null
        Object testObject = new Object();
        assertNotNull("Object should not be null", testObject);
    }
    
    @Test
    public void testArrayAndObjectAssertions() {
        // Test array equality
        int[] expectedNumbers = {1, 2, 3};
        int[] actualNumbers = {1, 2, 3};
        assertArrayEquals("Arrays should be identical", expectedNumbers, actualNumbers);
        
        // Test object identity
        String expectedString = "hello";
        String actualString = "hello";  // Same literal will be interned
        assertSame("Strings should reference the same object", expectedString, actualString);
        
        // Test object equality (different references but equal content)
        String newString = new String("hello");
        assertEquals("Strings should be equal in value", expectedString, newString);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZeroThrowsException() {
        // This should throw ArithmeticException
         int result = 10 / 0;
    }
    
    @Test
    public void testMultipleAssertions() {
        String firstName = "John";
        String lastName = "Doe";
        
        // Sequential assertions
        assertEquals("First name should be John", "John", firstName);
        assertEquals("Last name should be Doe", "Doe", lastName);
        assertTrue("Full name should be longer than 5 chars", 
                 (firstName + " " + lastName).length() > 5);
    }
    
    @Test
    public void testExceptionWithMessage() {
        try {
            int[] numbers = new int[5];
            int value = numbers[10];  // This should throw ArrayIndexOutOfBoundsException
            fail("Should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index 10 out of bounds for length 5", e.getMessage());
        }
    }
}
