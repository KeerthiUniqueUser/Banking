package model;

public class Account {
    private int accountNumber;
    private String name;
    private String pin;
    private double balance;

    public Account(int accountNumber, String name, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    // Getters & Setters
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
}
