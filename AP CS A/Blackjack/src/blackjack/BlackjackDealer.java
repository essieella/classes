package blackjack;

public class BlackjackDealer {
	public double playBlackjack(BlackjackPlayer player, int numGames) {
		double score = 0;
		for (int i = 0; i < numGames; i++) {
			BlackjackHand dealer = new BlackjackHand(true);
			BlackjackHand user = new BlackjackHand(false);
			while ((user.handValue() < 22 && (player.hit(dealer, user) == true))) {
				user.addCard();
			}
			if (user.handValue() >= 22) {
				player.playerBusts(user); 
			} else {
				int user_value = user.handValue();
				while (dealer.handValue() < 17) {
					dealer.addCard();
					player.dealerHit(dealer);
				}
				if (dealer.handValue() >= 22) {
					player.dealerBusts(dealer);
					score = score + 1;
				} else if (user_value == dealer.handValue()) {
					player.playerTies(dealer, user);
					score = score + 0.5;
				} else if (user_value < dealer.handValue()){
					player.dealerWins(dealer, user);
				} else {
					player.playerWins(dealer, user);
					score = score + 1;
				}
			}
		}
		return score/numGames;
	}
}
