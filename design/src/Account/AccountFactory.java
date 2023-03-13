package Account;

public class AccountFactory {
    public Account createAccount(String type) {
        System.out.println("Account Name : " + type);

        Account account = null;
        if (type.equals("Minus")) {
            account = new MinusAccount();
        } else if (type.equals("Normal")) {
            account = new NormalAccount();
        } else if (type.equals("Security")) {
            account = new SecurityAccount();
        }
        return account;
    }
}
