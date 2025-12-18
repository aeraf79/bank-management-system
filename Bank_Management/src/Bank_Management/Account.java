package Bank_Management;

	public abstract class Account {
	    protected String accountHolder;
	    protected int accountNumber;
	    protected double balance;

	    public Account(String name, int accNo, double bal) {
	        this.accountHolder = name;
	        this.accountNumber = accNo;
	        this.balance = bal;
	    }

	    public abstract void displayDetails();
	}
