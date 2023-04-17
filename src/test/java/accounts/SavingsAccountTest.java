package accounts;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    SavingsAccount savingsAccount = new SavingsAccount(150, "Irina", 50);
    int balance = 150;
    int minBalance = 50;
    int amount = 20;
    @org.junit.jupiter.api.Test
    void pay() {
        boolean expect = balance < minBalance ? false : true;
        if(expect){
            balance -= amount;
        }
        boolean result = savingsAccount.pay(20);
        Assertions.assertEquals(expect, result);
        Assertions.assertEquals(balance, savingsAccount.balance);
    }

    @org.junit.jupiter.api.Test
    void add() {
        boolean expect = balance > minBalance ? true : false;
        if(expect){
            balance += amount;
        }
        boolean result = savingsAccount.add(20);
        Assertions.assertEquals(expect, result);
        Assertions.assertEquals(balance, savingsAccount.balance);
    }

    @org.junit.jupiter.api.Test
    void getNameAccount() {
        String expect = "Irina";
        Assertions.assertEquals(expect, savingsAccount.name);
    }
}