/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov. 16th, 2018
 * 
 * Tracks and manages a dynamic list of Bills.
 * This emulates the properties of a having an expense account
 * that may hold several bills at once all in different states.
 */
public class ExpenseAccount extends ArrayList<Bill> {

    /**
     * Class level data members.
     * List of Bills is used to manage payment to Bills.
     * */
    ArrayList<Bill> listOfBills = new ArrayList<Bill>();

    /**
     * Constructor takes no arguments. Not to be instantiated beyond declaring
     * space for an array in memory.
     * */
    public ExpenseAccount() {}

    /**
     * @param other - A Bill.
     * 
     * Takes in a Bill to be added into the list in the
     * correct index ("account").
     * */
    public void addABill(Bill other){
	if(other != null){
	    listOfBills.insert(other, getIndex());
	}else{
	    System.out.println("Bill is not valid or null");
	}
    }

    /**
     * @param other - A Bill. 
     * 
     * Takes a Bill out of the list as long as it is paid and valid.
     * */
    public void removeABill(Bill other){
	if(other == null || other.isPaid() == false){
	    System.out.println("Cannot remove bill for it is unpaid or not a valid bill");
	}else{
	    listOfBills.remove();
	}
    }

    /**
     * Displays list of Bills.
     * */
    @Override
    public void show(){
	listOfBills.show();
    }
}
