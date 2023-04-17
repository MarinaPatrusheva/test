package accounts;

public class CreditAccount extends Account {
    private final long maxBalance = 0;
    protected String nameAccount = "Кредитный счет";

    public CreditAccount(long balance, String name) {
        super(balance, name);
        if (balance > maxBalance) {
            System.out.println("Баланс не может быть больше " + maxBalance);
        }

    }

    public boolean pay(long amount) {
        if (balance <= 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean add(long amount) {
        if (balance + amount > 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }
    }

    public String getNameAccount() {
        return nameAccount;
    }
}
