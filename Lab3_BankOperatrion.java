package fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private static int accountNumberCounter = 1000;
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolderName) {
        this.accountNumber = ++accountNumberCounter;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial balance: $0.0");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit: +$" + amount + ". New balance: $" + balance);
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal: -$" + amount + ". New balance: $" + balance);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void transfer(BankAccount recipientAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipientAccount.deposit(amount);
            addTransaction("Transfer to Account " + recipientAccount.getAccountNumber() +
                    ": -$" + amount + ". New balance: $" + balance);
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

public class Lab3_BankOperatrion{
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        List<BankAccount> accounts = new ArrayList<>();

	        int choice;
                    createAccount(accounts);
                    do {
                        printMenu();
                        choice = sc.nextInt();

             switch (choice) {
                 case 1:
                   createAccount(accounts);
                    break;
                case 2:
                    performTransaction(accounts, "Deposit");
                    break;
                case 3:
                    performTransaction(accounts, "Withdraw");
                    break;
                case 4:
                    performTransfer(accounts);
                    break;
                case 5:
                    checkBalance(accounts);
                    break;
                case 6:
                    displayTransactionHistory(accounts);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. Transaction History");
        System.out.println("7. Exit");
    }

    private static void createAccount(List<BankAccount> accounts) {
        System.out.print("Enter your name: ");
        sc.nextLine();  // Consume the newline character
        String accountHolderName = sc.nextLine();
        BankAccount newAccount = new BankAccount(accountHolderName);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Account Number: " + newAccount.getAccountNumber());
    }

    private static void performTransaction(List<BankAccount> accounts, String transactionType) {
        System.out.print("Enter your account number: ");
        int accountNumber = sc.nextInt();

        BankAccount account = findAccount(accounts, accountNumber);

        if (account != null) {
            System.out.print("Enter the " + transactionType.toLowerCase() + " amount: $");
            double amount = sc.nextDouble();

            if ("Deposit".equals(transactionType)) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performTransfer(List<BankAccount> accounts) {
        System.out.print("Enter your account number: ");
        int senderAccountNumber = sc.nextInt();
        BankAccount senderAccount = findAccount(accounts, senderAccountNumber);

        System.out.print("Enter recipient's account number: ");
        int recipientAccountNumber = sc.nextInt();
        BankAccount recipientAccount = findAccount(accounts, recipientAccountNumber);

        if (senderAccount != null && recipientAccount != null) {
            System.out.print("Enter the transfer amount: $");
            double amount = sc.nextDouble();
            senderAccount.transfer(recipientAccount, amount);
        } else {
            System.out.println("Invalid account numbers.");
        }
    }

    private static void checkBalance(List<BankAccount> accounts) {
        System.out.print("Enter your account number: ");
        int accountNumber = sc.nextInt();

        BankAccount account = findAccount(accounts, accountNumber);

        if (account != null) {
            System.out.println("Your account balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayTransactionHistory(List<BankAccount> accounts) {
        System.out.print("Enter your account number: ");
        int accountNumber = sc.nextInt();

        BankAccount account = findAccount(accounts, accountNumber);

        if (account != null) {
            List<String> transactions = account.getTransactionHistory();
            System.out.println("Transaction History for Account " + accountNumber + ":");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static BankAccount findAccount(List<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static Scanner sc = new Scanner(System.in);
}
