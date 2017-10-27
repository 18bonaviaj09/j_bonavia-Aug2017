import java.util.*;
public class Split {

	public static void main(String[] args) {

		System.out.println(Arrays.toString("Hello my name is Joseph!".split(" ")));
		System.out.println(Arrays.toString("Iayamaytunaayfishay!".split("ay")));
		System.out.println(Arrays.toString("lll".split("l")));
		System.out.println(Arrays.toString("ljljl".split("l")));
		System.out.println(sandwichReader("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(sandwichReader("applespineapplesbreadbigmacsaucetwopattiespicklesbreadmustardtomatolettucebreadcheese"));
		System.out.println(sandwichReaderImproved("apples pineapples bread lettus tomato bacon mayo ham bread cheese"));
	}
	public static String sandwichReader(String sandwich) {
		String[] sandwichArray =  sandwich.split("bread");
		String ingredients = "";
		for (int i = 1; i < sandwichArray.length - 1; i++) {
			ingredients += sandwichArray[i];
		}
		return ingredients;
	}
	public static String sandwichReaderImproved(String sandwich) {
		String[] sandwichArray =  sandwich.split("bread");
		String ingredients = "";
		for (int i = 1; i < sandwichArray.length - 1; i++) {
			ingredients += sandwichArray[i];
		}
		String[] ingredientsArray = ingredients.split(" ");
		for (int i = 0; i < sandwichArray.length; i++) {
			ingredients += ingredientsArray[i];
		}
		return ingredients;
	}
	


	//Your task pt 2:
	/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/

}
