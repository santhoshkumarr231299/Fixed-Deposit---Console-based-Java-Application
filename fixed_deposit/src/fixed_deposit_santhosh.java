import java.util.Scanner;
import java.lang.Math;
import java.util.LinkedList;
class fixed_deposit_santhosh
{
	final double rate_of_interestGENERAL = 2.5;
	final double rate_of_interestSENIOR = 3.0;
	final double penalty = 0.5;
	private static LinkedList<fd_account> fd = new LinkedList<>();
	Scanner sc = new Scanner(System.in);
	void createFD()
	{
		fd.add(new fd_account());
	}
	void setFDname(int index)
	{
		fd.get(index).setName(sc.nextLine());
	}
	void setFDaccNo(int index)
	{
		fd.get(index).setAccNo(sc.nextLine());
	}
	void setFDcitizen(int index)
	{
		fd.get(index).setCitizen(sc.next());
	}
	void setFDdepositAmt(int index,int amt)
	{
		fd.get(index).setDepositAmt(amt);
	}
	void setFDtenure(int index, int days)
	{
		fd.get(index).setTenure(days);
	}
	void setFDinterestPay(int index)
	{
		fd.get(index).setInterestPay(sc.next());
	}
	void setFDinterestPay(int index,String b)
	{
		fd.get(index).setInterestPay(b);
	}
	void setFDisSI(int index)
	{
		fd.get(index).setIsSI(sc.nextInt());
	}
	void withdrawFDdepositAmt(int index,double amt)
	{
		fd.get(index).decDepositAmt(amt);
	}
	void MakeTenureZero(int index)
	{
		fd.get(index).setTenure(0);
	}
	boolean getFDisSI(int index)
	{
		return fd.get(index).getisSI();
	}
	String getFDname(int index)
	{
		return fd.get(index).getName();
	}
	String getFDaccNo(int index)
	{
		return fd.get(index).getAccNo();
	}
	String getFDcitizen(int index)
	{
		return fd.get(index).getCitizen();
	}
	double getFDdepositAmt(int index)
	{
		return fd.get(index).getDepositAmt();
	}
	int getFDtenure(int index)
	{
		return fd.get(index).getTenure();
	}
	String getFDinterestPay(int index)
	{
		return fd.get(index).getInterestPay();
	}
	double getBalance(int index)
	{
		return (fd.get(index)).getBalanceAmt();
	}
	void addBalance(int index, double bal)
	{
		fd.get(index).addBalanceAmt(bal);
	}
	void reBalance(int index,double bal)
	{
		fd.get(index).reBalanceAmt(bal);
	}
	void deleteFD(int index)
	{
		fd.remove(index);
	}
	void setFDno_of_days(int index,int no_of_days)
	{
		fd.get(index).setNo_of_days(no_of_days);
	}
	int getFDno_of_days(int index)
	{
		return fd.get(index).getNo_of_days();
	}
	int getFDlength()
	{
		return fd.size();
	}
	double getFDInterestAmt(int index)
	{
		if(getFDisSI(index))
		{
			return getFDdepositAmt(index)*(getFDtenure(index)/365.0)*( getFDcitizen(index).equals("Senior Citizen") ? rate_of_interestSENIOR : rate_of_interestGENERAL)/100.0;
		}
		else
		{
			return (getFDdepositAmt(index)*Math.pow(1.0 + (getFDcitizen(index).equals("Senior Citizen") ? rate_of_interestSENIOR : rate_of_interestGENERAL)/100, getFDtenure(index)/365.0) - getFDdepositAmt(index));
		}
	}
	double getPenalty(int index)
	{
		if(getFDcitizen(index).equals("General Citizen"))
		{
			return getFDdepositAmt(index)*(getFDtenure(index)/365.0)*(rate_of_interestGENERAL/100)*penalty;
		}
		else
		{
			return getFDdepositAmt(index)*(getFDtenure(index)/365.0)*(rate_of_interestSENIOR/100)*penalty;
		}
	}
	int findFD(String accNo)
	{
		for(int index = 0;index<getFDlength();index++)
		{
			if(fd.get(index).getAccNo().equals(accNo))
			{
				return index;
			}
		}
		System.out.print("\nInvalid Account Number\n");
		return -1;
	}
	boolean isDuplicate(String accNo)
	{
		for(int index = 0;index<getFDlength()-1;index++)
		{
			if(fd.get(index).getAccNo().equals(accNo))
			{
				System.out.println("\n\nThis Account Number already exists...\n");
				return true;
			}
		}
		return false;
	}
}