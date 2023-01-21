import java.util.Scanner;
public class mainmenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		while(true)
		{
			System.out.println("--------------------------------------");
			System.out.println("\n1. Create FD Account\n2. Break FD Account\n3. View FD Account Details\n4. Withdraw Amount from FD Account\n5. Renewal of FD Account\n6. Exit\n");
			System.out.print("Enter your option : ");
			int option = sc.nextInt();
			System.out.println();
			System.out.println("--------------------------------------");
			switch(option)
			{
			case 1:
			{
				create_FD create = new create_FD();
				create.create_new_fd();
				break;
			}
			case 2:
			{
				break_FD breakfd = new break_FD();
				breakfd.break_fd_account();
				break;
			}
			case 3:
			{
				view_FD view = new view_FD();
				view.view_fd_details();
				break;
			}
			case 4:
			{
				withdraw_FD withdraw = new withdraw_FD();
				withdraw.withdraw_fd_amount();
				break;
			}
			case 5:
			{
				renewal_FD renew = new renewal_FD();
				renew.renew_fd_account();
				break;
			}
			case 6:
			{
				sc.close();
				System.out.println("Thank you!!!");
				System.out.println("--------------------------------------");
				return ;
			}
			default:
				System.out.println("\nEnter a valid choice\n");
			}
		}
		
	}
}
