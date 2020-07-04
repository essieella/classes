package myMadlibs;

public class madlibs4 {
public static void main(String str[]) {
		
		// a storyLine with a phrase in angle brackets at its beginning
		// produces plural noun						  
	System.out.println(madlibs4.wordInsideBrackets("<plural noun> four score and seven years ago"));
		
		// a storyLine with a phrase in angle brackets at its very end
		// produces name
		System.out.println(madlibs4.wordInsideBrackets("hello <name>"));
		
		// a storyLine with a phrase embedded within
		// produces plural noun
		System.out.println(madlibs4.wordInsideBrackets
("Four score and seven <plural noun> ago"));
		
// a storyLine with a phrase in angle brackets consisting of a single word
		// produces word
		System.out.println(madlibs4.wordInsideBrackets("<word>"));
		
// a storyLine with a phrase in angle brackets consisting of two or more phrases
		// produces Four score and seven years ago
System.out.println(madlibs4.wordInsideBrackets
("<Four score and seven years ago>"));
		
// a storyLine with multiple sets of angle brackets containing different phrases
		// produces human
		System.out.println(madlibs4.wordInsideBrackets
("hello <human>. <nice to see you>"));
		
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

