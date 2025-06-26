package AAApatternfixtures;

import org.junit.*;
import static org.junit.Assert.*;

public class testclassusingAAApattern {
        private BankAccount account;
    private static final double INITIAL_BALANCE = 100.0;

    
    @Before
    public void setUp() {
        account = new BankAccount("ACC123", INITIAL_BALANCE);
        System.out.println("Test fixture initialized");
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        account = null;
        System.out.println("Test fixture cleaned up");
    }


    @Test
    public void depositShouldIncreaseBalance() {
        
        double depositAmount = 50.0;
        double expectedBalance = INITIAL_BALANCE + depositAmount;
        
        
        account.deposit(depositAmount);
        
        
        assertEquals("Balance should increase after deposit",
                    expectedBalance,
                    account.getBalance(),
                    0.001);
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void withdrawShouldThrowWhenOverdrawn() {
        
        double withdrawAmount = INITIAL_BALANCE + 1;
        
        
        account.withdraw(withdrawAmount);
    }
}