package com.bank.service;
import com.bank.data.BankAccount;

public class Bank
{
    public  BankAccount createAccount(String holdername, double balance, boolean isAccountActive)
    {

        return new BankAccount(holdername, balance,isAccountActive);
    }

//    public void deposit(BankAccount account,double amount)
//    {
//        if(account.isAccountActive() ==true && amount>0)
//        {
//            InputUtils.readDouble("Please enter amount");
//            System.out.println("Amount"+amount+" successfully deposited...");
//        }
//        else if(!account.isAccountActive())
//        {
//            System.out.println("Your account Account NO:-"+account.getAccountNumber()+" is no longer active!");
//        }
//        else
//        {
//            System.out.println("please enter positive amount...");
//        }
//    }

    public void deposit(BankAccount account, double amount) {
        // 1. Check if active AND if amount is positive
        if (account.isAccountActive() && amount > 0) {

            // 2. MATH: Calculate new balance
            double currentBalance = account.getBalance();
            double updatedBalance = currentBalance + amount;

            // 3. UPDATE: Save the new balance back into the account object
            account.setBalance(updatedBalance);

            System.out.println("Successfully deposited: $" + amount);
            System.out.println("New Balance: $" + account.getBalance());

        } else if (!account.isAccountActive()) {
            System.out.println("Error: Account is inactive.");
        } else {
            System.out.println("Error: Please enter a positive amount.");
        }
    }


    public void displayAccountDetails(BankAccount account) {

        if (account == null) {
            System.out.println("Error: No account found to display.");
            return;
        }

        System.out.println("--- ACCOUNT DETAILS ---");
        System.out.println("ID:      " + account.getAccountNumber());
        System.out.println("Holder:  " + account.getHoldername());
        System.out.println("Balance: $" + account.getBalance());

        String status = account.isAccountActive() ? "Active" : "Inactive";
        System.out.println("Status:  " + status);
        System.out.println("-----------------------");
    }

    public void withdraw(BankAccount account,double amount)
    {
        if(account==null)
        {
            System.out.println("Your account is not Found!");
            return;
        }

        if(amount<=0)
        {
            System.out.println("Error: amount must be positive");
        }

        //check
        if (amount>account.getBalance())
        {
            System.out.println("Insufficent Balance");
        }
        else
        {
            double current_bal=account.getBalance();
            double updated_bal=current_bal-amount;

            account.setBalance(updated_bal);
            System.out.println("Amount = " + amount + " is succesfully withdrwan...");
            System.out.println("current balance is = " + current_bal);

        }
    }


}
