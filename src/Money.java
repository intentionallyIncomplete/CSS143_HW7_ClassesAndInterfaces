import java.io.Serializable;

/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov. 15th, 2018
 * JRE Compliance version 1.5
 * 
 * Money.java holds data about the dollar and cent amounts of any transaction. Each "Money" can count towards a reduction
 * or addition to a Bill which affects the ExpenseAccount assigned to the Bill.
 */
public class Money implements Comparable<Money>, Cloneable, Serializable{

    /**
     * Default generated serialized ID. Allows for conversion of Money
     * to byte stream for writing to files and reading into stream later.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Class level data members
     * */
    private int dollars;
    private int cents;

    /**
     * Constructor for Money that takes only a single integer argument for dollars.
     * Set cents to 0.
     * @param dollars  - integer value for dollars.
     * */
    public Money(int dollars){
	this.add(dollars);
	this.cents = 0;
    }

    /**
     * @param dollars
     * @param cents 
     * 
     * Other constructor for Money takes in two integer arguments to allow for
     * dollars and cents input. Cents are converted to dollars later.
     * */
    public Money(int dollars, int cents){
	this.setMoney(dollars, cents);
    }

    /** [DEPRECIATED]
     * Copy constructor no longer used.
     * @param other  - a separate Money that may have the same or different values.
     * @see clone()
     * */
    public Money(Money other){
	System.out.println("Use obj.clone() for copies");
    }

    /**
     * Clone method for class Money will attempt to use the 
     * constructor of itself to make a new copy using the same data.
     * 
     * Generates and throws a CloneNotSupportedException on attempts
     * to create a clone of Money without using clone().
     * */
    @Override
    public Money clone(){
	try{
	    Money newMoney = (Money) super.clone();
	    return newMoney;
	}catch(CloneNotSupportedException cnse){
	    System.out.println("Could not create copy" + cnse.getCause());
	    return null;
	}
    }

    /**
     * @return boolean - Returns boolean from comparing
     * handed object against present object's amounts represented
     * in double type values. Will first check if the object handed was null
     * and immediately return false if the condition is satisfied.
     * @param other - An object of type Money
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Money other){

	if((other) == null){	return false;	}
	// Comparing doubles returned from getMoney()
	else if(this.getMoney() == (other).getMoney()){	return true;	}
	else{	return false;	}
    }

    /**
     * @return int - Returns integer value on the condition of some object
     * being less than, equal to, or greater than another.
     * @param other - Represents another Money object to compare to.
     * 
     * Will always need to return an integer value within the domain of -1 <= x <= 1.
     * Will depend on the overriden toString method at the bottom of this vlass
     * to be able to compare the objects since the Comparable interface works with String objects only I think.
     * 
     * @see https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
     * */
    public int compareTo(Money other) {
	
	return this.toString().compareTo(other.toString());
    }


    /**
     * @param dollars - integer
     * Allows adding to the Money object of whole, integer values.
     */
    public void add(int dollars){
	if(dollars >= 0){
	    this.dollars += dollars;    
	}else{
	    System.out.println("Amount must be greater than or equal to 0. Cannot take on negative dollar amounts");
	}
    }

    /**
     * @param dollars
     * @param cents
     * 
     * Overloaded method with signature that allows for two input parameters to
     * represent dollars and cents.
     * 
     * <i>cents are converted to dollars if >= 100 using the `%` operator to gain the remainder of x/100 
     * and the `/` operator to gain the integer value of x/100.</i>
     */
    public void add(int dollars, int cents){
	if(dollars >=0 && cents >= 0){
	    this.dollars += dollars;
	    this.cents += cents;
	}else{
	    System.out.println("Values added must be positive.");
	}
    }

    /**
     * @param other
     * 
     * Allows adding of an actual money object to another Money object.
     * Error checking is already done on the Money's value before it's
     * instantiated so no conditions are checked here.
     */
    public void add(Money other){
	this.dollars += other.getDollars();
	this.cents += other.getCents();
    }

    /**
     * @return double - Returns a double value that is the amount of Money
     * currently stored in the Money object that's being called on.
     */
    public double getMoney(){
	return this.getDollars() + this.getCents();
    }

    /**
     * @return int - Returns the integer value of the dollar amount held
     * by this Money object.
     */
    public int getDollars(){
	return this.dollars;
    }

    /**
     * @return int - Returns the integer value of the cent amount held
     * by this Money object.
     */
    public double getCents(){
	return ((double)cents/100);
    }

    /**
     * @param dollars
     * @param cents
     * 
     * Sets whatever the current integer values of dollar and cents are to the amount
     * handed through the method parameters.
     */
    public void setMoney(int dollars, int cents){
	if(dollars >= 0 && cents >= 0){
	    this.dollars = dollars;
	    this.cents = cents;
	}else{
	    System.out.println("Amounts of dollars and cents must be greater than or equal to 0");
	}
    }

    /**
     * @return String - Returns a String value of the Money's attributes in units of USD.
     * */
    @Override
    public String toString(){
	return "$" + String.format("%.2f", getMoney());
    }
}