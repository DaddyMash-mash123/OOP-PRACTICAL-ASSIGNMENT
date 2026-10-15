public class CurrentAccount extends Account {

    private double overdraftLimit;
    private final double monthlyFee = 10.00;

    // Constructor
    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        } else if (balance - amount < -overdraftLimit) {
            System.out.println("Current account withdrawal rejected: overdraft limit exceeded.");
        } else {
            balance -= amount;
            System.out.println("Current withdrawal successful: $" + amount);
        }
    }

    // Override endOfMonth
    @Override
    public void endOfMonth() {
        balance -= monthlyFee;

        System.out.println("Current account maintenance fee deducted: $"
                + monthlyFee);
    }
}

