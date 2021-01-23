package Restraunt_Manager;

import java.util.*;

public class RestrauntManager 
{

	
	public static void main(String[] args) 
	{	
		//Menu-Card
		
		//Map for menu item & price.
		HashMap<String,Float> mp= new HashMap<String,Float>(10);
		mp.put("Chk Btr Ms",(float) 750.99);
		mp.put("Paneer B Ms",(float) 450.99);
		mp.put("Chk 69",(float) 650.99);
		mp.put("Palak Paneer",(float) 450.99);
		mp.put("Egg Tadka",(float) 250.99);
		mp.put("Malai Kofta",(float) 900.99);
		mp.put("Chk Biryani",(float) 800.99);
		mp.put("Btr Naan",(float) 110.99);
		mp.put("Honey Chilly Potato",(float) 750.99);
		mp.put("Gajar Halwa",(float) 750.99);
		
		//Map for menu item & item serial no.
		HashMap<Integer,String> mp1= new HashMap<Integer,String>(10);
		mp1.put(1,"Btr Naan");
		mp1.put(2,"Chk Btr Ms");
		mp1.put(3,"Gajar Halwa");
		mp1.put(4,"Chk 69");
		mp1.put(5,"Malai Kofta");
		mp1.put(6,"Chk Biryani");
		mp1.put(7,"Honey Chilly Potato");
		mp1.put(8,"Paneer B Ms");
		mp1.put(9,"Egg Tadka");
		mp1.put(10,"Palak Paneer");
		
		//Sending the Menu-Card(map) to table class.
		Table.set_map(mp,mp1);//static method.
		
		Scanner sc=new Scanner(System.in);	
		
		//Array-list to store objects of Class Table.
		List<Table> tables=new ArrayList<Table>(5);
		
		int i=0;
		for(i=0;i<5;i++)
		{
			//Creating objects of Class Table.
			Table t=new Table();
			//Adding Table objects in Array-list tables.
			tables.add(t);
		}
		
		//Creating object of Class Manager.
		Manager m=new Manager();	
		//Sending the Array-list tables as a parameter for member "tb" of Class Manager.
		m.set_tb(tables);
		
		String choice=null;			
		do
		{	//Main-Menu
			System.out.println("\n::WELCOME TO Eat@Home::");
			System.out.println("1.Book Table.");			
			System.out.println("2.Check for empty table."); //class manager			
			System.out.println("3.Dine Now.");			
			System.out.println("4.Check for Reservation."); //class manager
			System.out.println("5.TakeAway/Home Delivery");
			System.out.println("\nEnter your choice(1,2,3,4,5) :");
			int ch=sc.nextInt();
		
				switch(ch)
				{			
				case 1:	m.empty_table(ch); //searches 1st empty table and assigns.
					break;
				case 2: m.ctr_empty_tables(); //Counts total empty tables.					
					break;				
				case 3: m.empty_table(ch); //searches 1st empty table and assigns.
					break;				
				case 4:	System.out.println("Enter the booking id : ");
							m.chk_booking(sc.nextInt());													
					break;	
				case 5: m.takedel(ch);
					break;
				default :System.out.println("\nInvalid Choice.");
				}				
			System.out.println("\nPress 'Y' for Main-Menu and 'N' for exit.");
			choice=sc.next();
			
		}while(choice.equals("Y")||choice.equals("y"));					
		
		System.out.println("\nThank-You! for dining with us."+"Please Visit Again.");
		
		sc.close();
	}	

}
