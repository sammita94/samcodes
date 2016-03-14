import junit.framework.TestCase;
import org.junit.Assert;
public class FibonacciTest extends TestCase{

	
	public void setUp() throws Exception {
	}

	
	public void tearDown() throws Exception {
	}

	public void testFib1(){
		int arrayexpected[]={0,1,1,2,3};
		int arrreturned[]=Fibonacci.fibSeries(5);
		Assert.assertArrayEquals(arrayexpected,arrreturned);
	}
	public void testFib2(){
		int arrayexpected[]={0,1,1,2,3,5};
		int arrreturned[]=Fibonacci.fibSeries(6);
		Assert.assertArrayEquals(arrayexpected,arrreturned);
	}
	

}