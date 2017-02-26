package example.codeclan.com.java_comic_shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;


public class TestShop {

    Shop shop;
    StockItem stockItem1;
    StockItem stockItem2;
    StockItem stockItem3;
    StockItem stockItem4;
    PaymentMethod creditCard;
    PaymentMethod debitCard;
    ArrayList stock;
    Customer customer1;
    ArrayList purchased;
    ArrayList paymentMethods;
    int price;


    @Before
    public void before(){
        stockItem1 = new StockItem("Jaffa Cakes", 1.80);
        stockItem2 = new StockItem("Dynamite", 50.50);
        stockItem3 = new StockItem("Toilet roll", 1.20);
        stockItem4 = new StockItem("Hacksaw", 10.00);
        creditCard = new PaymentMethod("Credit Card", 600333, true, 100.00);
        debitCard = new PaymentMethod("Debit Card", 100888, false, 50.00);
        paymentMethods = new ArrayList<PaymentMethod>();
        paymentMethods.add(creditCard);
        paymentMethods.add(debitCard);


        stock = new ArrayList<StockItem>();
        stock.add(stockItem1);
        stock.add(stockItem2);
        stock.add(stockItem3);
        purchased = new ArrayList<StockItem>();
        purchased.add(stockItem4);
        customer1 = new Customer("Bob Scratchit", purchased, paymentMethods);
        shop = new Shop("Rumble-Belows",stock, 2000.00, 0.00, 0.00);
    }

    @Test
    public void testShopHasName(){
        assertEquals("Rumble-Belows", shop.getName());
    }

    @Test
    public void testShopCash(){
        assertEquals(2000.00, shop.getCash(), 0.01);
    }

    @Test
    public void testShopHasStock(){
        assertEquals(3, stock.size());
    }

    @Test
    public void testMakeSale(){
        shop.makeSale(customer1, stockItem4, creditCard );
        assertEquals(2010.00, shop.getCash(), 0.01);
        assertEquals(90.00, customer1.returnMethodBalance(creditCard));
    }

    @Test
    public void testGiveRefund(){
        shop.giveRefund(customer1, stockItem4, creditCard);
        assertEquals(1990, shop.getCash(), 0.01);
        assertEquals(110, customer1.returnMethodBalance(creditCard), 0.01);
    }

    @Test
    public void testProfit(){
        shop.makeSale(customer1, stockItem4, creditCard);
        shop.makeSale(customer1, stockItem3, creditCard);
        shop.giveRefund(customer1, stockItem4, creditCard);
        assertEquals(1.20, shop.getProfit(), 0.01);
        assertEquals(10.00, shop.getLoss(), 0.01);
    }

    @Test
    public void testReportFinances(){
        shop.makeSale(customer1, stockItem4, creditCard);
        shop.makeSale(customer1, stockItem3, creditCard);
        shop.giveRefund(customer1, stockItem4, creditCard);
        assertEquals("Profit: 1.2 Loss: 10.0", shop.reportProfitLoss());
    }
}
