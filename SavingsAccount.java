public class SavingsAccount extends Account {

    private double minimumBalance;
    private final double interestRate = 0.02; // 2% interest

    // Constructor
    public SavingsAccount(String accountNumber, double balance,
                           double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        } else if (balance - amount < minimumBalance) {
            System.out.println("Savings withdrawal rejected: minimum balance of $"
                    + minimumBalance + " must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Savings withdrawal successful: $" + amount);
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;

        System.out.println("Savings account interest added: $" + interest);
    }
}