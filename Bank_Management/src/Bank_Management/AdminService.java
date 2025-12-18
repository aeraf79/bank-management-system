package Bank_Management;

import java.util.Map;
import java.util.Scanner;

public class AdminService {
    private Admin admin;
    private Map<String, User> users;
    private Scanner sc;

    public AdminService(Map<String, User> users) {
        this.admin = new Admin("admin", "admin123"); 
        this.users = users;
        this.sc = new Scanner(System.in);
    }

    
    public boolean adminLogin() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║             ADMIN LOGIN PANEL          ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("👤 Username: ");
        String username = sc.nextLine();
        System.out.print("🔑 Password: ");
        String password = sc.nextLine();

        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("\n✅ Admin login successful!");
            return true;
        } else {
            System.out.println("\n❌ Invalid admin credentials!");
            return false;
        }
    }

  
    public void createUser() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║              CREATE NEW USER           ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("👤 Username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("⚠️ Username already exists!");
            return;
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

        System.out.println("\n✅ User created successfully!");
    }

   
    public void viewAllUsers() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║             ALL REGISTERED USERS       ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users.values()) {
            System.out.println("-----------------------------------------");
            System.out.println("👤 Username: " + user.getUsername());
            System.out.println("📧 Email: " + user.getEmail());
            if (user.getAccount() != null) {
                System.out.println("💳 Account Number: " + user.getAccount().accountNumber);
                System.out.println("💰 Balance: ₹" + user.getAccount().getBalance());
            }
        }
        System.out.println("-----------------------------------------");
    }

    
    public void viewUser() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║              VIEW USER DETAILS         ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        User user = users.get(username);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        System.out.println("-----------------------------------------");
        System.out.println("👤 Username: " + user.getUsername());
        System.out.println("📧 Email: " + user.getEmail());
        if (user.getAccount() != null) {
            user.getAccount().displayDetails();
        }
        System.out.println("-----------------------------------------");
    }

  
    public void updateUser() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║              UPDATE USER DETAILS       ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        User user = users.get(username);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        System.out.println("1️⃣ Update Email");
        System.out.println("2️⃣ Update Password");
        System.out.println("3️⃣ Update Balance");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("New Email: ");
                String newEmail = sc.nextLine();
              
                System.out.println("✅ Email updated!");
                break;
            case 2:
                System.out.print("New Password: ");
                String newPassword = sc.nextLine();
                user.setPassword(newPassword);
                System.out.println("✅ Password updated!");
                break;
            case 3:
                System.out.print("New Balance: ");
                double newBalance = sc.nextDouble();
                user.getAccount().setBalance(newBalance);
                System.out.println("✅ Balance updated!");
                break;
            default:
                System.out.println("❌ Invalid choice!");
        }
    }

   
    public void deleteUser() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║               DELETE USER ACCOUNT      ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("❌ User not found!");
            return;
        }

        System.out.print("Are you sure? (yes/y to confirm): ");
        String confirm = sc.nextLine().trim();

        
        if (confirm.equalsIgnoreCase("yes") || confirm.equalsIgnoreCase("no")) {
            users.remove(username);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Delete cancelled.");
        }
    }
}
