package blackjack;

public class MySimpleStrategy extends BlackjackStrategy{
	public boolean hit(int handValue, int dealerHandValue, boolean soft) {
		if ((dealerHandValue == 11 && handValue < 21) || (handValue < 17) || (soft)) {
			return true;
		} else {
			return false;
		}
	}
}
