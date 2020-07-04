package blackjack;
import java.util.Scanner;

public class HumanBlackjackPlayer extends BlackjackPlayer{

	public static void main(String[] args) {
//		// dealerHand
//		BlackjackHand a = new BlackjackHand(true);
//		// playerHand
//		BlackjackHand b = new BlackjackHand(false);
//		HumanBlackjackPlayer c = new HumanBlackjackPlayer();
//		c.hit(a,b); // works
//		c.dealerHit(a); // works
//		c.playerBusts(b);
//		c.hit(a, b);
//		c.dealerBusts(a, b);
//		c.dealerWins(a, b);
//		c.playerWins(a, b);
//		c.playerTies(a, b);
	}

	public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand) {
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Player's hand: ");
		playerHand.print();
		boolean allow = true;
		while(allow) {
			System.out.println("Do you want to hit?");
			String message = sc.nextLine();
			if(message.equals("yes") || message.equals("y") ||
					message.equals("Yes")) {
				allow = false;
				end = true;
			} else if (message.equals("no") || message.equals("n") ||
					message.equals("No")) {
				allow = false;
				end = false;
			} else {
				System.out.println("I'm sorry. I didn't understand that.");
				allow = true;
			}
		}
		return end;
	}

	public void dealerHit(BlackjackHand dealerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Dealer hit");
		System.out.println(" ");
	}

	public void playerBusts(BlackjackHand playerHand) {
		System.out.println("Player's hand: ");
		playerHand.print();
		System.out.println("Player busts");
		System.out.println("---------------------------------");
	}

	public void playerTies(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Player's hand: ");
		playerHand.print();
		System.out.println("Player ties");
		System.out.println("---------------------------------");
	}

	public void playerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Player's hand: ");
		playerHand.print();
		System.out.println("Player wins");
		System.out.println("---------------------------------");
	}

	public void dealerBusts(BlackjackHand dealerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Dealer busts");
		System.out.println("---------------------------------");
	}

	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.print();
		System.out.println("Player's hand: ");
		playerHand.print();
		System.out.println("Dealer wins");
		System.out.println("---------------------------------");
	}
}
