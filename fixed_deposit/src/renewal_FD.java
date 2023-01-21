import java.util.Scanner;
public class renewal_FD extends fixed_deposit_santhosh{
	Scanner sc = new Scanner(System.in);
	void renew_fd_account()
	{
		if(getFDlength() == 0)
		{
			System.out.println("You don't have a FD account!!!");
			return ;
		}
		System.out.println("Enter the Account Number : ");
		int index = findFD(sc.nextLine());
		if(index == -1)
			return ;
		
		if(getFDtenure(index) == 0 && getFDdepositAmt(index) != 0)
		{
			System.out.print("Enter new Tenure of Deposit : ");
			int days = sc.nextInt();
			setFDtenure(index,days);
			System.out.println("\n\nYour Deposit Amount has been renewed\n");
		}
		else if(getFDdepositAmt(index) == 0)
		{
			System.out.println("\nYou haven't deposited any Amount");
		}
		else
		{
			System.out.println("\nYou have still "+getFDtenure(index)+ " days left");
		}
	}
}
