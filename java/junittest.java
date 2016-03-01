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
	 
	 /*Black Box Testing:
	  * Boundary Value Checking
	  * Robust Checking
	  */
	 
	 public void testBinaryMinTest(){
		
		    
		   search =1;  
		   int index =1;
		   int indexreturn=BinarySearch.searchElementInArray(0,9,array, search);
		   System.out.println(indexreturn);
		   assertEquals(indexreturn,index);
	   }
	public void testBinaryMinPlusTest()
	   {
		 
		  search = 2;  
		  int index =3;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		  assertNotSame(indexreturn,index);
	   }
	 public void testBinaryNormalTest(){
		 
		  search =8;  
		  int index =8;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinaryMaxTest(){
		 
		  search =10;  
		  int index =10;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinaryMaxMinusTest(){
		 
		  search =9;  
		  int index =9;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinaryMaxPlusTest(){
		 
		  search =11;  
		  int index =-1;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 public void testBinaryMinMinusTest(){
		 
		  search =0;  
		  int index =-1;
		  int indexreturn=BinarySearch.searchElementInArray(0,9,array,search);
		   assertEquals(indexreturn,index);
	   }
	 
	 /*Black Box Testing:
	  * Equivalence Class Testing 
	  */
	 
	 public void testBinaryEqClassTest1(){
		 
		  search =17;  
		  int arr[]={17};
		  int index =1;
		  int indexreturn=BinarySearch.searchElementInArray(0,1,arr,search);
		  assertEquals(indexreturn,index);
		 
	 }
	 
	 public void testBinaryEqClassTest2(){
		 
		  search =3;  
		  int arr[]={17};
		  int index =-1;
		  int indexreturn=BinarySearch.searchElementInArray(0,1,arr,search);
		  assertEquals(indexreturn,index);
		 
	 }
	 
	 public void testBinaryEqClassTest3(){
		 
		  search =19;  
		  int arr[]={17,18,19,20};
		  int index =3;
		  int indexreturn=BinarySearch.searchElementInArray(0,4,arr,search);
		  assertEquals(indexreturn,index);
		 
	 }
	 public void testBinaryEqClassTest4(){
		 
		  search =3;  
		  int arr[]={17,18,19,20};
		  int index =-1;
		  int indexreturn=BinarySearch.searchElementInArray(0,4,arr,search);
		  assertEquals(indexreturn,index);
		 
	 }

}
