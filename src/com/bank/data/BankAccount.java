package com.bank.data;

public class BankAccount {

    private String accountNumber;
    private String holdername;
    private double balance;
    private boolean isAccountActive;
    private String pin;

    public BankAccount(String accountNumber, String holdername, double balance, boolean isAccountActive, String pin) {
        this.accountNumber = accountNumber; // We trust the ID the Bank gives us
        this.holdername = holdername;
        this.balance = balance;
        this.isAccountActive = isAccountActive;
        this.pin = pin;
    }

    // --- Getters and Setters ---
    public String getHoldername() { return holdername; }
    public String getAccountNumber() { return accountNumber; }

    public double getBalance() { return balance; }
    // Important: The Bank Service needs this to update money!
    public void setBalance(double balance) { this.balance = balance; }

    public boolean isAccountActive() { return isAccountActive; }

    // --- Security Methods ---
    public boolean checkPin(String inputPin) {
        return this.pin.equals(inputPin);
    }
}