/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov. 16th 2018
 * @param <T>
 * 
 * ArrayList.java contains the functionality and limits of the list that
 * manages the ExpenseAccount.
 */
public class ArrayList<T> {

    /**
     * Class level data members.
     * */
    private Object[] arrList;
    private int nextElement = 0;
    private int arrListSize;


    /**
     * @param arrListSize
     * 
     * Constructor takes in integer size of number of ExpenseAccount Bills
     * to handle.
     */
    public ArrayList(int arrListSize){
	this.arrListSize = arrListSize;
	this.arrList = new Object[arrListSize];
    }

    /**
     * Constructor takes no arguments. No Bill available for the ExpenseAccount
     * so the list is empty.
     */
    public ArrayList(){
	arrList = new Object[1];
	nextElement = 0;
    }

   
    /**
     * @param anElement
     * @param index
     * 
     * Add an element to the list.
     */
    public void insert(Object anElement, int index){
	arrList[index] = anElement;
    }

    /**
     * @return Gets the index position of the last index.
     */
    public int getIndex(){
	int index = arrList.length -1;
	return index;
    }
    
    /**
     * @return Returns the Object removed at the last position in the list.
     */
    public Object remove(){
	if(nextElement >= 0){
	    System.out.println("the element: " + arrList[nextElement] + 
		    " has been removed successfully");
	    return arrList[nextElement--];
	} else {

	    System.out.println("no items, array is empty");

	    return "-1";
	}
    }

    
    /**
     * Print the items in the array
     */
    public void show(){
	for(Object i : arrList){
	    System.out.println(i.toString());
	}
    }

    
    /**
     * @param that
     * @return Return boolean value on the condition of this == that.
     */
    public boolean equal(Object that){
	if(this == that){
	    return true;
	}else{
	    return false;
	}
    }

    @Override
    public String toString(){
	StringBuilder sb = new StringBuilder();

	while(arrList[nextElement] != null){
	    sb.append(" ").append(arrList[nextElement]);
	}
	return sb.toString();
    }
}
