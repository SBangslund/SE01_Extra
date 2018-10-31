package extra_04;

/**
 *
 * @author Samuel Bangslund
 */
public class Customer {

    private final String NAME;
    private final int ID;
    private double balance;

    public Customer(String name, int id) {
        this.NAME = name;
        this.ID = id;
    }

    public Customer(String name, int id, double balance) {
        this.NAME = name;
        this.ID = id;
        this.balance = balance;
    }

    /**
     * Deposit an amount to balance.
     *
     * @param amount to deposit.
     */
    public void deposit(double amount) {
        balance += amount >= 0 ? amount : 0;
    }

    /**
     * Withdraw an amount from balance.
     *
     * @param amount to withdraw.
     */
    public void withdraw(double amount) {
        balance -= amount >= 0 && balance > amount ? amount : 0;
    }

    public double getBalance() {
        return balance;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return NAME;
    }
}
