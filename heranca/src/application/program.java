package application;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class program {
    public static void main(String[] args) {
        //Account acc1 = new Account(1001, "Alex", 1000.0);
        Account acc2 = new SavingAccount(1002, "Bob", 1000.0, 500.0);
        Account acc3 = new BusinessAccount(10003,"Leo", 50000.00, 5.000);

        acc2.withDraw(300);
        System.out.println(acc2.getBalance());

        List<Account> lista = new ArrayList<>();

        lista.add(acc2);
        lista.add(acc3);

        double sum = 0.0;
        for(Account conta : lista){
            conta.deposit(10);
            sum += conta.getBalance();
        }
        System.out.printf("Total Balance %.2f%n", sum);
    }
}
