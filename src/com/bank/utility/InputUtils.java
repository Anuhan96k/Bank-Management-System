package com.bank.utility;

import com.bank.data.BankAccount;
import com.bank.service.Bank;

import java.util.Scanner;

public class InputUtils
{
    public final static Scanner sc = new Scanner(System.in);

    public static String readString(String message) {

        System.out.println(message);
        return sc.nextLine();
    }

    public static double readDouble(String message)
    {
        System.out.println(message);
        return sc.nextDouble();
    }
    public void askForStartingBal(BankAccount account, double amount,Bank bank)
    {
        System.out.println("deposit starting balance...");
        bank.deposit(account,amount);
    }
}
