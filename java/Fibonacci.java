
public class Fibonacci {
	
	public static int[] fibSeries(int n){
		
		int array[]=new int[n];
		if(n>=1){
			array[0]=0;
		}
		if(n>=2){
			array[1]=1;
		}
		int i=2;
		while(i<=n-1){
			array[i]=array[i-1]+array[i-2];
			i=i+1;
		}
		for(i=0;i<n;i++)
			System.out.print(array[i]+" ");
		return array;
	}
	public static void main(String[] args){
		Fibonacci f=new Fibonacci();
		int arr[]=fibSeries(5);
	}

}