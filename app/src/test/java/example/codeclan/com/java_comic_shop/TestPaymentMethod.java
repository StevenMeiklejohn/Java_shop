package example.codeclan.com.java_comic_shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by user on 26/02/2017.
 */
public class TestPaymentMethod {

    PaymentMethod debitCard;
    double balance;

    @Before
    public void before(){
        debitCard = new PaymentMethod("debit card", 888888, true, 300.50);
    }

    @Test
    public void testHasName(){
        assertEquals("debit card", debitCard.getName());
    }

    @Test
    public void testHasAccountNumber(){
        assertEquals(888888, debitCard.getAccountNumber());
    }

    @Test
    public void testIsDefault(){
        assertEquals(true, debitCard.isMethodDefault());
    }

    @Test
    public void testHasBalance(){
        assertEquals(300.50, debitCard.getBalance(), 0.01);
    }
}
