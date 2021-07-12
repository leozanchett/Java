package application;

import classes.Account;
import classes.BusinessAccount;
import classes.SavingAccount;

public class program {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Pedro", 1000.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        acc.withDraw(200);
        System.out.println(acc.getBalance());

        Account sv = new SavingAccount(3, "Leo", 1000.00, 1000.0);
        sv.withDraw(200);
        System.out.println(sv.getBalance());

        Account bs = new BusinessAccount(3 , "Bob", 1000.00, 250.0 );
        bs.withDraw(200);
        System.out.println(bs.getBalance());


        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(3 , "Bob", 0.0, 250.0 );
        //Account acc3 = new SavingAccount(5, "Perez", 0.0, 100.0);
        Account acc3 = new BusinessAccount(3 , "Bob", 0.0, 250.0 );

        // DOWNCASTING
        BusinessAccount acc4 =  (BusinessAccount)acc2; // cast
        acc4.loan(100.0);

        if(acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(100.0);
            System.out.println("Loan !");
        }
        if(acc3 instanceof SavingAccount){
            SavingAccount acc5 = (SavingAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update");
        }
    }
}
