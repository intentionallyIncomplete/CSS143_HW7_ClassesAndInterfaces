import java.io.Serializable;

/**
 * Class Description:
 * @author Ian Byan
 * @version Nov.16th, 2018
 * 
 * Represents a Bill which holds values of Money and Date.
 */
public class Bill implements Comparable<Bill>, Cloneable, Serializable{

    /**
     * Class level data members.
     * */
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * @param amount
     * @param dueDate
     * @param originator
     */
    public Bill(Money amount, Date dueDate, String originator){
	this.amount = amount;
	this.dueDate = dueDate;
	this.paidDate = null;
	this.originator = originator;
    }


    /**[DEPRECIATED]
     * @param toCopy
     */
    public Bill(Bill toCopy){
	System.out.println("This method is no longer supported. Use clone instead.");
    }

    /**
     * This method overrides the protected clone()
     * method from the Cloneable interface. A new Bill object
     * is instantiated using the current values of Bill. Then,
     * the super class ctor of Cloneable is invoked to create a copy
     * of the fields specified within the try{} block.
     * */
    @Override
    public Bill clone(){
	try {
	    Bill newBill = (Bill) super.clone();
	    newBill.amount = this.amount.clone();
	    newBill.dueDate = this.dueDate.clone();
	    if(isPaid()){
		newBill.paidDate = this.paidDate.clone();
	    }
	    return newBill;
	} catch (CloneNotSupportedException e) {
	    System.out.println(e);
	    return null;
	}

    }

    
    /**
     * @return boolean - Returns boolean value on the condition
     * of paidDate being null.
     */
    public boolean isPaid(){
	if(paidDate != null){
	    return true;
	}else{
	    return false;
	}
    }

    /**
     * @param other - A Bill object.
     * 
     * Takes in a Bill to be checked against another.
     * */
    public boolean equals(Bill other){
	if(this.getDueDate().equals(dueDate)
		&& this.getAmount() == other.getAmount()
		&& this.paidDate.equals(other.paidDate)){
	    return true;
	}else{
	    return false;
	}
    }


    /**
     * This compareTo() method overrides the default
     * compareTo() method and acts in a similar fashion.
     * The return value is an integer of 1 for the objects
     * being equal, or else if they are not then return -1. 
     * 
     * @param other is an Object data type used to
     * pass the values of a Bill through into the method.
     * 
     * */
    public int compareTo(Bill other){
	return this.compareTo(other);
    }


    /**
     * @return Returns the amount of Money.
     */
    public Money getAmount(){
	return this.amount;
    }

    /**
     * @return Returns the Date the Bill was set to be due by.
     */
    public Date getDueDate(){
	return this.dueDate;
    }

    /**
     * @return Returns the name of the entity doing the charging.
     */
    public String getOriginator(){
	return this.originator;
    }
    /****************************************************/
    /* End getters, begin setters */
    /****************************************************/

    /**
     * @param datePaid
     * 
     * Allows setting of the date paid for the present Bill in question.
     * 
     */
    public boolean setPaid(Date datePaid){
	if(datePaid.isAfter(dueDate)){
	    this.paidDate = datePaid;
	    System.out.println("Bill was outstanding and not paid on time");
	    return false;
	}else{
	    System.out.println("Bill has been paid on: " + datePaid);
	    this.paidDate = datePaid;
	    return true;
	}
    }

    /**
     * @param nextDate - A Date that is the value of the next date
     * the bill should be paid by.
     * */
    public boolean setDueDate(Date nextDate){
	if(isPaid()){
	    return false;
	}else{
	    this.dueDate = nextDate;
	    return true;
	}
    }

    /*
     * This method will take in a new Money object
     * that has a value. Then a condition is checked
     * that if that new value is 0, the bill is paid,
     * else the amount is set to the latest value.
     * 
     * @param amount is a Money object.
     * @see class variable delcarations
     */

    public boolean setAmount(Money amount){
	if(isPaid()){
	    assert(amount != null);
	    this.amount.setMoney(0, 0);
	    return false;
	}else{
	    this.amount = amount;
	    return true;
	}
    }

    /****************************************************/
    /* End setters */
    /****************************************************/

    /*
     * custom toString method will get the amount of money,(non-Javadoc).
     * the dueDate, the paidDate, and the name of the company
     * doing the billing and tell the person the status of the 
     * transactions. The return String is different depending on the 
     * condition of isPaid. When true, it will print the first String,
     * else it will print the other.
     * 
     * @see java.lang.Object#toString()
     */

    public String toString(){
	if(isPaid()){
	    assert(paidDate != null);
	    return "Amount Due: " + this.amount + "\nCurrent Due Date: "
	    + this.dueDate.toString() + "\nOrigin of Bill: " + this.originator
	    + "\nDate Paid: " + this.paidDate;
	}else{
	    return "Amount Due: " + this.amount + "\nCurrent Due Date: "
		    + this.dueDate.toString() + "\nOrigin of Bill: " + this.originator
		    + "\nBill is unpaid or outstanding";
	}
    }
}