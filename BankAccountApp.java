import java.util.Scanner;

// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// 1. Bank Account Class
class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount! Amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient Funds! Your balance is $" + String.format("%.2f", balance));
        }
        balance -= amount;
    }
}

// 2. Main Class
public class BankAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Account na gaya sa Expected Output
        BankAccount account = new BankAccount("ACC-1001", "Alex Cruz", 500.00);

        System.out.println("--- BANK ACCOUNT EXCEPTION GATEKEEPER ---");
        System.out.println("Account: " + account.getAccountNumber() +
                " (Holder: " + account.getAccountHolder() +
                ", Balance: $" + String.format("%.2f", account.getBalance()) + ")");

        // 4. Interactive Main + Exception Handling
        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
            System.out.println("[TRANSACTION COMPLETE] Transaction log updated.");
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            // Pag kulang pera o mali yung amount
            System.out.println("[EXCEPTION CAUGHT]: " + e.getMessage());
        } catch (Exception e) {
            // Pang-huli, pag ibang error like nag-type ng letter
            System.out.println("[EXCEPTION CAUGHT]: Invalid input! Please enter a number.");
        } finally {
            // Laging tatakbo kahit may error o wala
            System.out.println("[FINALLY] Session Complete. Current Balance: $" + String.format("%.2f", account.getBalance()));
            scanner.close();
        }
    }
}
