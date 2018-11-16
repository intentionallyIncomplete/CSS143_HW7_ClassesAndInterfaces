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
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
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
	
    }
}