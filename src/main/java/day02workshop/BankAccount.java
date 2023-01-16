package day02workshop;

import java.sql.Date;
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

    

    
}
