package example.codeclan.com.java_comic_shop;


public class PaymentMethod {

    private String name;
    private int accountNumber;
    boolean isDefault;
    double balance;

    public PaymentMethod(String name, int accountNumber, boolean isDefault, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.isDefault = isDefault;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isMethodDefault(){
        return isDefault;
    }



    public void spendMoney(double amount){
        this.balance -= amount;
    }

    public void receiveMoney(double amount){
        this.balance += amount;
    }
}

