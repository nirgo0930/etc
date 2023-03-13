package Accountfm;

public abstract class Bank {
    public Account orderAccount(String type) {
        Account account;
        account = createAccount(type);
        account.deposit(1000);
        account.withdrawal(2000);
        return account;
    }

    abstract public Account createAccount(String item);
}
