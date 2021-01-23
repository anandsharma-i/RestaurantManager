package Restraunt_Manager;

import java.util.*;
//This class handles "all-tables" related functions.
public class Manager extends Table
{
	//Arraylist tb to store all the objects(tables) of Class Table as a member. 
	private List<Table> tb=new ArrayList<Table>(5);	
	void set_tb(List<Table> tb)
	{
		this.tb=tb;//All the objects(tables) of Class Table are copied.
	}
	//To count the current total no. of empty tables.
	void ctr_empty_tables()
	{
		int ctr=0,i=0;
		for(i=0;i<5;i++)
		{
			if((tb.get(i)).isempty()==1)//Counting only the tables which are empty.
			{
				ctr++;
			}
		}
		System.out.println(ctr+" tables are empty.");
	}
	//To return the first empty table found.
	void empty_table(int ch)
	{
			int i=0,flag=0;	
			for(i=0;i<5;i++)
			{
				if(tb.get(i).isempty()==1)
				{
					if(ch==1)//if choice-1(Book Table) is selected from Main-Menu.
						tb.get(i).book();
					else//if choice-4(Dine-Now) is selected from Main-Menu.
						tb.get(i).bill_update(1);//1 is sent as parameter(Dine-Now.)
					flag=1;
					break;
				}
			}
			if(flag==0)//false condition.
			{
				System.out.println("Table is not empty.Please wait for a while.");
			}
	}
	//To verify the booking/reservation.
	void chk_booking(int x)
	{
		int i=0,flag=0;	
		for(i=0;i<5;i++)
		{
			if(tb.get(i).booking_id==x)//If the booking id is verified.
			{				
				tb.get(i).bill_update(0);//Update the bill.
				flag=1;
				break;
			}
		}
		if(flag==0)//false condition.If the booking id is not verified.
			System.out.println("Incorrect booking id.");
	}	
	void takedel(int ch)
	{		
		System.out.println("1.Take-Away");
		System.out.println("2.Home-Delivery");
		System.out.println("\nEnter your choice(1,2) :");
		int ch1=sc.nextInt();
		if(ch1==2)
		{
			System.out.println("Enter address : ");
			@SuppressWarnings("unused")
			String add=sc.nextLine();			
			add=sc.nextLine();
		}
		bill_update(ch);
	}
}




