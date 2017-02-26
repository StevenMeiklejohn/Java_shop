package example.codeclan.com.java_comic_shop;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class TestStockItem {

    StockItem stockItem1;


    @Before
    public void before(){
        stockItem1 = new StockItem("Jaffa Cakes", 1.50);
    }

    @Test
    public void testHasName(){
        assertEquals("Jaffa Cakes", stockItem1.getName());
    }

    @Test
    public void testHasPrice(){
        assertEquals(1.50, stockItem1.getPrice(), 0.01);
    }




}
