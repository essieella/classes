package exp;
import java.util.ArrayList;

public class TokenPass {
	public static String scrambledWord(String word) {
		String answer = "";
		for (int i = 0; i < word.length(); i++) {
			// int end = i+2;
			if (word.substring(i, i+1).equals("A") && i+2 < word.length() &&!(word.substring(i+1, i+2).equals("A"))) {
				answer = answer + word.substring(i+1, i+2) + word.substring(i,i+1);
				i++;
			} else {
				answer = answer + word.substring(i, i+1);
			}
		} return answer;
	}
	
	public static void ScrambleOrRemove(ArrayList <String> wordList) {
		for (String s: wordList) {
			if (scrambledWord(s).equals(s)) {
				wordList.remove(s);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(scrambledWord("EGGS"));
		System.out.println(scrambledWord("TAN"));
		System.out.println(scrambledWord("APPLE"));
		System.out.println(scrambledWord("WHOA"));
		System.out.println(scrambledWord("ABRACADABRA"));
		ArrayList<String> a = new ArrayList<>();
		a.add(scrambledWord("EGGS"));
		a.add(scrambledWord("TAN"));
		a.add(scrambledWord("APPLE"));
		a.add(scrambledWord("WHOA"));
		a.add(scrambledWord("ABRACADABRA"));
		ScrambleOrRemove(a);
		for (String s:a) {
			System.out.println(s);
		}
	}
}
