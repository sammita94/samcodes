import junit.framework.TestCase;

public class junittest extends TestCase {

	private int[] array;
	private int search;
	public junittest(String testName){
		super(testName);
	}
	protected void setUp() throws Exception{
		   super.setUp();
		   array=new int[10];
		   for(int i=0;i<10;i++)
			   array[i]=i+1;
		    search =3;
	   }
	 protected void tearDown() throws Exception{
		   super.tearDown();
		   
		   
	   }
	 public void testBinarymintest(){
		
		    
		   search =1;  
		   int index =1;
		   int indexreturn=BinarySearch.searchElementInArray(0,9,array, search);
		   System.out.println(indexreturn);
		   assertEquals(indexreturn,index);
	   }
	public void testBinaryminminustest()
	   {
		 
		  search =-6;  
		  int index =3;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		  assertNotSame(indexreturn,index);
	   }
	 public void testBinarynormaltest(){
		 
		  search =6;  
		  int index =6;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinarymaxtest(){
		 
		  search =10;  
		  int index =10;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinarymaxplustest(){
		 
		  search =15;  
		  int index =-1;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }

}
