package Bank_Management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bankservice {
    private Scanner sc = new Scanner(System.in);

    // ✅ Deposit money and record transaction
    public void deposit(Bankaccount account) {
        try {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║           DEPOSIT MENU         ║");
            System.out.println("╚════════════════════════════════╝");

            System.out.println("1. Cash Deposit");
            System.out.println("2. Cheque Deposit");
            System.out.print("Enter sub-choice: ");
            int depChoice = sc.nextInt();
            System.out.print("Enter amount to deposit: ₹");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount entered!");
                return;
            }

            if (depChoice == 1) {
                System.out.println("Cash deposit selected.");
            } else if (depChoice == 2) {
                System.out.println("Cheque deposit selected.");
            } else {
                System.out.println("Invalid deposit type.");
                return;
            }

            account.setBalance(account.getBalance() + amount);
            account.recordTransaction("Deposit", amount); // ✅ Record transaction
            System.out.println("Deposit Successful. New Balance: ₹" + account.getBalance());

        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please enter numbers only.");
            sc.nextLine(); // clear invalid input buffer
        }
    }

    // ✅ Withdraw money with optional PIN check and record transaction
    public void withdraw(Bankaccount account) {
        try {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║          WITHDRAW MENU         ║");
            System.out.println("╚════════════════════════════════╝");

            System.out.println("1. ATM Withdrawal");
            System.out.println("2. Bank Withdrawal");
            System.out.print("Enter sub-choice: ");
            int witChoice = sc.nextInt();

           
            if (witChoice == 1) {
                System.out.print("Enter your 4-digit ATM PIN: ");
                int pin = sc.nextInt();
                if (pin != 1234) { 
                    System.out.println("Incorrect PIN. Transaction cancelled!");
                    return;
                }
            }

            System.out.print("Enter amount to withdraw: ₹");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                return;
            }

            if (amount > account.getBalance()) {
                System.out.println("Insufficient Balance!");
                return;
            }

            account.setBalance(account.getBalance() - amount);
            account.recordTransaction("Withdraw", amount); // ✅ Record transaction
            System.out.println("Withdrawal Successful. New Balance: ₹" + account.getBalance());

        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please enter numeric values only.");
            sc.nextLine(); // clear invalid input
        }
    }

    // ✅ Balance + Mini Statement options
    public void checkBalance(Bankaccount account) {
        try {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         BALANCE OPTIONS        ║");
            System.out.println("╚════════════════════════════════╝");

            System.out.println("1. View Balance");
            System.out.println("2. Mini Statement");
            System.out.print("Enter sub-choice: ");
            int balChoice = sc.nextInt();

            switch (balChoice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    account.printMiniStatement(); // ✅ Print actual recorded history
                    break;
                default:
                    System.out.println("Invalid sub-choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input! Please enter numbers only.");
            sc.nextLine();
        }
    }

    // ✅ Loan calculation feature (same as before)
    public void calculateLoan(Bankaccount account) {
        try {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║           LOAN MENU            ║");
            System.out.println("╚════════════════════════════════╝");

            System.out.println("1. Personal Loan (12%)");
            System.out.println("2. Home Loan (8.5%)");
            System.out.print("Enter sub-choice: ");
            int type = sc.nextInt();

            System.out.print("Enter loan amount: ₹");
            double loan = sc.nextDouble();
            System.out.print("Enter loan duration (in years): ");
            int years = sc.nextInt();

            if (loan <= 0 || years <= 0) {
                System.out.println("❌ Invalid loan amount or duration!");
                return;
            }

            double rate = (type == 1) ? 12.0 : 8.5;

            double totalAmount = loan * Math.pow((1 + rate / 100), years);
            double interest = totalAmount - loan;

            System.out.println("--------------------------------------------------");
            System.out.println("Loan Type           : " + (type == 1 ? "Personal Loan" : "Home Loan"));
            System.out.println("Principal Amount     : ₹" + String.format("%.2f", loan));
            System.out.println("Rate of Interest     : " + rate + "% (Compound Interest)");
            System.out.println("Loan Duration        : " + years + " years");
            System.out.println("--------------------------------------------------");
            System.out.println("Total Interest Payable : ₹" + String.format("%.2f", interest));
            System.out.println("Total Amount to Repay  : ₹" + String.format("%.2f", totalAmount));
            System.out.println("--------------------------------------------------");

        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input! Please enter valid numeric data.");
            sc.nextLine();
        }
    }

}
