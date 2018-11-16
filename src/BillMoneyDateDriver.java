/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov. 15th, 2018
 * 
 * This is the driver or `main` class of the entire program. All tests and calls to different methods in
 * all the classes is done here.
 */
public class BillMoneyDateDriver
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	/**
	 * Instantiating new Money objects and testing each of the class's methods.
	 * */
	System.out.println("Making Money with value of $1");
	Money money1 = new Money(1);
	System.out.println("Value of Money(1) == " + money1.toString());
	
	Money moneyClone = money1.clone();
	System.out.println("Testing clone method. Cloned " + money1.toString() + 
		" to object moneyClone with a value of " + moneyClone.toString());
	System.out.println("Now making another Money object with two arguments. One for dollars and one for cents.");
	Money money2 = new Money(10,101); // = $10.01
	System.out.println("Added " + money2.getDollars() + " and " + money2.getCents() + " to make a total of " + money2.toString());
	System.out.println("Does money1 equal money2?::::" + money1.equals(money2));
	// Set money1 to the values of money 1 and run the equals method again.
	money1.setMoney(10, 101);
	System.out.println("Does money1 equal money2?::::" + money1.equals(money2));
	System.out.println("Running the compareTo() method:::: " + money1.compareTo(money2));
	// Set money2 to some new values
	money2.setMoney(20, 123);
	System.out.println("money2 is now " + money2);
	System.out.println("getCents " + money2.getCents());
	System.out.println("Running the compareTo() method:::: " + money1.compareTo(money2));
	money1.add(10);
	System.out.println("Added $10 to money1 -  is now::: " + money1);
	money1.add(10, 01);
	System.out.println("Added $10 and 1 cent to money1 -  is now::: " + money1.getMoney());
	money1.add(money2);
	System.out.println("Added money2 to money1 -  is now::: " + money1.getMoney());
	// Quick test of getters
	System.out.println("getDollars() of money1 :: " + money1.getDollars());
	System.out.println("getCents of money1 :: " + money1.getCents() + "\n" +
			"------------------------\n------------------------");
	/*---------------------------------------------------------------------*/
	/**
	 * Instantiation of Date objects and testing the methods in it.
	 * */
	//m,d,y
	Date date1 = new Date(11,16,2018);
	System.out.println("date1 = " + date1);
	Date date2 = new Date(7,14,2020);
	System.out.println("Created date2 with values :: " + date2);
	date2.setDate(date1);
	System.out.println("Set the value of date2 to date1 using setDate(). Date2 is: " + date2);
	date2.setYear(2023); //toggle this to test isAfter and equals.
	System.out.println("isAfter? :: " + date2.isAfter(date1));
	System.out.println("isAfter? :: " + date1.isAfter(date2));
	System.out.println("equals()? :: " + date1.equals(date2));
	
	Bill bill_1 = new Bill(money1, date1, "University of Washington");
	System.out.println("Current Bill --> " + bill_1);
	bill_1.setDueDate(date2);
	System.out.println("Updated due date --> " + bill_1.getDueDate());
    }
}