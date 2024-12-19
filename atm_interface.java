import java.util.Scanner;

class BankAccount {
    private double accountBalance;

    public BankAccount() {
        this.accountBalance = 0.0;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void depositFunds(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdrawFunds(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class ATM {
    private BankAccount userBankAccount;
    private Scanner inputScanner;

    public ATM(BankAccount account) {
        userBankAccount = account;
        inputScanner = new Scanner(System.in);
    }

    public void startTransaction() {
        boolean continueTransaction = true;

        while (continueTransaction) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit Funds");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int userChoice = inputScanner.nextInt();

            switch (userChoice) {
                case 1:
                    depositAmount();
                    break;
                case 2:
                    withdrawAmount();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    continueTransaction = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void depositAmount() {
        System.out.print("Enter amount to deposit: ");
        double amount = inputScanner.nextDouble();
        userBankAccount.depositFunds(amount);
    }

    private void withdrawAmount() {
        System.out.print("Enter amount to withdraw: ");
        double amount = inputScanner.nextDouble();
        userBankAccount.withdrawFunds(amount);
    }

    private void checkBalance() {
        System.out.println("Current balance: " + userBankAccount.getBalance());
    }
}

public class atm_interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount();
        ATM atmMachine = new ATM(userAccount);
        atmMachine.startTransaction();
    }
}