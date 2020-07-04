package blackjack;

public class BlackjackHand extends Hand{
	private int handValue;
	private boolean soft;
	BlackjackHand(boolean dealer) {
		super(0);
		addCard();
		if (dealer == false) {
			addCard();
		}
	}

	BlackjackHand() {
		super(0);
		computeValue();
	}

	public static void main(String args[]) {
//		// a case with each face value 
//		BlackjackHand face11 = new BlackjackHand();
//		PlayingCard a11 = new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.JACK);
//		face11.addCard(a11);
//		face11.print();
//		System.out.println(face11.handValue()); // 10
//		System.out.println("soft is " + face11.soft());
//
//		BlackjackHand face12 = new BlackjackHand();
//		PlayingCard a12 = new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.QUEEN);
//		face12.addCard(a12);
//		face12.print();
//		System.out.println(face12.handValue()); // 10
//		System.out.println("soft is " + face12.soft());
//
//		BlackjackHand face13 = new BlackjackHand();
//		PlayingCard a13 = new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.KING);
//		face13.addCard(a13);
//		face13.print();
//		System.out.println(face13.handValue()); // 10
//		System.out.println("soft is " + face13.soft());
//
//		// a case with two more aces 
//		BlackjackHand be = new BlackjackHand();
//		PlayingCard a = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
//		PlayingCard b = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
//		be.addCard(a);
//		be.addCard(b);
//		be.print();
//		System.out.println(be.handValue());
//		System.out.println("soft is " + be.soft());
//
//		// over 11 will give the hand a value under 21 (18)
//		BlackjackHand bd = new BlackjackHand();
//		PlayingCard e = new PlayingCard(PlayingCard.HEARTS, 7);
//		PlayingCard g = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
//		bd.addCard(e);
//		bd.addCard(g);
//		bd.print();
//		System.out.println(bd.handValue());
//		System.out.println("soft is " + bd.soft());
//
//
//		// over 11 will give the hand a value over 21 --> works (13)
//		BlackjackHand bc = new BlackjackHand();
//		PlayingCard h = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
//		PlayingCard i = new PlayingCard(PlayingCard.HEARTS, PlayingCard.KING);
//		PlayingCard j = new PlayingCard(PlayingCard.HEARTS, 2);
//		bc.addCard(h);
//		bc.addCard(i);
//		bc.addCard(j);
//		bc.print();
//		System.out.println(bc.handValue());
//		System.out.println("soft is " + bc.soft());
//
//
//		// a case with more than 5 cards (42)
//		BlackjackHand bb = new BlackjackHand();
//		PlayingCard k = new PlayingCard(PlayingCard.CLUBS, 7);
//		PlayingCard l = new PlayingCard(PlayingCard.DIAMONDS, 5);
//		PlayingCard m = new PlayingCard(PlayingCard.HEARTS, PlayingCard.QUEEN);
//		PlayingCard n = new PlayingCard(PlayingCard.SPADES, 9);
//		PlayingCard o = new PlayingCard(PlayingCard.DIAMONDS, 8);
//		PlayingCard p = new PlayingCard(PlayingCard.DIAMONDS, 3);
//		bb.addCard(k);
//		bb.addCard(l);
//		bb.addCard(m);
//		bb.addCard(n);
//		bb.addCard(o);
//		bb.addCard(p);
//		bb.print();
//		System.out.println(bb.handValue());
//		System.out.println("soft is " + bb.soft());
//
//
//		// a case with blackjack (an ace and face card only) 
//		BlackjackHand bf = new BlackjackHand();
//		PlayingCard abf = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.ACE);
//		PlayingCard bbf = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.QUEEN);
//		bf.addCard(abf);
//		bf.addCard(bbf);
//		bf.print();
//		System.out.println(bf.handValue());
//		System.out.println("soft is " + bf.soft());
//
//		// a case where the first card is an ace
//		// hand has a hard value between 12 and 20 --> 17
//		BlackjackHand bg = new BlackjackHand();
//		PlayingCard abg = new PlayingCard(PlayingCard.HEARTS, PlayingCard.ACE);
//		PlayingCard bbg = new PlayingCard(PlayingCard.HEARTS, 7);
//		PlayingCard cbg = new PlayingCard(PlayingCard.HEARTS, 9);
//		bg.addCard(abg);
//		bg.addCard(bbg);
//		bg.addCard(cbg);
//		bg.print();
//		System.out.println(bg.handValue());
//		System.out.println("soft is " + bg.soft());
//
//		// a case where the first card is an ace
//		// hand has a soft value between 12 and 20 --> 19
//		BlackjackHand bh = new BlackjackHand();
//		PlayingCard abh = new PlayingCard(PlayingCard.DIAMONDS, PlayingCard.ACE);
//		PlayingCard bbh = new PlayingCard(PlayingCard.DIAMONDS, 8);
//		bh.addCard(abh);
//		bh.addCard(bbh);
//		bh.print();
//		System.out.println(bh.handValue());
//		System.out.println("soft is " + bh.soft());
//
//		// a case where the last card is an ace
//		// hand has a hard value between 12 and 20 --> 14
//		BlackjackHand bi = new BlackjackHand();
//		PlayingCard abi = new PlayingCard(PlayingCard.SPADES, 9);
//		PlayingCard bbi = new PlayingCard(PlayingCard.SPADES, 4);
//		PlayingCard cbi =  new PlayingCard(PlayingCard.SPADES, PlayingCard.ACE);
//		bi.addCard(abi);
//		bi.addCard(bbi);
//		bi.addCard(cbi);
//		bi.print();
//		System.out.println(bi.handValue());
//		System.out.println("soft is " + bi.soft());
//
//		// a case where the last card is an ace
//		// hand has a soft value between 12 and 20 --> 15
//		BlackjackHand bj = new BlackjackHand();
//		PlayingCard abj = new PlayingCard(PlayingCard.CLUBS, 4);
//		PlayingCard bbj = new PlayingCard(PlayingCard.CLUBS, PlayingCard.ACE);
//		bj.addCard(abj);
//		bj.addCard(bbj);
//		bj.print();
//		System.out.println(bj.handValue());
//		System.out.println("soft is " + bj.soft());
//
//		// a case with two small cards (less than 10
//		// with no aces
//		BlackjackHand bl = new BlackjackHand();
//		PlayingCard abl = new PlayingCard(PlayingCard.HEARTS, 2);
//		PlayingCard bbl = new PlayingCard(PlayingCard.HEARTS, 2);
//		bl.addCard(abl);
//		bl.addCard(bbl);
//		bl.print();
//		System.out.println(bl.handValue());
//		System.out.println("soft is " + bl.soft());
//
//		// a case where the first card is an ace
//		// the second card is a face card
//		// third card is a 2 --> 13
//		BlackjackHand bm = new BlackjackHand();
//		PlayingCard abm = new PlayingCard(PlayingCard.SPADES, PlayingCard.ACE);
//		PlayingCard bbm = new PlayingCard(PlayingCard.SPADES, PlayingCard.KING);
//		PlayingCard cbm = new PlayingCard(PlayingCard.SPADES, 2);
//		bm.addCard(abm);
//		bm.addCard(bbm);
//		bm.addCard(cbm);
//		bm.print();
//		System.out.println(bm.handValue());
//		System.out.println("soft is " + bm.soft());
		
//		BlackjackHand a = new BlackjackHand();
//		PlayingCard ba = new PlayingCard(1, 1);
//		PlayingCard bb = new PlayingCard(1, 10);
//		PlayingCard bc = new PlayingCard(1, 10);
//		a.addCard(ba);
//		a.addCard(bb);
//		System.out.println(a.handValue());
//		a.addCard(bc);
//		System.out.println(a.handValue());
//		
		
	}

	private void computeValue() {
		handValue = 0;
		boolean aces = false;
		soft = false;
		for (int i = 1; i <= numberOfCards(); i++) {
			if ((this.nthCard(i).getValue() == 11) || (this.nthCard(i).getValue() == 12) || 
			(this.nthCard(i).getValue() == 13)) {
				handValue = handValue + 10;
			} else {
				handValue = handValue + this.nthCard(i).getValue();
			}
			if (this.nthCard(i).getValue() == 1) {
				aces = true;
			}
		}
		if (aces && (handValue < 12)) {
			handValue = handValue + 10;
			soft = true;
		}
	}

	public int handValue() {
		return handValue;
	}

	public boolean soft() {
		return soft;
	}

	public void addCard(PlayingCard obj) {
		super.addCard(obj);
		computeValue();
	}
}
