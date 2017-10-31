import java.util.*;
public class Split {

	public static void main(String[] args) {
		
// Playing Around With Split
		
		System.out.println(Arrays.toString("Hello my name is Joseph!".split(" ")));
		System.out.println(Arrays.toString("Iayamaytunaayfishay!".split("ay")));
		System.out.println(Arrays.toString("lll".split("l")));
		System.out.println(Arrays.toString("ljljl".split("l")));
// Task One
		System.out.println(sandwichReader("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
// Task Two
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
		String[] sandwichArray = sandwich.split(" ");
		String ingredients = "";
		for (int i = 0; i < sandwichArray.length; i++) {
			ingredients += sandwichArray[i];
		}
		
		String[] sandwichArray2 =  ingredients.split("bread");
		String ingredients2 = "";
		for (int i = 1; i < sandwichArray2.length - 1; i++) {
			ingredients2 += sandwichArray2[i];
		}
		return ingredients2;
	}

}
