package blackjack;

public class testPlayingCard {
	public static void main(String[] args) {
		PlayingCard A = new PlayingCard();
		System.out.println(A.toString());
		PlayingCard B = new PlayingCard();
		System.out.println(B.toString());
		PlayingCard.setRandom(false);
		PlayingCard C = new PlayingCard();
		System.out.println(C.getSuit());
		System.out.println(C.getValue());
		PlayingCard D = new PlayingCard();
		System.out.println(D.getSuit());
		System.out.println(D.getValue());
		PlayingCard.setRandom(true);
		PlayingCard E = new PlayingCard();
		System.out.println(E.toString());
		PlayingCard F = new PlayingCard();
		System.out.println(F.toString());
		PlayingCard c1 = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
		System.out.println(c1.toString());
		PlayingCard c2 = new PlayingCard(PlayingCard.SPADES, 2);
		System.out.println(c2.toString());
		PlayingCard c3 = new PlayingCard(PlayingCard.CLUBS, 3);
		System.out.println(c3.toString());
		PlayingCard c4 = new PlayingCard(PlayingCard.DIAMONDS, 4);
		System.out.println(c4.toString());
		PlayingCard c5 = new PlayingCard(PlayingCard.DIAMONDS, 5);
		System.out.println(c5.toString());
		PlayingCard c6 = new PlayingCard(PlayingCard.DIAMONDS, 6);
		System.out.println(c6.toString());
		PlayingCard c7 = new PlayingCard(PlayingCard.DIAMONDS, 7);
		System.out.println(c7.toString());
		PlayingCard c8 = new PlayingCard(PlayingCard.DIAMONDS, 8);
		System.out.println(c8.toString());
		PlayingCard c9 = new PlayingCard(PlayingCard.DIAMONDS, 9);
		System.out.println(c9.toString());
		PlayingCard c10 = new PlayingCard(PlayingCard.DIAMONDS, 10);
		System.out.println(c10.toString());
		PlayingCard c11 = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.JACK);
		System.out.println(c11.toString());
		PlayingCard c12 = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.QUEEN);
		System.out.println(c12.toString());
		PlayingCard c13 = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.KING);
		System.out.println(c13.toString());
	}
}





