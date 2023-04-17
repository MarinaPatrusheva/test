package accounts;

import MoneyTarget.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String name;
    protected long minBalance;
    protected String nameAccount;

    public Account(long balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public boolean transfer(Account accountTo, int amount) {
        if (pay(amount)) {
            if (accountTo.add(amount)) {
                System.out.println("Операция прошла успешно " + getNameAccount() + " " + balance + " -> " + accountTo.getNameAccount() + " " + accountTo.balance);
                return true;
            } else {
                add(amount);
                System.out.println("Ошибка! Операция не выполнена " + getNameAccount() + " " + balance + " -> " + accountTo.getNameAccount() + " " + accountTo.balance);
                return false;
            }
        } else {
            System.out.println("Ошибка! Операция не выполнена " + getNameAccount() + " " + balance + " -> " + accountTo.getNameAccount() + " " + accountTo.balance);
            return false;
        }
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean accept(int money) {
        if (add(money)) {
            return true;
        } else {
            return false;
        }
    }

    public String getNameAccount() {
        return nameAccount;
    }

}
