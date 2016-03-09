public class threadsInJava extends Thread{
 
  private long _fibonacciValue = 0;
  private int size;

  public threadsInJava(int n){
	  size=n;
  }
  public long getFibonacci(){
    return _fibonacciValue;
  }

  public void run(){
    _fibonacciValue = fibonacci(size);
  }

  private long fibonacci(int n){
    if(n==0) return 0L;
    if(n==1) return 1L;

    return (fibonacci(n-1) + fibonacci(n-2));
  }



	  public static void main(String[] args){
	  
	    threadsInJava fib = new threadsInJava();

	    fib.start();

	  
	    try{
	      fib.join();
	    }catch(InterruptedException ie){}

	
	    long fibonacci = fib.getFibonacci();

	    System.out.println("The fibonacci value = " + fibonacci);
	  }
	}