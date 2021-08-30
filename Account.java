// Name: Eugene
// ID: 1351553

/*A account class that contains information about one bank account
* */
public class Account {
//    a key to uniquely identify this bank account
    private int key_ = 0;
//    the amount of money this account has
    private double balance_ = 0.0;

    public enum trans_type {deposit, withdraw, closure}
//    the constructor to initialise a new bank account
    public Account(int key, double balance) {
        this.key_ = key;
        this.balance_ = balance;
    }
//    a method that returns the key of the current bank account
    public int getKey() {
        return  key_;
    }

//    a method that return the current balance of the current bank account
    public double getBalance() {
        return balance_;
    }

//    a method that sets the balance of an account
//    based on the transaction type
    public void setBalance(double amount) {
        balance_ += amount;
    }
}
