package clients;

import MoneyTarget.MoneyTarget;
import accounts.Account;
public class Client implements MoneyTarget {
    protected Account[] accounts;
    protected String name;
    protected int maxAccount;

    public Client(int maxAccount, String name) {
        this.maxAccount = maxAccount;
        this.name = name;
        accounts = new Account[maxAccount];
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(int amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].pay(amount)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getMaxAccount() {
        return maxAccount;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    @Override
    public boolean accept(int money) {
        boolean haveTrue = false;
        int count = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].add(money)) {
                haveTrue = true;
                count = i;
                break;
            } else {
                haveTrue = false;
            }
        }
        if (haveTrue) {
            System.out.println("Счет: " + accounts[count].getNameAccount() + " пополнен на " + money);
            System.out.println("Баланс счета: " + accounts[count].getBalance());
            return true;
        } else {
            System.out.println("Нет доступных счетов для пополнения");
            return false;
        }
    }
}



