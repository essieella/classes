package blackjack;
import java.util.Scanner;

public class PlayingCard {
	private int suit;
	private int value;
	static public final int ACE = 1;
	static public final int KING = 13;
	static public final int QUEEN = 12;
	static public final int JACK = 11;
	static int HEARTS = 1;
	static int SPADES = 2;
	static int CLUBS = 3;
	static int DIAMONDS = 4;
	private static boolean random = true;

	PlayingCard(int suit_num, int value_num) {
		suit = suit_num;
		value = value_num;
	}

	PlayingCard() {
		Scanner sc = new Scanner(System.in);
		if (random == true) {
			suit = (int) (4*Math.random() + 1);
			value = (int) (13*Math.random() + 1);
		} else {
			boolean allow_suit = true;
			while(allow_suit) {
				System.out.println("Could you give me a suit value?");
				String suit_message = sc.nextLine();
				suit = Integer.parseInt(suit_message);
				if ((suit > 0) && (suit < 5)) {
					allow_suit = false;
				}
			}

			boolean allow_value = true;
			while(allow_value) {
				System.out.println("Could you give me a face value?");
				String value_message = sc.nextLine();
				value = Integer.parseInt(value_message);
				if ((value > 0) && (value < 14)) {
					allow_value = false;
				}
			}
		}
	}

	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		String ans1 = "";
		String[] suit_arr = {"Hearts", "Spades", "Clubs", "Diamonds"};
		for (int i = 0; i < suit_arr.length - 1; i++) {
			ans1 = suit_arr[suit - 1];
		}
		String ans2 = "";
		String[] value_arr = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack","Queen", "King"};
		for (int i = 0; i < value_arr.length - 1; i++) {
			ans2 = value_arr[value - 1];
		}
		return ans2 + " of " + ans1;
	}

	public static void setRandom(boolean item) {
		if (item == false) {
			random = false;
		} else {
			random = true;
		}
	}
}


