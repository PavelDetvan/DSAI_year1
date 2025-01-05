public class BankAccount {
   public BankAccount(double initialBalance) {
      if (initialBalance < 0) {
         throw new IllegalArgumentException("Initial balance cannot be negative.");
      }
      balance = initialBalance;
   }

   public void deposit(double amount) {
      if (amount < 0) {
         throw new IllegalArgumentException("Deposit amount cannot be negative.");
      }
      double newBalance = balance + amount;
      balance = newBalance;
   }

   public void withdraw(double amount) {
      if (amount < 0 || amount > balance) {
         throw new IllegalArgumentException("Withdrawal amount must be between 0 and the current balance.");
      }
      double newBalance = balance - amount;
      balance = newBalance;
   }

   public double getBalance() {
      return balance;
   }

   private double balance;

   public void catchEmAll() {
      // Implement this method to catch the IllegalArgumentExceptions and handle them.
      try {
      } catch (IllegalArgumentException e) {
         System.err.println("Caught IllegalArgumentException: " + e.getMessage());
      }
   }

   public static void main(String[] args) {
      BankAccount account1 = new BankAccount(100);
      account1.deposit(-100);
   }
}
