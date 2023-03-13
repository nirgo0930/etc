package Accountfm;

public abstract class Account {
    protected int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        System.out.println("Deposit : " + money);
        balance = balance + money;
    }

    abstract void withdrawal(int money);
}