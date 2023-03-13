package Account;

public class Bank {
    AccountFactory accountFactory;

    public Bank(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public Account orderAccount(String type) {
        Account account;
        account = accountFactory.createAccount(type);
        account.deposit(1000);
        account.withdrawal(2000);
        return account;
    }
}
