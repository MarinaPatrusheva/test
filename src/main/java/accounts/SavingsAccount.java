package accounts;

public class SavingsAccount extends Account {
    private long minBalance;
    protected String nameAccount = "Сберегательный счет";

    public SavingsAccount(long balance, String name, long minBalance) {
        super(balance, name);
        this.minBalance = minBalance;
        if (balance < minBalance) {
            System.out.println("Баланс не может быть ниже " + minBalance);
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance < minBalance) {
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

