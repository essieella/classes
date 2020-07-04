package blackjack;

public class ComputerBlackjackPlayer extends BlackjackPlayer{
	private BlackjackStrategy strategy;
	ComputerBlackjackPlayer(BlackjackStrategy theStrategy) {
		strategy = theStrategy;
	}

	public boolean hit(int handValue, int dealerHandValue, boolean soft) {
		return strategy.hit(handValue, dealerHandValue, soft);
	}

	public void dealerHit(BlackjackHand dealerHand) {

	}

	public void playerBusts(BlackjackHand playerHand) {

	}

	public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand) {

	}

	public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand) {

	}

	public void dealerBusts(BlackjackHand dealerHand) {

	}

	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {

	}
	
}
