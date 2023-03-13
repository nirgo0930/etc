package Accountfm;

public class MinusAccountB extends Account {
    public MinusAccountB() {
        balance = 0;
    }

    void withdrawal(int money) {
        System.out.println("Withdrawal : " + money);
        int max = -1000;
        if (balance - money < max) {
            System.out.println("Fail to Withdrawal, Over the limit!");
            return;
        }
        balance = balance - money;
    }
}
