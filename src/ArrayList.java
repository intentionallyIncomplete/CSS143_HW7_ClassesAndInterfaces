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


    public ArrayList(int arrListSize){
	this.arrListSize = arrListSize;
	this.arrList = new Object[arrListSize];
    }

    public ArrayList(){
	arrList = new Object[1];
	nextElement = 0;
    }

    /*****************************************************/
    /* takes in an object and the specified index ## in	 */
    /* the array and adds the object at that position	 */
    /* does not check for valid input					 */
    /*****************************************************/
    public void insert(Object anElement, int index){
	arrList[index] = anElement;
    }

    public int getIndex(){
	int index = arrList.length -1;
	return index;
    }
    /*****************************************************/
    /* checks first if the array is populated, then 	 */
    /* prints a message about the next step which is the */
    /* removal of the current position by setting the arr*/
    /* to the decremented value of the nextElement		 */
    /*****************************************************/
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

    /*****************************************************/
    /* show the items in the array */
    /*****************************************************/
    public void show(){
	for(Object i : arrList){
	    System.out.println(i.toString());
	}
    }

    /*****************************************************/
    /* checks for equality between the current object and*/
    /* a passed object									 */
    /*****************************************************/
    public boolean equal(Object that){
	if(this == that){
	    return true;
	}else{
	    return false;
	}
    }

    /*
     * This method is used to find the next available space
     * in the list to add the next Bill. 
     * The list is iterated over and each space is 
     * checked for a null value.
     * */
    //	public int getNextElement(){
    //		for(int i=0;i<arrList.length;i++){
    //			if(arrList[i] == null){
    //				nextElement = indexOf(arrList[i]);
    //				return nextElement;
    //			}else{
    //				return -1;
    //			}
    //		}
    //		return nextElement;
    //	}

    /*
     * This method will iterate over the current list looking for an object
     * specified. The use of this method in the getNextElement function
     * is to find a null object and return it's position. This way it 
     * can be filled by an object if the addABill method is invoked
     * in the ExpenseAccount class.
     * */
    //	public int indexOf(Object obj) {
    //		for (int i = 0; i < arrList.length; i++) {
    //			if (arrList[i].equals(obj)) {
    //				return i;
    //			}
    //		}
    //		return -1;
    //	}

    /*****************************************************/
    /* This toString method will override the default    */
    /* toString method. The StringBuilder will build an  */
    /* string object with a space appended between the	 */
    /* elements in the object array						 */
    /*****************************************************/
    @Override
    public String toString(){
	StringBuilder sb = new StringBuilder();

	while(arrList[nextElement] != null){
	    sb.append(" ").append(arrList[nextElement]);
	}
	return sb.toString();
    }
}
