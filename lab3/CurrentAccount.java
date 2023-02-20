package lab3;

public class CurrentAccount extends Account {
	
	//Current account gets a constructor to be its own subclass
	public CurrentAccount(String arg1, double arg2){
		super(arg1, arg2);
		otherAccount = null;
	}
	//a constructor with current account and savings account
	public CurrentAccount(String arg1, double arg2, double arg3) {
		super(arg1, arg2, arg3);
	}
	
	//we transfer money between savings and current account
	public void savings(double arg) {
		
		if((otherAccount != null) && (otherAccount instanceof SavingsAccount)) {
			double transfred = 0;
			double cB = this.getBalance(); //currentBalance
			double sB = this.otherAccount.getBalance(); //savningsBalance
			
			if(arg > 0) {
				if((cB - arg) >= 0) {
					this.otherAccount.setBalance(sB + arg);//We set the balance of savings 
					this.setBalance(cB - arg);//we remove the transfered money from current account
					transfred = arg;//arg is the money transfered
				}
				else {
					this.otherAccount.setBalance(sB + cB);//We set the balance of savings 
					this.setBalance(0); //we empty savings
					transfred = cB;//we have transfered all money from current account
				}
				// writes out the transaction
				String transaction = "To savings account : " + transfred;
				transactions.add(transaction);
			
				String transaction2 = "From current account : " + transfred;
				otherAccount.transactions.add(transaction2);
			}
			
			else if(arg <= 0) {
				if((sB + arg) >= 0) {
					this.setBalance(cB-arg); // adds arg to the current accounts balance
					this.otherAccount.setBalance(sB + arg); //removes arg from the savings accounts balance
					transfred = arg*(-1); //shows the transfered money
				}
				else {
					this.setBalance(cB + sB);//we add all money from savings to current account
					this.otherAccount.setBalance(0);//sets savings to zero, it is emptied
					transfred = sB; //we have transfered all savings money
				}
				//writes out the transaction
				String transaction = "To current account : " + transfred;
				otherAccount.transactions.add(transaction);
		
				String transaction2 = "From savings account : " + transfred;
				transactions.add(transaction2);
			}
		}
	}
}
