package example.codeclan.com.java_comic_shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class TestCustomer {

    Customer customer1;
    StockItem stockItem1;
    StockItem stockItem2;
    StockItem stockItem3;
    ArrayList purchased;
    PaymentMethod debitCard;
    PaymentMethod creditCard;
    ArrayList paymentMethods;



    @Before
    public void before() {

        stockItem1 = new StockItem("Jaffa Cakes", 1.80);
        stockItem2 = new StockItem("Dynamite", 50.50);
        stockItem3 = new StockItem("Toilet roll", 1.20);
        purchased = new ArrayList<StockItem>();
        purchased.add(stockItem1);
        purchased.add(stockItem2);
        purchased.add(stockItem3);
        paymentMethods = new ArrayList<PaymentMethod>();
        debitCard = new PaymentMethod("debitCard", 108888, true, 100.00);
        creditCard = new PaymentMethod("creditCard", 999609, false, 50.00);
        paymentMethods.add(debitCard);
        paymentMethods.add(creditCard);

        customer1 = new Customer("Bawsa Ritchie", purchased, paymentMethods);
    }


    @Test
    public void testCustomerHasName() {
        assertEquals("Bawsa Ritchie", customer1.getName());
    }

    @Test
    public void testCustomerHasCash() {
        assertEquals(100.00, customer1.returnMethodBalance(debitCard), 0.01);
    }

    @Test
    public void testCustomerHasPurchases() {
        assertEquals(3, purchased.size());
    }

    @Test
    public void testCustomerHasPaymentMethods() {
        assertEquals(2, paymentMethods.size());
    }

}


