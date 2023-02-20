package lab3;
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
	
	public SavingsAccount getSavingAccount() { //Gets the savings account for a specific person
		if(otherAccount instanceof SavingsAccount) {
			return (SavingsAccount) otherAccount;
		}
		else {
			return null;
		}
		
	}
	//Writes out balance in savings account and current account
	public String toString() {
		String output ="";
		if(this instanceof CurrentAccount) {
			output = output + "Current account: with account number ";
		}
		
		else {
			output = output + "Savings account: with account number ";
		}
		
		output = output + thisAccountNumber + " : " + balance + "\n";
		for(int i = 0; i < transactions.size(); ++i) {
			output = output + transactions.get(i) + "\n";
		}
		
		return output;
	}
}
