/**
 * @author Ian Bryan
 * 
 * Note: Uncomment for testing. Each added method has its own area
 * in the main method for testing from each class.
 * 
 * All comments previously not in Javadoc format have been converted
 * with exclusion to the lines that are to be uncommented one at a time
 * for testing. 
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
	System.out.println("Value of Money(1):::" + money1.toString());
    }
}