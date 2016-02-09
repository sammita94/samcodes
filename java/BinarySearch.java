
/** Program: Binary Search Example
 * Written by: Sammita Chakravarti(13/CS/18)
 * Input: Number of elements, element's values, value to be searched
 * Output:Position of the number input by user among other numbers */

import java.util.Scanner;
import java.util.Arrays;


class BinarySearch
{

	/**The variables are privately defined in the class
	* They are available to all functions in the class
	* but are not accesible by the object */
	
	int size; //stores the size of the array
	int array[]; //stores the size of the array
	int key; // stores the element to be searched 
    
	/*This array initializes the variables*/
    public void initialize(){
    	
    	java.util.Scanner in=new Scanner(System.in);// Scanner object
    	
    	System.out.println("Enter the number of elements");
    	size = in.nextInt();//stores the size of the array
    	
    	array = new int[size];//array of 'size' elements 
    	
    	System.out.println("Enter the element to searched");
    	key = in.nextInt();//stores the element to be searched
    	
    	System.out.println("Enter the "+size+" elements:");
    	for(int counter=0;counter<size;counter++){
    		array[counter] = in.nextInt();//counter is the iteration variable
    	}
    	
    	search(0,size-1);//this method searches the array from 0 to (size-1) elements
    }
    
    /** This method searches the sorted array for the desired key.
     * It takes in input the array and the element to be searched for
     * and gives as output the position of the element in the array if present,
     * else prints key not found 
     * Variables: 
     * low  = the lower bound in the array
     * high = the upper bound in the array*/
    
    public void search(int low,int high) {
        
    	if(low<=high){
	        int middle = ( low + high ) / 2;//stores the middle position
            if(key < array[middle]){
        	    search(0,middle-1);//searches the first half of the array
            }else if(key > array[middle]){
        	    search(low+1,high);//searches the second half of the array
            } else {
            	System.out.println(key+" found at position "+(middle+1));
            }
        }else{
        	System.out.println("Element not found");
        }
    }


    public static void main(String[] args) {
		
        BinarySearch binsearch=new BinarySearch();//creating an object of the class
        binsearch.initialize();

	}

}
