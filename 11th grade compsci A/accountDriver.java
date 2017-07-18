public class AccountDemo 
{
        public static void main(String args[])
	{
        // Create an empty account
        SavingsAccount my_account = new SavingsAccount();

                // Deposit money
		my_account.deposit(250.00);

                // Print current balance
		System.out.println (my_account);

                // Withdraw money
		//my_account.withdraw(80.00);

                // Print remaining balance
		System.out.println (my_account);
		
				// Computes the compound interest
		my_account.computeInterest(6);
	}
}