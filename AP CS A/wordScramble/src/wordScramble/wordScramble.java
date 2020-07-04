package wordScramble;
import java.util.Scanner; 

public class wordScramble {
	int x_pos;
	int y_pos;
	int[] xlist;
	int[] ylist;
	static int count;
	int[] xylist;
	String[] masterlist;
	public static void main(String str[]) {
		String[] wordList = new String[4];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.print("ENTER A WORD WITH FOUR OR FEWER LETTERS: ");
			String word = sc.nextLine();
			if (word.length() > 4) {
				System.out.println("TRY AGAIN.");
				i--;
			} else {
				wordList[i] = word;
			}
		}
		wordScramble start = new wordScramble();
		for (int i = 0; i < 4; i++) {
			start.determinePlacement(wordList[i]);
		}
		start.masterList(wordList);
		String[] n = start.randomLetters(wordList);
		start.makeArr(n);
	}
	
	public int masterList(String[] wordList) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < wordList[i].length(); j++) {
				count++;
			}
		}
		masterlist = new String[count];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < wordList[j].length(); i++) {
				masterlist[i] = wordList[j].substring(i, i + 1);
			}
		}
		return count;
	}

	public void makeArr (String[] array) {
		// two main lists: xylist and masterlist
		// fill in with alphabet list
		String[][] arr = new String[6][6];
		// take two numbers from xy
		// fill x
		for (int i = 0; i < count; i++)
	}

	public void determinePlacement(String word) {
		double decision = 2 * Math.random() + 1;
		decision = (int) decision;
		int poss_pos = 6 - word.length();
		int len = poss_pos + 1; 
		int[] poss_posArr = new int[len]; 
		for (int i = 0; i < len; i++) {
			poss_posArr[i] = i; 
		}
		double decisionx;
		double decisiony;
		if (decision == 1) {
			decisionx = len * Math.random(); 
			decisiony = 6 * Math.random();
			x_pos = poss_posArr[(int) decisionx];
			y_pos = (int) decisiony;
			xlist = new int[word.length()];
			ylist = new int[word.length()];
			xlist[0] = x_pos;
			ylist[0] = y_pos;
			for (int i = 1; i < word.length(); i++) {
				xlist[i] = xlist[i-1] + 1;
			}
			for (int i = 1; i < word.length(); i++) {
				ylist[i] = y_pos;
			}
			combinexy(word, xlist, ylist);
			//	for (int i = 0; i < word.length(); i++) {
			//		System.out.println(word + " : "+ xlist[i] + ", "+ ylist[i]);
			//	}

		} else if (decision == 2) {
			decisionx = 6 * Math.random(); // 0 1 2
			decisiony = len * Math.random();
			x_pos = (int) decisionx;
			y_pos = poss_posArr[(int) decisiony];  

			xlist = new int[word.length()];
			ylist = new int[word.length()];
			xlist[0] = x_pos;
			ylist[0] = y_pos;

			for (int i = 1; i < word.length(); i++) {
				ylist[i] = ylist[i-1] + 1;
			}
			for (int i = 1; i < word.length(); i++) {
				xlist[i] = x_pos;
			}
			combinexy(word, xlist, ylist);
			//	for (int i = 0; i < word.length(); i++) {
			//		System.out.println(word + " : "+ xlist[i] + ", "+ ylist[i]);
			//	}
		}
		// uh oh! what if the horizontal exceeds the x value array? --> i think this is ok

	}

	public int[] combinexy(String word, int[] xlist, int[] ylist) {
		xylist = new int[2 * word.length()];
		for (int i = 0; i < word.length(); i++) {
			xylist[2*i] = xlist[i];
			xylist[2*i + 1] = ylist[i];
		}
		// for (int i = 0; i < 2 * word.length(); i++) {
			//System.out.println(xylist[i]);
		//}
		return xylist;
	}

	public String[] randomLetters(String[] wordList) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < wordList[i].length(); j++) {
				count++;
			}
		}
		int remaining = 36 - count;
		String[] randomLetter = new String[remaining];
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "x", "z"};
		for (int i = 0; i < remaining; i++) {
			double letter = 26 * Math.random();
			randomLetter[i] = alphabet[(int) letter];
		}
		return randomLetter;

	}
	// make a two dimensional array 6 by 6 y
	// add words to it through user input y
	// add random letters
	// put it together
	// check for overlap

}
