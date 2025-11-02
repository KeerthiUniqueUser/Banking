package main;

import model.Account;
import service.BankService;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();

        System.out.println("=== Welcome to Simple Bank ===");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    sc.nextLine(); // consume newline
                    String name = sc.nextLine();
                    System.out.print("Set 4-digit PIN: ");
                    String pin = sc.next();
                    Account acc = bankService.createAccount(name, pin);
                    System.out.println("Account created successfully! Your Account No: " + acc.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter PIN: ");
                    String loginPin = sc.next();

                    Account account = bankService.login(accNo, loginPin);
                    if (account == null) {
                        System.out.println("Invalid credentials!");
                    } else {
                        System.out.println("Welcome, " + account.getName() + "!");
                        boolean loggedIn = true;

                        while (loggedIn) {
                            System.out.println("\n1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Logout");
                            System.out.print("Choose option: ");
                            int opt = sc.nextInt();

                            switch (opt) {
                                case 1:
                                    System.out.print("Enter amount: ");
                                    double depositAmt = sc.nextDouble();
                                    bankService.deposit(account, depositAmt);
                                    System.out.println("Deposited ₹" + depositAmt);
                                    break;

                                case 2:
                                    System.out.print("Enter amount: ");
                                    double withdrawAmt = sc.nextDouble();
                                    if (bankService.withdraw(account, withdrawAmt))
                                        System.out.println("Withdrawn ₹" + withdrawAmt);
                                    else
                                        System.out.println("Insufficient balance!");
                                    break;

                                case 3:
                                    System.out.println("Balance: ₹" + account.getBalance());
                                    break;

                                case 4:
                                    loggedIn = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Simple Bank!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
