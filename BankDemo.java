import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        // Create a list of Account references
        List<Account> accounts = new ArrayList<>();

        // Add different types of accounts
        accounts.add(new SavingsAccount("S001", 1000.00, 500.00));
        accounts.add(new CurrentAccount("C001", 500.00, 300.00));

        System.out.println("===== BANK ACCOUNT DEMO =====");

        // Polymorphic loop
        for (Account account : accounts) {

            System.out.println("\nAccount: " + account.accountNumber);
            System.out.println("Initial balance: $"
                    + account.getBalance());

            // Withdraw through Account reference
            if (account.accountNumber.equals("S001")) {
                account.withdraw(600.00);
            } else {
                account.withdraw(700.00);
            }

            System.out.println("Balance after withdrawal: $"
                    + account.getBalance());

            // End-of-month processing
            account.endOfMonth();

            System.out.println("Balance after month-end: $"
                    + account.getBalance());
        }

        // Explicitly demonstrate SavingsAccount rejection
        System.out.println("\n===== SAVINGS EDGE CASE =====");

        Account savings = new SavingsAccount("S002", 1000.00, 500.00);

        System.out.println("Initial balance: $"
                + savings.getBalance());

        savings.withdraw(600.00);

        System.out.println("Balance: $"
                + savings.getBalance());

        // Explicitly demonstrate CurrentAccount overdraft
        System.out.println("\n===== CURRENT ACCOUNT OVERDRAFT =====");

        Account current = new CurrentAccount("C002", 500.00, 300.00);

        System.out.println("Initial balance: $"
                + current.getBalance());

        current.withdraw(700.00);

        System.out.println("Balance after overdraft: $"
                + current.getBalance());
    }
}
