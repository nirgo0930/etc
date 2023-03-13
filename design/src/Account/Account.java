package Account;

public abstract class Account {
    protected int balance;

    abstract void withdrawal(int money);

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        System.out.println("Deposit : " + money);
        balance = balance + money;
    }
}