public class fd_account {
	private String name;
	private String account_no;
	private boolean senior_citizen;
	private double deposit_amt;
	private int tenure_of_deposit;
	private boolean isSI = true;
	private boolean interest_paid_at_intervals = false;
	private int no_of_days = -1;
	private double balance_amt = 0.0;
	void setName(String name)
	{
		this.name = name;
	}
	void setAccNo(String account_no)
	{
		this.account_no = account_no;
	}
	void setCitizen(String citizen)
	{
		this.senior_citizen = citizen.equals("yes");
	}
	void setDepositAmt(double deposit_amt)
	{
		this.deposit_amt = deposit_amt;
	}
	void decDepositAmt(double deposit_amt)
	{
		this.deposit_amt -= deposit_amt;
	}
	void setTenure(int tenure_of_deposit)
	{
		this.tenure_of_deposit = tenure_of_deposit;
	}
	void setInterestPay(String interest_paid_at_intervals)
	{
		this.interest_paid_at_intervals = interest_paid_at_intervals.equals("yes");
	}
	void setIsSI(int isSI)
	{
		this.isSI = isSI == 1 ? true:false;
	}
	void setNo_of_days(int no_of_days)
	{
		this.no_of_days = no_of_days;
	}
	int getNo_of_days()
	{
		return this.no_of_days;
	}
	boolean getisSI()
	{
		return this.isSI;
	}
	String getName()
	{
		return this.name;
	}
	String getAccNo()
	{
		return this.account_no;
	}
	String getCitizen()
	{
		if(this.senior_citizen)
		{
			return "Senior Citizen";
		}
		else
		{
			return "General Citizen";
		}
	}
	double getDepositAmt()
	{
		return this.deposit_amt;
	}
	int getTenure()
	{
		return this.tenure_of_deposit;
	}
	double getBalanceAmt()
	{
		return this.balance_amt;
	}
	void addBalanceAmt(double balance_amt)
	{
		this.balance_amt += balance_amt;
	}
	void reBalanceAmt(double balance_amt)
	{
		this.balance_amt -= balance_amt;
	}
	String getInterestPay()
	{
		if(this.interest_paid_at_intervals)
		{
			return "Interest Paid at Intervals";
		}
		else
		{
			return "Interest Paid at Maturity";
		}
	}
	
}
