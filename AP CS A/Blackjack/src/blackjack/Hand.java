package blackjack;

import java.util.ArrayList;

public class Hand {
	private ArrayList<PlayingCard> a;
	Hand(int initialCards) {
		a = new ArrayList<PlayingCard>(initialCards);
		for (int i = 0; i < initialCards; i++) {
			PlayingCard card = new PlayingCard();
			addCard(card);
		}
	}

	public static void main(String[] args) {
//		Hand a1 = new Hand(0);
//		System.out.println(a1.numberOfCards());
//		Hand a2 = new Hand(1);
//		System.out.println(a2.numberOfCards());
//		Hand a3 = new Hand(2);
//		System.out.println(a3.numberOfCards());
//		
//		Hand b1 = new Hand(1);
//		System.out.println(b1.nthCard(1));
//		Hand b2 = new Hand(2);
//		System.out.println(b2.nthCard(1));
//		System.out.println(b2.nthCard(2));
//		Hand b3 = new Hand(3);
//		System.out.println(b3.nthCard(1));
//		System.out.println(b3.nthCard(2));
//		System.out.println(b3.nthCard(3));
//		
//		Hand c1 = new Hand(0);
//		c1.print();
//		Hand c2 = new Hand(1);
//		c2.print();
//		Hand c3 = new Hand(2);
//		c3.print();
	}

	public int numberOfCards() { 
		return a.size();
	}

	public PlayingCard nthCard(int N) { 
		return a.get(N - 1);
	}

	public void print() { 
		for (PlayingCard obj: a) {
			System.out.println(obj.toString());
		}
	}

	public void addCard() {
		PlayingCard a = new PlayingCard();
		addCard(a);
	}

	public void addCard(PlayingCard obj) {
		a.add(obj);
	}
}
