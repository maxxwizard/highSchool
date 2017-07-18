public class SavingsAccount {

	private double balance;
	private double rate;
	private double a;
	private double total;

	public SavingsAccount() {
		balance = 0.0;
	}

	public SavingsAccount(double a) {
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
	
	public void computeInterest(int m) {
	
		if (m > 0) {
			a = balance * Math.pow(1.01,m);
			total = balance + a;
			System.out.println("The interest on your current balance of $" + balance + " is $" + a + ". Your balance with the interest added is $" + total + ".");
		}
		else
			System.out.println("Number of months must be greater than 0.");
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Your account balance is $" + balance + ".";
	}
		
 }