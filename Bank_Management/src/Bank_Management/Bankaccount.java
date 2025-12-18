package Bank_Management;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bankaccount extends Account {
    private List<String> transactionHistory;  

    public Bankaccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    public void recordTransaction(String type, double amount) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        String entry = String.format("%-10s | ₹%-10.2f | %s", type, amount, dateTime);
        transactionHistory.add(entry);
    }

    // ✅ Print mini-statement
    public void printMiniStatement() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("                🧾 MINI STATEMENT 🧾");
        System.out.println("-----------------------------------------------------------");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.printf("%-10s | %-10s | %-20s%n", "Type", "Amount", "Date & Time");
            System.out.println("-----------------------------------------------------------");
            for (String entry : transactionHistory) {
                System.out.println(entry);
            }
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Current Balance: ₹" + balance);
    }
}
