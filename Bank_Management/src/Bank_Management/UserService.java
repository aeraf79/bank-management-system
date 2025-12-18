package Bank_Management;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserService {
    private Map<String, User> users;
    private Scanner sc;

    public UserService() {
        users = new HashMap<>();
        sc = new Scanner(System.in);
    }

    // For admin access
    public Map<String, User> getUsers() {
        return users;
    }

    
    public boolean register() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║           USER REGISTRATION            ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("👤 Username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("⚠️ Username already exists!");
            return false;
        }

        System.out.print("🔑 Password: ");
        String password = sc.nextLine();
        System.out.print("📧 Email: ");
        String email = sc.nextLine();
        System.out.print("🏦 Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("💳 Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("💰 Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        User newUser = new User(username, password, email);
        Bankaccount newAccount = new Bankaccount(name, accNo, balance);
        newUser.setAccount(newAccount);
        users.put(username, newUser);

        System.out.println("\n✅ Registration successful!");
        return true;
    }


    public User login() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║               USER LOGIN               ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("👤 Username: ");
        String username = sc.nextLine();
        System.out.print("🔑 Password: ");
        String password = sc.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("\n✅ Login successful! Welcome " + username + "!");
            return user;
        } else {
            System.out.println("\n❌ Invalid username or password!");
            return null;
        }
    }

  
    public boolean changePassword(String username) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║             CHANGE PASSWORD            ║");
        System.out.println("╚════════════════════════════════════════╝");

        User user = users.get(username);
        if (user == null) {
            System.out.println("❌ User not found!");
            return false;
        }

        System.out.print("Current Password: ");
        String currentPassword = sc.nextLine();

        if (!user.getPassword().equals(currentPassword)) {
            System.out.println("⚠️ Wrong current password!");
            return false;
        }

        System.out.print("New Password: ");
        String newPassword = sc.nextLine();
        user.setPassword(newPassword);
        System.out.println("✅ Password changed successfully!");
        return true;
    }
}
