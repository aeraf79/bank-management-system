package Bank_Management;

import java.util.Scanner;

public class Bankmain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        AdminService adminService = new AdminService(userService.getUsers());
        Bankservice bankService = new Bankservice();
        User currentUser = null;

        
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║           🌟 WELCOME TO NATIONAL BANK OF INDIA 🌟        ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║     Your Trust, Our Priority 💰 | Serving Since 1998 🏦  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();

        while (true) {
            if (currentUser == null) {
                // Main Menu
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║              MAIN MENU               ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║ 1. User Register                     ║");
                System.out.println("║ 2. User Login                        ║");
                System.out.println("║ 3. Admin Login                       ║");
                System.out.println("║ 4. Exit                              ║");
                System.out.println("╚══════════════════════════════════════╝");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        currentUser = userService.login();
                        break;
                    case 3:
                        if (adminService.adminLogin()) {
                            adminMenu(adminService, sc);
                        }
                        break;
                    case 4:
                        printExitBanner();
                        System.exit(0);
                    default:
                        System.out.println("⚠️ Invalid choice! Please try again.");
                }
            } else {
                // User Menu
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║              BANK MENU               ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║ 1. Deposit                           ║");
                System.out.println("║ 2. Withdraw                          ║");
                System.out.println("║ 3. Check Balance                     ║");
                System.out.println("║ 4. Calculate Loan                    ║");
                System.out.println("║ 5. Account Details                   ║");
                System.out.println("║ 6. Change Password                   ║");
                System.out.println("║ 7. Logout                            ║");
                System.out.println("╚══════════════════════════════════════╝");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        bankService.deposit(currentUser.getAccount());
                        break;
                    case 2:
                        bankService.withdraw(currentUser.getAccount());
                        break;
                    case 3:
                        bankService.checkBalance(currentUser.getAccount());
                        break;
                    case 4:
                        bankService.calculateLoan(currentUser.getAccount());
                        break;
                    case 5:
                        currentUser.getAccount().displayDetails();
                        break;
                    case 6:
                        userService.changePassword(currentUser.getUsername());
                        break;
                    case 7:
                        currentUser = null;
                        System.out.println("✅ Logged out successfully!");
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice! Please try again.");
                }
            }
        }
    }

    // 🧾 Admin Menu (styled)
    private static void adminMenu(AdminService adminService, Scanner sc) {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║              ADMIN MENU              ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Create User                       ║");
            System.out.println("║ 2. View All Users                    ║");
            System.out.println("║ 3. View Single User                  ║");
            System.out.println("║ 4. Update User                       ║");
            System.out.println("║ 5. Delete User                       ║");
            System.out.println("║ 6. Back to Main Menu                 ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    adminService.createUser();
                    break;
                case 2:
                    adminService.viewAllUsers();
                    break;
                case 3:
                    adminService.viewUser();
                    break;
                case 4:
                    adminService.updateUser();
                    break;
                case 5:
                    adminService.deleteUser();
                    break;
                case 6:
                    return; // Back to Main Menu
                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }

    // 🙏 Exit Banner
    private static void printExitBanner() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     🙏 THANK YOU FOR BANKING WITH US 🙏              ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println("We value your trust — visit again soon!");
    }
}
