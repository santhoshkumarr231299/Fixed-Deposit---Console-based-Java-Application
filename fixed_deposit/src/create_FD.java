import java.util.Scanner;
public class create_FD extends fixed_deposit_santhosh {
	Scanner sc = new Scanner(System.in);
	void create_new_fd()
	{
		createFD();
		System.out.print("Enter Name : ");
		setFDname(getFDlength()-1);
		System.out.println();
		
		System.out.print("Enter Account Number : ");
		setFDaccNo(getFDlength()-1);
		
		if(isDuplicate(getFDaccNo(getFDlength()-1)))
		{
			deleteFD(getFDlength()-1);
			return ;
		}
		
		System.out.println();
		
		int amt = 0;
		boolean isValid = true;
		while(isValid)
		{
			System.out.print("Enter the Amount you want to deposit -> min = 1000 Rupees and max = 200000 Rupees : ");
			amt = sc.nextInt();
			if(amt >= 1000 && 200000 >= amt)
			{
				isValid = false;
			}
			else
				System.out.println("\nEnter valid no of Rupees\n");
		}
		
		setFDdepositAmt(getFDlength()-1,amt);
		System.out.println();
		
		
		
		int days = 0;
		isValid = true;
		while(isValid)
		{
			System.out.print("Enter Tenure of Deposit -> min = 7 days and max = 3650 days : ");
			days = sc.nextInt();
			if(days >= 7 && 3650 >= days)
			{
				isValid = false;
			}
			else
			{
				System.out.println("\nEnter valid no of days\n");
			}
		}

		setFDtenure(getFDlength()-1,days);
		System.out.println();
		
		System.out.print("Enter 'yes' if you're a Senior Citizen, else 'no' : ");
		setFDcitizen(getFDlength()-1);
		System.out.println();
		
		System.out.print("Enter '1' if you want SI, else '0' if CI : ");
		setFDisSI(getFDlength()-1);
		
		System.out.println("\nInterest for "+getFDtenure(getFDlength()-1) + " Days is " +Math.round(getFDInterestAmt(getFDlength()-1)*100) / 100.0+"\n");
		
		if(Math.round(getFDInterestAmt(getFDlength()-1)*100) / 100.0 > (getFDcitizen(getFDlength()-1).equals("Senior Citizen")? 50000 : 40000))
		{
			System.out.println("You may be subjected to penalty because your anual income exceeds "+(getFDcitizen(getFDlength()-1).equals("Senior Citizen")? 50000 : 40000)+"\n");
		}
		isValid = true;
		while(isValid)
		{
			System.out.print("Enter '1' to proceed or '0' to discard : ");
			int option = sc.nextInt();
			switch(option)
			{
			case 0:
				System.out.println();
				deleteFD(getFDlength()-1);
				System.out.println("Your Account Creation has been successfully discarded...");
				return ;
			case 1:
				isValid = false;
				sc.nextLine();
				break;
			default:
				System.out.println("\nEnter valid Choice\n");
			}
		}
		
		System.out.println();
		System.out.print("Enter 'yes' if Interest paid at Intervals, else 'no' if Interest paid at maturity : ");
		setFDinterestPay(getFDlength()-1);
		System.out.println();
		
		if(getFDinterestPay(getFDlength()-1).equals("Interest Paid at Intervals"))
		{
			isValid = true;
			while(isValid)
			{
				System.out.print("Enter the no of days for the withdrawal (min 7 days) : ");
				days = sc.nextInt();
				if(days >= 7 && getFDtenure(getFDlength()-1) >= days)
				{
					if(days == getFDtenure(getFDlength()-1))
					{
						setFDno_of_days(getFDlength()-1,-1);
						setFDinterestPay(getFDlength()-1,"no");
					}
					isValid = false;
				}
				else
					System.out.println("\nEnter valid no of days\n");
			}
			setFDno_of_days(getFDlength()-1,days);
			System.out.println();
		}
		System.out.println("\nFD Account created successfully\n");
	}
}
