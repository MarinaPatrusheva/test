package accounts;

public class CheckingAccount extends Account {
    private final long minBalance = 0;
    protected String nameAccount = "Расчетный счет";

    public CheckingAccount(long balance, String name) {
        super(balance, name);
        if (balance < minBalance) {
            System.out.println("Баланс не может быть меньше " + minBalance);
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < minBalance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    @Override
    public boolean add(long amount) {
        if (balance > minBalance) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public String getNameAccount() {
        return nameAccount;
    }
}

