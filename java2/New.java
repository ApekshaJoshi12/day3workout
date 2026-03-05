class BankAccount {
    private String accountNumber;
    private double balance;

   
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

   
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    
    public double getBalance() {
        return balance;
    }
}


class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Savings Account: Cannot withdraw more than balance!");
        }
    }
}


class CurrentAccount extends BankAccount {

    private double overdraftLimit = 1000;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

   
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            System.out.println("Current Account: Withdrawal allowed (Overdraft facility used if needed)");
        } else {
            System.out.println("Current Account: Overdraft limit exceeded!");
        }
    }
}


public class New {
    public static void main(String[] args) {

        
        BankAccount savings = new SavingsAccount("SA123", 5000);
        BankAccount current = new CurrentAccount("CA456", 2000);

        savings.withdraw(6000);  
        savings.withdraw(3000);

        current.withdraw(2500);  
        current.withdraw(4000);

        System.out.println("Savings Balance: " + savings.getBalance());
        System.out.println("Current Balance: " + current.getBalance());
    }
}