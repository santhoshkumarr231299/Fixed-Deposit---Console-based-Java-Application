import java.util.Scanner;
public class view_FD extends fixed_deposit_santhosh{
	Scanner sc = new Scanner(System.in);
	void view_fd_details()
	{
		if(getFDlength() == 0)
		{
			System.out.println("You don't have a FD account!!!");
			return ;
		}
		
		System.out.print("Enter account number : ");
		int index = findFD(sc.nextLine());
		if(index == -1)
			return ;
		System.out.println("\nName : "+getFDname(index));
		System.out.println("Account Number : "+getFDaccNo(index));
		System.out.println("Citizen Type : "+getFDcitizen(index));
		System.out.println("Tenure of Deposit : "+getFDtenure(index));
		System.out.println("Interest Type : "+(getFDisSI(index)?"Simple Interest":"Compound Interest"));
		System.out.println("Deposit Amount : "+getFDdepositAmt(index));
		System.out.println("Withdraw of Interest at : "+getFDinterestPay(index));
		
		if(getFDinterestPay(getFDlength()-1).equals("Interest Paid at Intervals"))
		{
			System.out.println("Interval no of days to withdraw : "+getFDno_of_days(index));
		}
		System.out.println("Balance Amount : "+getBalance(index));
		System.out.println();
	}
}
