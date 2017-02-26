package example.codeclan.com.java_comic_shop;

import java.util.ArrayList;

/**
 * Created by user on 24/02/2017.
 */
public class Customer {

    private String name;
    private PaymentMethod selectedPayment;
    private ArrayList<StockItem> purchased;
    private ArrayList<PaymentMethod> paymentMethods;
    double balance;


    public Customer(String name, ArrayList<StockItem> purchased, ArrayList<PaymentMethod>paymentMethods){
        this.name = name;
        this.purchased = purchased;
        this.paymentMethods = paymentMethods;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<StockItem>getPurchased() {
        return purchased;
    }

    public ArrayList<PaymentMethod>getPaymentMethods() {
        return paymentMethods;
    }

    public double returnMethodBalance(PaymentMethod selectedPayment){
        balance = 0;
        for (PaymentMethod method : this.paymentMethods){
            if(selectedPayment.getName() == method.getName()){
                balance = method.getBalance();
            }
        }
        return balance;
    }

    public void spendMoney(PaymentMethod selectedPayment, double amount){
        for (PaymentMethod method : this.paymentMethods){
            if(selectedPayment.getName() == method.getName()){
                method.spendMoney(amount);
            }
        }
    }


    public void receiveMoney(PaymentMethod selectedPayment, double amount){
        for (PaymentMethod method : this.paymentMethods){
            if(selectedPayment.getName() == method.getName()){
                method.receiveMoney(amount);
            }
        }
    }



}

