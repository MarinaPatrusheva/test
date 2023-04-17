import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(3, "George");
        Account credit = new CreditAccount(0, client.getName());
        Account saving = new SavingsAccount(125, client.getName(), 20);
        Account checking = new CheckingAccount(222, client.getName());
        client.add(credit);
        client.add(saving);
        client.add(checking);
        for (int i = 0; i < client.getAccounts().length; i++) {
            System.out.println("Баланс :" + client.getAccounts()[i].getBalance() + "Имя :" + client.getAccounts()[i].getName());
        }
        client.getAccounts()[0].transfer(checking, 22);
        client.getAccounts()[1].transfer(credit, 100);
        client.getAccounts()[2].transfer(saving, 254);
        client.getAccounts()[0].transfer(saving, 50);
        client.accept(99);

    }
}