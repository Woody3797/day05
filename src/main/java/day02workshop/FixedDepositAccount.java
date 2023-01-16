package day02workshop;

import java.sql.Date;
import java.util.List;

public class FixedDepositAccount extends BankAccount {

    public static double interest = 3.0;
    public static double duration = 6.0;

    public FixedDepositAccount(String accNum, double balance) {
        super(accNum, balance);
    }

    public FixedDepositAccount(String name, String accNum, double balance, List<String> transactions, boolean isActive,
            Date creationDate, Date closureDate) {
        super(name, accNum, balance, transactions, isActive, creationDate, closureDate);
    }

    public FixedDepositAccount(String name, String accNum) {
        super(name, accNum);
    }


    @Override
    public void deposit(double amount) {
        System.out.println("No deposit operation");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("No withdrawal operation");
    }

    @Override
    public void showAccount() {
        System.out.println("Account number: " + this.getAccNum());
        System.out.println("Account name: " + this.getName());
        System.out.println("Account balance: " + String.format("%.2f", (this.getBalance() * (100+interest)/100)));
    }

}
