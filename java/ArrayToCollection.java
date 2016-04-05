/**	Program: Converting an array to a Collection using asList() method of Arrays
 * 	Date:	 02.03.2016
 * 	Input: 	 An array of strings.
 * 	Output:	 Array converted to List.
 */

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayToCollection {
    public static List convertArrayToCollection(String[] array) {
    	/** Takes in as input an array of strings and return a list as output
    	 * 	The method asList takes in input the array name that is to be converted into a List.
    	 */
        List<String> list = Arrays.asList(array);		
        System.out.println("The list is:" + list);		//prints the elements of the list.
        return list;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);		//to take the user input for primitive datatypes.
        System.out.println("Enter the number of elements in the array:");
        int arraySize = scan.nextInt();				// number of strings in the array.
        String[] array = new String[arraySize];
        Scanner in = new Scanner(System.in);		//to take user input for non-primitive datatypes.
        int counter = 0;
        while (counter < arraySize) {
            array[counter] = in.nextLine();
            ++counter;
        }
        List list = ArrayToCollection.convertArrayToCollection(array);		//calls the method to convert array to list.
    }
}
