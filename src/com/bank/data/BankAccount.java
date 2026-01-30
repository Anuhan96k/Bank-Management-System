package com.bank.data;

import java.util.UUID;

public class BankAccount {
    private String accountNumber;
    private String holdername;
    private double Balance;
    private boolean isAccountActive ;

    public BankAccount(String holdername, double balance, boolean isAccountActive) {
        this.holdername = holdername;
        this.accountNumber = UUID.randomUUID().toString();//Universally Unique Identifier). It creates a professional, unique string like a1b2-c3d4....
        Balance = balance;
        this.isAccountActive = isAccountActive;
    }

    public String getHoldername() {
        return holdername;
    }

    public void setHoldername(String holdername) {
        this.holdername = holdername;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public boolean isAccountActive() {
        return isAccountActive;
    }

    public void setAccountActive(boolean accountActive) {
        isAccountActive = accountActive;
    }


}
