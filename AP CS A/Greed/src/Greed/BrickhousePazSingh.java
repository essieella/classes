package Greed;
public class BrickhousePazSingh extends GreedStrategy {

	@Override
	public int choose(GreedOption[] options, int[] dice, int bank) {
		if((dice.length > 2)||(options.length > 2)) { 
			return 0;
		} if (bank < 600) {
			return 2;
		}
		return 1;
	}



		
//		boolean pass = false;
//		for (int i = 0; i < dice.length; i++) {
//			if (dice[i] == 1 || dice[i] == 5) {
//				pass = true;
//			}
//		}
//		
//			if(dice.length > 2 && pass) { 
//				return GreedOption.ENDTURN;
//			} return GreedOption.ROLLAGAIN;
//				
//			 if((options.length > 2)) {
//				if(dice.length > 3) { 
//					return 0;
//				}
//				 return 0;
//			 }
//			return 1;
		

	
	
	@Override
	public String playerName() {
		// TODO Auto-generated method stub
		return "Random Player";
	}

	@Override
	public String author() {
		// TODO Auto-generated method stub
		return "Random";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
