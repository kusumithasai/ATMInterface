import java.util.*;

public class ATMInterface {
    static Scanner sc = new Scanner(System.in);
    static double balance = 10000.00;
    static List<String> transactionHistory = new ArrayList<>();
    static String userId = "user";
    static String userPin = "1234";

    public static void main(String[] args) {
        System.out.println("------ Welcome to Spark ATM ------");
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (id.equals(userId) && pin.equals(userPin)) {
            System.out.println("Login Successful!\n");
            menu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void menu() {
        while (true) {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: showHistory(); break;
                case 2: withdraw(); break;
                case 3: deposit(); break;
                case 4: transfer(); break;
                case 5: System.out.println("Thank you for using Spark ATM!"); return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    static void showHistory() {
        System.out.println("----- Transaction History -----");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
            transactionHistory.add("Withdrew ₹" + amount);
        }
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Deposit Successful!");
        transactionHistory.add("Deposited ₹" + amount);
    }

    static void transfer() {
        sc.nextLine(); // Clear buffer
        System.out.print("Enter recipient name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance to transfer.");
        } else {
            balance -= amount;
            System.out.println("Transfer Successful to " + recipient);
            transactionHistory.add("Transferred ₹" + amount + " to " + recipient);
        }
    }
}

