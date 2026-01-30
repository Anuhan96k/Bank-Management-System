package com.bank;

import com.bank.data.BankAccount;
import com.bank.service.Bank;
import com.bank.utility.InputUtils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice=0;
        Scanner sc=new Scanner(System.in);
        // We create these OUTSIDE the loop so they stay alive forever.
        Bank service = new Bank();

        // 2. THE HOLDER VARIABLE
        // We set it to null initially because no account exists yet.
        BankAccount myAccount = null;

        while(choice!=5)
        {

                System.out.println("-------------------------------");
                System.out.println("Welcome to The Bank....");
                System.out.println("-------------------------------");
                System.out.println("please select the corresponding digit for the operations");
                System.out.println("1.create account");
                System.out.println("2.Deposit amount");
                System.out.println("3.withdraw amount");
                System.out.println("4.display details");
                System.out.println("5.exit");
                System.out.println("-------------------------------");

                System.out.println("please enter your choice(1-5)...");

                choice=sc.nextInt();
                sc.nextLine();

                switch(choice)
                    {

                        case 1:

                            System.out.println("creating account....");
                            String name= InputUtils.readString("enter account holder name...");
                            double bal= InputUtils.readDouble("please deposit starting amount...");
                            boolean isAccountActive=true;
                             myAccount  = service.createAccount(name,bal,isAccountActive) ;
                            System.out.println(myAccount.getHoldername()+" your new account with account number"+myAccount.getAccountNumber()+"is created in the bank...");
                        break;
                        case 2:
                            if(myAccount!=null)
                            {
                                double amount = InputUtils.readDouble("enter amount to deposit...");
                                service.deposit(myAccount, amount);

                            }else
                            {
                                System.out.println("Create your account first....");
                            }
                            break;
                        case 3:
                            if(myAccount!=null)
                            {
                                double amount = InputUtils.readDouble("enter amount to withdraw...");
                                service.withdraw(myAccount, amount);

                            }else
                            {
                                System.out.println("Create your account first....");
                            }
                            break;
                        case 4:
                            if (myAccount!=null)
                            {
                                service.displayAccountDetails(myAccount);
                            }
                            else
                            {
                                System.out.println("Create your account first....");
                            }
                            break;

                        default:
                            System.out.println("other services are still in devlopment be patinet...");

                    }

        }

    }
}