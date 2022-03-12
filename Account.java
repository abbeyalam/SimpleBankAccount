package com.techelevator;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Account {

    //Class Variables
    int balance;
    int previousTransaction;
    String customerId;
    String customerName;

    //Class constructor
    public Account(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    //Method for depositing money
    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        } else {
            System.out.println("Funds need to be positive");
        }
    }

    //Method for withdrawing money
    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("You do not have enough funds");
        }
    }

    //Method for viewing the previous transaction
    public void viewPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("You've deposited " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("You've withdrawn " + Math.abs(previousTransaction));
        } else {
            System.out.println("You have no previous transactions");
        }
    }

    //Method for checking balance after transaction
    public int checkBalance() {
        return balance;
    }

    //Method for calculating interest
    public void calcInterest(int years) {
        double intRate = 0.0185;
        double newBalance = (balance * intRate * years) + balance;
        System.out.println("The current interest rate is " + Math.round(100 * intRate) + "%");
        System.out.println("After " + years + " "+ " years, your new balance will be: $" + newBalance);
    }

    //Method for menu
    public void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!" + " Customer Id: " + customerId);
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A: Check Balance");
        System.out.println("B: Deposit Money");
        System.out.println("C: Withdraw Money");
        System.out.println("D: View Previous Transaction");
        System.out.println("E: Calculate Interest");
        System.out.println("F: Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Check user balance
                case 'A':
                    System.out.println("===========================");
                    System.out.println("Balance = $ " + balance);
                    System.out.println("===========================");
                    System.out.println();
                    break;
                //Deposit Money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("Balance = $ " + balance);
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("Balance = $ " + balance);
                    break;
                case 'D':
                    System.out.println("========================");
                    viewPreviousTransaction();
                    System.out.println("========================");
                    break;
                case 'E':
                    System.out.println(" Enter how many years of accrued interest: ");
                    int years = sc.nextInt();
                    calcInterest(years);
                    break;
                case 'F':
                    System.out.println("========================");
                    break;

                default:
                    System.out.println("Please enter a valid option");
                    break;
            }

        } while(option != 'F');
    }
}
