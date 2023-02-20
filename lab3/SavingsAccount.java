package lab3;
//Savings account becomes its own class with its own constructor
//By doing this we can specify which accounts we want to transfer in between
public class SavingsAccount extends Account {
	public SavingsAccount(String arg1, double arg2) {
		super(arg1, arg2);
	}
}
