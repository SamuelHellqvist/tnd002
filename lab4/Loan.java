package lab4;

public class Loan extends Account {							//Subclass of account
	public Loan(CurrentAccount arg) {
		super(arg);
	}
	
	public double payOff(double arg) {
		Loan.super.setBalance(getBalance()+arg);   			//We reduce the loan by arg,balance is negative
		String s = "paid off: " + arg;
		Loan.super.transactions.add(s);						//Adding our string to transactions
		return Loan.super.getBalance();						//Returning updated balance
	}
}
