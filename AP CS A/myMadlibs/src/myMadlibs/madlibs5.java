package myMadlibs;
import java.util.Scanner;

public class madlibs5 {
	public static void main(String str[]) {
		// a storyLine with a phrase in angle brackets at its beginning
		// produces plural noun						  
		System.out.println(madlibs4.wordInsideBrackets("<plural noun> four score and seven years ago"));

		// a storyLine with a phrase in angle brackets at its very end
		// produces name
		System.out.println(madlibs4.wordInsideBrackets("hello <name>"));

		// a storyLine with a phrase embedded within
		// produces plural noun
		System.out.println(madlibs4.wordInsideBrackets("Four score and seven <plural noun> ago"));

		// a storyLine with a phrase in angle brackets consisting of a single word
		// produces word
		System.out.println(madlibs4.wordInsideBrackets("<word>"));

		// a storyLine with a phrase in angle brackets consisting of two or more phrases
		// produces Four score and seven years ago
		System.out.println(madlibs4.wordInsideBrackets("<Four score and seven years ago>"));

		// a storyLine with multiple sets of angle brackets containing different phrases
		// produces human
		System.out.println(madlibs4.wordInsideBrackets("hello <human>. <nice to see you>"));

		// a storyLine with multiple sets of angle brackets containing the same phrase
		// produces human
		System.out.println(madlibs4.wordInsideBrackets("hello <human>. nice to see you, <human>!"));

		// a storyLine with the phrase <Amount of $> inside angle brackets and a number to substitute for it
		// produces Amount of $
		System.out.println(madlibs4.wordInsideBrackets(" Amount paid: <Amount of $>"));

		// an empty storyLine
		// produces an empty string
		System.out.println(madlibs4.wordInsideBrackets("Four score and seven < > years ago"));

		// a storyLine with no angle brackets
		// produces an empty string
		System.out.println(madlibs4.wordInsideBrackets("Four score and seven years ago"));

		// ---
		
		// no angle brackets
		// prints Hello name!
		System.out.println(madlibs5.queryReplace("Hello name!"));

		// a phrase in angle brackets at the very start
		// put in Sarah --> prints Sarah, what are you doing?
		System.out.println(madlibs5.queryReplace("<name>, what are you doing?"));

		// a phrase in angle brackets at the very end
		// put in Sarah --> prints Hello Sarah
		System.out.println(madlibs5.queryReplace("Hello <first>"));

		// two phrases in separate angle brackets
		// put in dog for noun and quickly for adverb --> prints The dog climbed the tree quickly.
		System.out.println(madlibs5.queryReplace("The <noun> climbed the tree <adverb>."));

		// three different phrases in angle brackets
		// put in Lisa, jumped and Chicago --> prints Lisa jumped in Chicago.
		System.out.println(madlibs5.queryReplace("<noun> <past tense verb> in <city>."));

		// Two phrases in angle brackets where the close bracket for the first is next to the open bracket for the second
		// put in Lisa and jumped --> prints Lisa jumped
		System.out.println(madlibs5.queryReplace("<noun> <past tense verb>"));

		// an empty phrase
		// prints an empty string
		System.out.println(madlibs5.queryReplace(""));


		// ---

		// a phrase with a
		// uses enter an
		// put in short --> produces he is very short
		System.out.println(madlibs5.queryReplace("He is very <adjective>."));

		// a phrase with e
		// uses enter an
		// put in wifi --> produces wifi cable
		System.out.println(madlibs5.queryReplace("<ethernet> cable"));

		// a phrase with I
		// uses enter an
		// put in ethernet --> produces ethernet cable
		System.out.println(madlibs5.queryReplace("<internet> cable"));

		// a phrase with o
		// uses enter an
		// put in right --> produces on the right hand
		System.out.println(madlibs5.queryReplace("on the <other> hand"));

		// a phrase with u
		// uses enter an
		// puts in but --> produces guilty but proven innocent
		System.out.println(madlibs5.queryReplace("guilty <until> proven innocent"));

		// a phrase with b
		// uses enter a
		// puts in on --> produces on the way
		System.out.println(madlibs5.queryReplace("<by> the way"));

		// a phrase with c
		// uses enter a
		// puts in dog --> produces dog out of the bag
		System.out.println(madlibs5.queryReplace("<cat> out of the bag"));

		// a phrase with D
		// uses enter a
		// puts in cat --> produces cat out of the bag
		System.out.println(madlibs5.queryReplace("<Dog> out of the bag"));
	}

	public static String queryReplace(String storyLine) {
		String[] arr = new String[storyLine.length()];
		for (int i = 0; i < storyLine.length(); i++) {
			arr[i] = storyLine.substring(i, i+1);
		}
		String message = "";
		String qw = " ";
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < storyLine.length(); i++) {
			if(arr[i].equals("<")) {
				qw = "<";
				do {
					i++;
					qw += arr[i];
				} while( !arr[i].equals(">"));
				String w = wordInsideBrackets(qw);
				String fl = w.substring(0, 1);
				if (fl.equals("a") || fl.equals("A") || fl.equals("e") || fl.equals("E") || fl.equals("i") || fl.equals("I")  || fl.equals("o") || fl.equals("O")  || fl.equals("u") || fl.equals("U")) {
					System.out.println("Enter an " + w + ":");
				} else {
					System.out.println( "Enter a "+ w +":");
				}
				String ans = sc.nextLine();
				w = substituteWord(qw, ans);
				message += w;
			}
			else {
				message += arr[i];
			}
		}
		return message;

	}	


	public static String substituteWord(String storyLine, String word) {
		String empty = "";
		int length = storyLine.length();
		int index1 = storyLine.indexOf("<");
		int index2 = storyLine.indexOf(">");
		String indexbefore = storyLine.substring(0, index1);
		String indexafter = storyLine.substring(index2 + 1, length);
		empty = indexbefore + word + indexafter;
		return empty;
	}

	public static String wordInsideBrackets(String storyLine) {
		int start = storyLine.indexOf("<");
		int end = storyLine.indexOf(">");
		if (start == -1) {
			storyLine = " ";
			return storyLine;
		}
		storyLine = storyLine.substring(start + 1, end);
		return storyLine;
	}
}
