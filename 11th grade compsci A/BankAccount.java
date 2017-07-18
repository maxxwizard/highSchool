public class BankAccount {

	private double balance;

	public BankAccount() {
		balance = 0.0;
	}

	public BankAccount(double a) {
		balance = a;
	}

	public void deposit(double a) {
		balance += a;
	}
	
	public void withdraw(double a) {
		if (a < balance)
			balance -= a;
		else
			System.out.println("Insufficient funds.");
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Your account balance is $" + balance + ".";
	}
		
 }