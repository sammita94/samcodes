import static org.junit.Assert.*;
import junit.framework.TestCase;



public class threadsInJavaTest extends TestCase{

	
	public void setUp() throws Exception {
	}

	
	public void tearDown() throws Exception {
	}

	
	public void test1() {
		 threadsInJava fib = new threadsInJava(6);

		    fib.start();
		    try{
			      fib.join();
			    }catch(InterruptedException ie){}
		    
		    long fibonacci = fib.getFibonacci();
		    long fibbo = 8;
		    assertEquals(fibonacci,fibbo);
	
	}

}
