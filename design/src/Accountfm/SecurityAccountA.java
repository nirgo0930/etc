package Accountfm;

public class SecurityAccountA extends Account {
    public SecurityAccountA() {
        balance = 0;
    }

    void withdrawal(int money) {
        System.out.println("Withdrawal : " + money);
        if (balance - money < 0) {
            System.out.println("Fail to Withdrawal, Over the limit!");
            return;
        }
        balance = balance - money;
    }
}
