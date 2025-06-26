package Assertions;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    
    @Test
    public void testBasicAssertions() {
        
        assertEquals("Addition should work correctly", 5, 2 + 3);
        
        
        assertTrue("5 should be greater than 3", 5 > 3);
        assertFalse("5 should not be less than 3", 5 < 3);
        
        
        assertNull("Null check failed", null);
        
                Object testObject = new Object();
        assertNotNull("Object should not be null", testObject);
    }
    
    @Test
    public void testArrayAndObjectAssertions() {
        
        int[] expectedNumbers = {1, 2, 3};
        int[] actualNumbers = {1, 2, 3};
        assertArrayEquals("Arrays should be identical", expectedNumbers, actualNumbers);
        
                String expectedString = "hello";
        String actualString = "hello";  // Same literal will be interned
        assertSame("Strings should reference the same object", expectedString, actualString);
        
        
        String newString = new String("hello");
        assertEquals("Strings should be equal in value", expectedString, newString);
    }
    
    
    public void testDivisionByZeroThrowsException() {
        
         int result = 10 / 0;
    }
    
    @Test
    public void testMultipleAssertions() {
        String firstName = "John";
        String lastName = "Doe";
        
        
        assertEquals("First name should be John", "John", firstName);
        assertEquals("Last name should be Doe", "Doe", lastName);
        assertTrue("Full name should be longer than 5 chars", 
                 (firstName + " " + lastName).length() > 5);
    }
    
    @Test
    public void testExceptionWithMessage() {
        try {
            int[] numbers = new int[5];
            int value = numbers[10];  
            fail("Should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index 10 out of bounds for length 5", e.getMessage());
        }
    }
}
