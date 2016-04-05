/** Program : Junit testing for the program "ArrayToCollection.java"
 * 	Date:     02.03.2016
 */

import java.util.List;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayToCollectionTest
extends TestCase {
    private String[] array;				//array that is to be converted into list.
    private int size;					//variable to store the length of the array.

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.array = new String[]{"abc", "def", "ghi"};		//initialising the array
        this.size = 3;										//storing the size of the array
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSize() {
    	/*checks whether the size of the list returned by the method convertArrayToCollection(this.array)
    	 * is same as the size of the array that was converted to the list.
    	 */
        List list = ArrayToCollection.convertArrayToCollection(this.array);
        ArrayToCollectionTest.assertEquals((int)list.size(), (int)this.size);
    }
    public void testAfterAddingElementToList(){
    	/*This method first adds new element to the list returned using the method list.add(int,String)
    	 * Since the method asList() returns a list that is directly backed by array, it is not modifiable,
    	 * so we have to create a new modifiable list by copying the wrapper list's contents.
    	 */
    	List list = new LinkedList<String>(ArrayToCollection.convertArrayToCollection(this.array));
    	list.add(1,"jkl");
        ArrayToCollectionTest.assertEquals((int)list.size(), (int)this.size+1);
    }
}
