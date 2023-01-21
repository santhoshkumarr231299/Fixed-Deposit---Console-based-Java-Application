import java.util.Scanner;
public class break_FD extends fixed_deposit_santhosh{
	Scanner sc = new Scanner(System.in);
	void break_fd_account()
	{
		if(getFDlength() == 0)
		{
			System.out.println("You don't have a FD account!!!");
			return ;
		}
		System.out.print("Enter the Account Number (Minimum Withdrawable Amount is 100) : ");
		
		String acc_no = sc.nextLine();
		int index = findFD(acc_no);
		if(index == -1)
			return ;
		
		double ViableWithdrawAmt = getFDdepositAmt(index) - 1000;
		
		if(ViableWithdrawAmt < 100)
		{
			System.out.println("\nYou can't Withdraw Amount, because your Withdrawable Amount is below 100\n");
			return ;
		}
		
		System.out.println("\nYour Withdrawable Amount is " + ViableWithdrawAmt);
		
		double amt = 0;
		
		boolean isValid = true;
		while(isValid)
		{
			System.out.print("\nEnter the Amount, you want to Withdraw : ");
			amt = sc.nextDouble();
			if(getFDdepositAmt(index) > amt && amt > 0 && amt <= ViableWithdrawAmt)
			{
				boolean isValid2 = true;
				while(isValid2)
				{
					System.out.print("\nEnter '1' to proceed or '0' to discard : ");
					int option = sc.nextInt();
					switch(option)
					{
					case 0:
						System.out.println("\nWithdraw Failed\n");
						return ;
					case 1:
						isValid2 = false;
						break;
					default:
						System.out.println("\nEnter valid Choice\n");
					}
				}
				isValid = false;
			}
			else
			{
				System.out.println("\nEnter a Valid Amount...");
			}
		}
		
		addBalance(index,amt);
		withdrawFDdepositAmt(index,amt);
		
		System.out.println("\nYour current Balance is "+getBalance(index)+" Rupees and Remaining Deposit Amount is "+getFDdepositAmt(index)+" Rupees");
		System.out.println("\nYour have successfully withdraw "+amt+" Rupees\n");
		
	}
}
