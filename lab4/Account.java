package lab4;
import java.util.ArrayList;

public class Account {

	
	//class variables
	private static int accountNumber = 1;
	private String costumer;
	private int thisAccountNumber;
	private double balance;
	protected static Bank theBank;
	protected Account otherAccount;
	protected ArrayList<String> transactions = new ArrayList<String>();
	
	//class constructor, does not return anything
	public Account(String arg1, double arg2) { //Creates one account
		costumer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumber;
		accountNumber +=1;
	}
	
	public Account(String arg1, double arg2, double arg3) { //Creates an account with a savings account
		costumer = arg1;
		balance = arg2;
		SavingsAccount acc2 = new SavingsAccount(arg1, arg3);
		otherAccount = acc2;
		thisAccountNumber = accountNumber;
		accountNumber +=1;
	}
	//Yet another constructor 'Account' for lab4
	public Account(CurrentAccount arg){ 
		otherAccount = arg; 								//Creating an account for the loans
		balance = arg.getBalance();							//Balance becomes the loan, it is negative
		thisAccountNumber = arg.getAccountNumber(); 		//Getting the account nr 
		costumer = arg.getCostumer();						//Getting the customer
	}
	
	//class methods
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getCostumer() {
		return costumer;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double arg) {
		balance = arg;
	}
	
	public static void setBank(Bank arg) {
		theBank = arg;
	}
	
	public SavingsAccount getSavingAccount() { 				//Gets the savings account for a specific person
		if(otherAccount instanceof SavingsAccount) {
			return (SavingsAccount) otherAccount;
		}
		else {
			return null;
		}
		
	}
	//Added for lab4
	public void annualChange() {							//Changes the value of balance based on the account type
		if(this instanceof SavingsAccount) {				//Increase with 1% if it's a savings account
			balance *= 1.01;
		}
		else if(this instanceof Loan) {						//Increase with 5% if it's a loan account
			balance *= 1.05;
		}
		else{												//Reduce 10 if it's a current account
			balance -= 10;
			if(balance < 0) {								//If the balance would become negative, we set it to zero
				theBank.getLoan((CurrentAccount) this);
				balance = 0; //**pin**//
			}
		}
	}
	
	//Writes out balance in savings account and current account (and now loans! -lab4)
	public String toString() {
		String output ="";
		if(this instanceof CurrentAccount) {
			output = output + "Current account: ";
		}
		
		else if(this instanceof Loan) {						//New for lab 4, handling Loans in our output
			output = output + "Loan: ";
		}
		
		else {
			output = output + "Savings account: ";
		}
		
		output = output + " : " + balance + "\n";
		
		for(String e : transactions) {
			output = output + e + "\n";
		}
		
		return output;
	}
}
