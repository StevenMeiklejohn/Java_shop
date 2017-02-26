package example.codeclan.com.java_comic_shop;

import java.util.ArrayList;


public class Shop {

    private String name;
    private ArrayList<StockItem> stock;
    private ArrayList<PaymentMethod> allPaymentMethods;
    private PaymentMethod chosenMethod;
    private String paymentType;
    private double cash;
    private double profit;
    private double loss;


    public Shop(String name, ArrayList<StockItem> stock, double cash, double profit, double loss) {
        this.name = name;
        this.stock = stock;
        this.cash = cash;
        this.profit = profit;
        this.loss = loss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<StockItem> getStock() {
        return stock;
    }

    public void setStock(ArrayList<StockItem> stock) {
        this.stock = stock;
    }

    public double getCash() {
        this.cash = Math.round(cash*1000)/1000;
        return cash;
    }

    public void makeSale(Customer customer, StockItem stockItem, PaymentMethod paymentType) {
        this.cash += stockItem.getPrice();
        this.profit += stockItem.getPrice();
        customer.spendMoney(paymentType, stockItem.getPrice());
        }


    public void giveRefund(Customer customer, StockItem stockItem, PaymentMethod paymentType) {
        this.loss += stockItem.getPrice();
        this.cash -= stockItem.getPrice();
        this.profit -= stockItem.getPrice();
        customer.receiveMoney(paymentType, stockItem.getPrice());
    }

    public double getProfit() {
        this.profit = Math.round(profit*100d)/100d;
        return profit;
    }

    public double getLoss() {
        this.loss = Math.round(loss*100d)/100d;
        return loss;
    }

    public String reportProfitLoss(){
        return "Profit: " + this.getProfit() + " Loss: " + this.getLoss();
    }

}

//    public void reportFinances
//
//    }

