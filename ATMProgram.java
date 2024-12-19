import java.util.Scanner;

class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class ATMInterface {
    private Account userAccount;
    private Scanner scanner;

    public ATMInterface(Account account) {
        userAccount = account;
        scanner = new Scanner(System.in);
    }

    public void startATM() {
        boolean running = true;

        while (running) {
            System.out.println("\nATM Options:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    performDeposit();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void performDeposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void performWithdrawal() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    private void showBalance() {
        System.out.println("Your current balance is: " + userAccount.getBalance());
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        Account myAccount = new Account();
        ATMInterface atm = new ATMInterface(myAccount);
        atm.startATM();
    }
}