package com.bank;

import com.bank.service.Bank;
import com.bank.utility.InputUtils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bankService = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===  WELCOME TO THE JAVA BANK  ===");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Open Account ---");
                    String name = InputUtils.readString("Enter your Name:");
                    double bal = InputUtils.readDouble("Initial Deposit:");
                    String newPin = InputUtils.readString("Set your 4-digit PIN:");

                    bankService.createAccount(name, bal, newPin);
                    break;

                case 2:
                    System.out.println("\n--- Deposit ---");
                    String dId = InputUtils.readString("Enter Account ID:");
                    double dAmt = InputUtils.readDouble("Amount to Deposit:");
                    String dPin = InputUtils.readString("Enter PIN:");

                    bankService.deposit(dId, dAmt, dPin);
                    break;

                case 3:
                    System.out.println("\n--- Withdraw ---");
                    String wId = InputUtils.readString("Enter Account ID:");
                    double wAmt = InputUtils.readDouble("Amount to Withdraw:");
                    String wPin = InputUtils.readString("Enter PIN:");
                    bankService.withdraw(wId, wAmt, wPin);
                    break;

                case 4:
                    System.out.println("\n--- Check Details ---");
                    String cId = InputUtils.readString("Enter Account ID:");
                    String cPin = InputUtils.readString("Enter PIN:");
                    bankService.displayDetails(cId, cPin);
                    break;

                case 5:
                    System.out.println("Thank you for banking with us. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}