package blackjack;

public class testclass {
	public static void main(String[] args) {
//		HumanBlackjackPlayer c = new HumanBlackjackPlayer();
//		BlackjackDealer a = new BlackjackDealer();
//		System.out.println(a.playBlackjack(c, 6));
		
		// testing class
//		PlayingCard.setRandom(false);
//		HumanBlackjackPlayer a = new HumanBlackjackPlayer();
//		BlackjackDealer b = new BlackjackDealer();
//		b.playBlackjack(a, 1);
		
		MySimpleStrategy e = new MySimpleStrategy();
		ComputerBlackjackPlayer f = new ComputerBlackjackPlayer(e);
		BlackjackDealer g = new BlackjackDealer();
		System.out.println(g.playBlackjack(f, 1000));		
		
		PlayingCard.setRandom(false);
		MySimpleStrategy a = new MySimpleStrategy();
		ComputerBlackjackPlayer b = new ComputerBlackjackPlayer(a);
		
		// prints true 
		System.out.println(b.hit(15, 11, true));
		
		// prints true
		System.out.println(b.hit(15, 11, false));
		
		// prints true
		System.out.println(b.hit(11, 10, false));
		
		// prints false
		System.out.println(b.hit(17, 7, false));
		
		// prints true
		System.out.println(b.hit(16, 6, false));
		
		// prints true
		System.out.println(b.hit(17, 2, true));
		
		
	}
	
}
