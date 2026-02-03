package com.bank.service;

import com.bank.data.BankAccount;
import java.util.ArrayList; // Import the List tool!

public class Bank {

    // 1. THE DATABASE: Holds all accounts safely
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // 2. CREATE: Auto-generates ID and saves to list
    public void createAccount(String holderName, double balance, String pin) {
        // Auto-ID: 1000, 1001, 1002...
        String newId = String.valueOf(1000 + accounts.size());

        BankAccount newAccount = new BankAccount(newId, holderName, balance, true, pin);

        // SAVE IT
        accounts.add(newAccount);

        System.out.println(" Account Created! ID: " + newId + " (Don't forget this!)");
    }

    // 3. SEARCH: Finds the account object using the ID string
    public BankAccount findAccount(String accountId) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountId)) {
                return acc;
            }
        }
        return null; // Not found
    }

    // 4. DEPOSIT: Finds user -> Checks PIN -> Adds Money
    public void deposit(String accountId, double amount, String pin) {
        BankAccount account = findAccount(accountId); // Find them first

        if (account == null) {
            System.out.println(" Error: Account ID not found.");
            return;
        }

        if (!account.checkPin(pin)) {
            System.out.println(" ACCESS DENIED: Incorrect PIN.");
            return;
        }

        if (amount > 0) {
            double newBal = account.getBalance() + amount;
            account.setBalance(newBal);
            System.out.println("Deposited: $" + amount + " | New Balance: $" + newBal);
        } else {
            System.out.println("Error: Positive amount required.");
        }
    }

    // 5. WITHDRAW
    public void withdraw(String accountId, double amount, String pin) {
        BankAccount account = findAccount(accountId);

        if (account == null) {
            System.out.println("Error: Account ID not found.");
            return;
        }

        if (!account.checkPin(pin)) {
            System.out.println(" ACCESS DENIED: Incorrect PIN.");
            return;
        }

        if (amount > 0 && amount <= account.getBalance()) {
            double newBal = account.getBalance() - amount;
            account.setBalance(newBal);
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + newBal);
        } else {
            System.out.println(" Error: Insufficient funds.");
        }
    }

    // 6. DETAILS
    public void displayDetails(String accountId, String pin) {
        BankAccount account = findAccount(accountId);

        if (account == null) {
            System.out.println(" Error: Account ID not found.");
            return;
        }

        if (!account.checkPin(pin)) {
            System.out.println(" ACCESS DENIED: Incorrect PIN.");
            return;
        }

        System.out.println("---  ACCOUNT DETAILS  ---");
        System.out.println("ID:      " + account.getAccountNumber());
        System.out.println("Holder:  " + account.getHoldername());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("---------------------------");
    }
}