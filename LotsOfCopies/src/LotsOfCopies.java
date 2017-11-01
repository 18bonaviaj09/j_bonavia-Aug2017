// Joseph Bonavia
// The point of this Mini Lab and program are to experiment with changing Array Values.

import java.util.*;
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		changeMe(num, strMain, arrMain);
		System.out.println(num); // When the Integer is changed in another method it does NOT change;
		System.out.println(strMain); // When the String is changed in another method it does NOT change;
		System.out.println(Arrays.toString(arrMain)); // When the Array is changed in another method it DOES change;
		aTob();
		
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x = 8;
		str = "SCPA";
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 1;
		}
	}
	public static void  aTob() {
		int numA = 1;
		int numB = numA;
		numA += 1;
		System.out.println(numB); // When the copies of an Integer are changed it does not affect the other copies.
		String strA = "Hello";
		String strB = strA;
		strA = "World";
		System.out.println(strB); // When the copies of a String are changed it does not affect the other copies.
		int[] arrA = {2, 4, 6, 8};
		int[] arrB = arrA;
		for (int i = 0; i < arrA.length; i++) {
			arrA[i] += 1;
		} 
		System.out.println(Arrays.toString(arrB)); // When the ANY of the copies of and Array are changed they ALL change.
	}
}
