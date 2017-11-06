
public class ScrambleIt {

	public static void main(String[] args) {
		System.out.println(scrambleIt("ANTELOPE"));

	}
	
	public static String scrambleIt(String word) {

		String[] wordArray = new String[word.length()];
		
		for (int i = 0; i < word.length(); i++) {
			wordArray[i] = "" + word.charAt(i);
		}
		
		for (int i = 0; i < word.length() - 1; i++) {
			if (wordArray[i].equals("A") && !(wordArray[i + 1].equals("A"))) {
				wordArray[i] = wordArray[i + 1];
				wordArray[i + 1] = "A";
				i++;
			}
		}
		
		String scrambledWord = "";
		
		for (int i = 0; i < word.length(); i++) {
			scrambledWord += wordArray[i];
		}
		
		return scrambledWord;
	}

}
