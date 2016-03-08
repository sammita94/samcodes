
public class exception1 {

	public static String runtimeError(int quotient,int divisor){
		
		String errorMessage="No error encountered";
		
		try{
			int dividend = quotient/divisor;
		}
		catch(ArithmeticException e){
			errorMessage = e.getMessage();
		}
		finally{
			return errorMessage;
		}
	}
	
	public static void main(String[] args){
		
		exception1 er = new exception1();
		System.out.println(er.runtimeError(5, 0));
	}
}
