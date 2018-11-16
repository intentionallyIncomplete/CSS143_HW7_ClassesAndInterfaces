import java.io.Serializable;

/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov. 16th 2018
 *
 * This is the Date class which only represents the values that a calendar date would hold.
 * */
public class Date implements Comparable<Date>, Cloneable, Serializable{

    /**
     * Class level data members.
     * */
    private int day;
    private int month;
    private int year;

    /**
     * @param month
     * @param day
     * @param year
     * 
     * Constructor takes 3 arguments for month,day,year format.
     * Conditions:
     * 	If 0 < day < 32 && 0 < month < 13 && 2014 < year < 2025
     * 		Object Date is made with the handed values
     * 		else the program exits.
     */
    public Date(int month, int day, int year){

	if(day < 1 || day > 31){
	    System.out.println("invalid day: " + day);
	    System.exit(0);
	}else if(month < 1 || month > 12){
	    System.out.println("invalid month: "+ month);
	    System.exit(0);
	}else if(year < 2014 || year > 2024){
	    System.out.println("invalid year: " + year);
	    System.exit(0);
	}else{
	    this.setDay(day);
	    this.setMonth(month);
	    this.setYear(year);
	}
    }

    /**DEPRECIATED 
     * 
     * @param other - another Date.
     * This copy constructor is no longer used.
     * See the clone method in this class.
     * */
    public Date(Date other){	
	System.out.println("Sorry, this method of cloning is not supported. Use obj.clone() instead");	
    }

    /**
     * This method overrides the default clone() method
     * that is protected in the Cloneable interface and
     * replaces the need for the copy constructor above.
     * */
    public Date clone(){
	try{
	    Date newDate = (Date) super.clone();
	    return newDate;
	}catch(CloneNotSupportedException e){
	    return null;
	}
    }

    /**
     * @param compareToDate
     * @return boolean - Returns a boolean value for if the date handed is after the
     * one making the comparison. Will always return true on the condition that
     * at least one day has passed since the other Date
     * 
     * Checks on the order days --> months --> years
     */
    public boolean isAfter(Date compareToDate){
	if(compareToDate.day < day && compareToDate.month <= month
		&& compareToDate.year <= year){
	    return false;
	}else{
	    return true;
	}
    }

    /**
     * @param other - A Date object to be compared with.
     * */
    public boolean equals(Date other){
	if(this.toString().equals(other.toString())){
	    System.out.println("the two dates are the same");
	    return true;
	}else{
	    System.out.println("the two dates are not the same");
	    return false;
	}
    }

    /**
     * Uses Comparable interface to compare two
     * Date objects against each other. Returns
     * -1 <= X <= 1 when less than, equal to, and greater than respectively.
     * */
    public int compareTo(Date other){
	return this.getDate().compareTo(other.getDate());
    }

    /**
     * @return integer - Returns integer value of the day of this Date.
     */
    public int getDay(){	return day;	}

    /**
     * @return integer - Returns the integer value of the month of this Date.
     */
    public int getMonth(){	return month;	}

    /**
     * @return integer - Returns the integer value of the year of this Date.
     */
    public int getYear(){	return year;	}
    
    /**
     * @return Date - returns a Date.
     */
    public Date getDate(){	return this;	}
    
    /**
     * @param day
     * 
     * Sets the value for the Date's day.
     * Checks first the condition is satisfied that the day is valid.
     */
    public void setDay(int day){
	if(day < 1 || day > 31){
	    System.out.println("invalid day " + day + "\nProgram Exiting...");
	    assert(day > 0);
	    System.exit(0);
	}else{
	    this.day = day;	
	}
    }

    /**
     * @param month
     * 
     * Sets the value for the Date's month.
     * Checks first the condition is satisfied that the month is valid.
     */
    public void setMonth(int month){
	if(month < 1 || month > 12){
	    System.out.println("invalid month " + month + "\nProgram Exiting...");
	    assert(month < 0);
	    assert(month != 12);
	    System.exit(0);
	}else{
	    this.month = month;
	}
    }

    /**
     * @param year
     * 
     * Sets the value for the Date's year.
     * Checks first the condition is satisfied that the year is year.
     */
    public void setYear(int year){
	if(year < 2014 || year > 2024){
	    System.out.println("invalid year " + year);
	    assert(year < 2024);
	    assert(year > 0);
	}else{
	    this.year = year;
	}
    }
    
    @Override
    public String toString(){
	return month + "/" + day + "/" + year;
    }
}