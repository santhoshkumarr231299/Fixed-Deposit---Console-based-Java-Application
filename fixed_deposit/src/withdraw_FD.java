import java.util.Scanner;
public class withdraw_FD extends fixed_deposit_santhosh{
	Scanner sc = new Scanner(System.in);
	void withdraw_fd_amount()
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
		 
		if(getFDdepositAmt(index) == 0)
		{
			System.out.println("\nYou haven't deposited any Amount");
			return ;
		}
		
		if(getFDtenure(index) != 0)
		{
			System.out.println("\nPenalty = "+ getPenalty(index) + " because of premature withdrawal");
			
			
			boolean isValid = true;
			while(isValid)
			{
				System.out.println("\nEnter '1' to proceed or '0' to discard : ");
				int option = sc.nextInt();
				switch(option)
				{
				case 0:
					System.out.println("\nAccount deletion has been discarded...\n");
					return ;
				case 1:
					reBalance(index , getPenalty(index));
					deleteFD(index);
					System.out.println();
					System.out.println("Your account has been successfully closed\n");
					isValid = false;
					break;
				default:
					System.out.println("\nEnter valid Choice\n");
				}
				
			}
			
		}
		else
		{
			boolean isValid = true;
			while(isValid)
			{
				System.out.println("\nEnter '1' to proceed or '0' to discard : ");
				int option = sc.nextInt();
				switch(option)
				{
				case 0:
					System.out.println("\nAccount deletion has been discarded...\n");
					return ;
				case 1:
					deleteFD(index);
					System.out.println();
					System.out.println("Your account account has been successfully closed\n");
					isValid = false;
					break;
				default:
					System.out.println("\nEnter valid Choice\n");
				}
				
			}
			System.out.println("\nYou haven't deposited any Amount");
		}
		
	}
}
