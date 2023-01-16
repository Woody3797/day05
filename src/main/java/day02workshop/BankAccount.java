package day02workshop;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    
    private String name;
    private final String accNum;
    private double balance = 0.0;
    private List<String> transactions = new ArrayList<>();
    private boolean isActive = true;
    private Date creationDate;
    private Date closureDate;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccNum() {
        return accNum;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getClosureDate() {
        return closureDate;
    }
    public void setClosureDate(Date closureDate) {
        this.closureDate = closureDate;
    }

    public BankAccount(String name, String accNum, double balance, List<String> transactions, boolean isActive,
            Date creationDate, Date closureDate) {
        this.name = name;
        this.accNum = accNum;
        this.balance = balance;
        this.transactions = transactions;
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.closureDate = closureDate;
    }

    public BankAccount(String name, String accNum) {
        this.name = name;
        this.accNum = accNum;
    }

    public BankAccount(String accNum, double balance) {
        this.accNum = accNum;
        this.balance = balance;
    }

    public void showAccount() {
        System.out.println("Account number: " + accNum);
        System.out.println("Account name: " + name);
        System.out.println("Account balance: " + String.format("%.2f", balance));
    }

    @Override
    public String toString() {
        return "BankAccount [name=" + name + ", accNum=" + accNum + ", balance=" + balance + ", transactions="
                + transactions + ", isActive=" + isActive + ", creationDate=" + creationDate + ", closureDate="
                + closureDate + "]";
    }



    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("deposit $" + amount + " at " + LocalTime.now() + ", " + LocalDate.now());
            System.out.println(transactions.toString());
        } else if (!isActive) {
            throw new IllegalArgumentException("You cannot make a transfer to an inactive account.");
        } else {
            throw new IllegalArgumentException("Incorrect amount, unable to deposit.");
        }
    }

    public void withdraw(double amount) {
        if (!isActive) {
            throw new IllegalArgumentException("You cannot make a withdrawal from an inactive account.");
        } else if (amount < 0) {
            throw new IllegalArgumentException("Incorrect amount, unable to withdraw.");
        } else if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds, unable to withdraw.");
        } else {
            balance -= amount;
            transactions.add("withdraw $" + amount + " at " + LocalTime.now() + ", " + LocalDate.now());
            System.out.println(transactions.toString());
        }
    }
    
}
