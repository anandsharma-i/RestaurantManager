package Restraunt_Manager;

import java.util.*;
//This class handles "single-table" related operations.
public class Table 
{
	//Map for menu item & price.
	static HashMap<String,Float> mpp= new HashMap<String,Float>(10);
	
	//Map for menu item & item serial no. 
	static HashMap<Integer,String> mpp1= new HashMap<Integer,String>(10);
	
	Scanner sc=new Scanner(System.in);
	static int ctr=0;//counter variable.
	
	/*empty :stores 1/0 to represent if the table is empty or not.
	 *seat : To store the total no. of people to be seated in a table.
	 *booking_id : To store the booking id of table that will be booked.
	 *tableno :  To store the table no.
	 *bill : To store the total bill generated of a table.
	 * */
	protected int empty=0,seat=0,booking_id=0,tableno=0;
	protected float bill=0;
	
	//constructor for counting the objects and hence storing the table no.
	Table()
	{
		tableno=++ctr;//table no. is stored.		
	}
	//For setting the Menu-Card.
	static void set_map(HashMap<String,Float> mp,HashMap<Integer,String> mp1)
	{
		mpp=mp;
		mpp1=mp1;
	}
	int isempty()//To represent if the table is empty or not. 
	{
		if(empty==0)//if the table is empty 1 is returned.
			return 1;
			//System.out.println("Table is empty!Take a seat.");
		else
			return 0;
			//System.out.println("Table is not empty.Please wait for a while.");
	}
	void book()//To handle the booking/reservation process of a table.
	{
		/*object of Class Random 
		to generate random no.s for booking id purpose.*/
		Random rand = new Random();
		 		  	
		System.out.println("Table for?(1/2/3/4....)");
		seat=sc.nextInt();//To store the total no. of people to be seated in a table.
		empty=1;//Table is occupied.		
		 
		//Generate random integers in range 0 to 999 
        booking_id = rand.nextInt(1000);//booking id is generated.
        System.out.println("Your booking id is :"+booking_id);
        System.out.println("Your table no. is : "+tableno);
        System.out.println("!!!WARNING!!!");
        System.out.println("We will never call you for your booking id."+"Please don't share your booking id with anyone.");
	}
	float bill()//Returns the total bill generated.
	{
		return bill;
	}
	//To handle the addition of the bill.
	void bill_update(int ch)
	{
			if(ch==1)//For Dine-now option only.
			{							
					System.out.println("Table for?(1/2/3/4....)");
					seat=sc.nextInt();//To store the total no. of people to be seated in a table.
					empty=1;//Table is occupied.
														
			}
			int i=1;//Counter variable.
			String choice=null;//choice variable.
			
			System.out.println("			   ::MENU-CARD::");
			System.out.println("   ITEM           		 -             Price");
		 	Iterator<Map.Entry<String, Float>> itr = mpp.entrySet().iterator();    
	        while(itr.hasNext()) 
	        { 
	             Map.Entry<String, Float> entry = itr.next(); 
	             System.out.println((i++)+". " +entry.getKey() +  
	                                 "           -             " + entry.getValue()); 
	        } 
	        do
	        {
	        	System.out.println("Add item to your platter.(Enter the item sl no.) : ");
	        	int ch1=sc.nextInt();
	        	bill+=mpp.get(mpp1.get(ch1));
	        	System.out.println("Do you want to add more items?(Y/N) : ");
	        	choice=sc.next();
	        }while(choice.equals("Y")||choice.equals("y"));
	        
	        i=1;//Resetting counter variable.
		this.check_out();
	}	
	void check_out()//To handle the checkout process(Resetting all data for new diners).
	{
		String choice=null;
		System.out.println("Your check amount is : Rs."+bill+"/-");

		//Tip purpose.
		System.out.println("Do you want to add tip ?(Y/N) ");
		choice=sc.next();
		if(choice.equals("Y")||choice.equals("y"))
		{
			System.out.println("Enter the tip amount : ");
			float tip=sc.nextInt();
			System.out.println("Your check amount is : Rs."+(bill+tip)+"/-");
		}
		empty=0;//Table is now empty again.
		seat=0;
		bill=0;
		
		//Feedback purpose.
		System.out.println("Do you want to give feedback?(Y/N)");
		choice=sc.next();
		if(choice.equals("Y")||choice.equals("y"))
		{
			@SuppressWarnings("unused")
			String feedback=null;
			System.out.println("Enter the feedback now(Please keep it brief and specific) : ");
			feedback=sc.nextLine();
			feedback=sc.nextLine();
			System.out.println("Feedback registered succesfully.");	
		}
					
		System.out.println("Check-Out Successful.");		
	}
	
}
