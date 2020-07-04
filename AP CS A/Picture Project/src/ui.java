import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class ui extends FlexiblePictureExplorer implements ImageObserver {
	int[] board = {0, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4};
	boolean player0 = true;  // True of player 0 is active
	int player = 0;
	boolean main = true;

	public ui() {
		super(new Picture(700,800));
		instructions();
	}

	public void instructions() {
		Picture start = new Picture("game//instructions.png");
		setImage(start);
	}

	public int check(int x, int y) {
		if (player == 1 && x <= 168  && y <= 298 && x >= 81 && y >= 156) {
			return 0; // mancala for player 1
		} else if (player == 0 && x >= 180 && y >= 233 && x <= 238 && y <= 298) {
			return 1;
		} else if (player == 0 && x >= 250 && y >= 232 && x <= 307 && y <= 297) {
			return 2;
		} else if (player == 0 && x >= 319 && y >= 233 && x <= 378 && y <= 297) {
			return 3;
		} else if (player == 0 && x >= 390 && y >= 233 && x <= 449 && y <= 297) {
			return 4;
		} else if (player == 0 && x >= 460 && y >= 231 && x <= 518 && y <= 297) {
			return 5;
		} else if (player == 0 && x >= 530 && y >= 233 && x <= 589 && y <= 297) {
			return 6;
		} else if (player == 0 && x <= 680 && y <= 297 && x >= 600 && y >= 157) {
			return 7; // mancala for player 0
		} else if (player == 1 && x >= 529 && y >= 157 && x <= 588 && y <= 222) {
			return 8;
		} else if (player == 1 && x >= 459 && y >= 157 && x <= 517 && y <= 222) {
			return 9;
		} else if (player == 1 && x >= 390 && y >= 156 && x <= 448 && y <= 221) {
			return 10;
		} else if (player == 1 && x >= 319 && y >= 157 && x <= 378 && y <= 221) {
			return 11;
		} else if (player == 1 && x >= 249 && y >= 157 && x <= 307 && y <= 223) {
			return 12;
		} else if (player == 1 && x >= 179 && y >= 157 && x <= 238 && y <= 221) {
			return 13;
		} return -1;
	}

	public static void main(String[] args) {
		// randtest();
		ui a = new ui();
		game b = new game();
	}

	public static void randtest() {
		int x = 10;
		while(x > 0) {
			System.out.println(8 + (int)(Math.random() * 6));
			x--;
		}
	}
	
	public boolean anotherTurn(int again, int player) {
		if (player == 0 && again == 7) {
			return true;
		} else if (player == 1 && again == 0){
			return true;
		} return false;
	}

	public void updateBoard(String message) {
		Picture pic = new Picture("game//board.png");
		Graphics2D graphics = pic.createGraphics();
		graphics.setColor(Color.black);
		graphics.setFont(new Font("Times", Font.BOLD, 26));

		graphics.drawString(message, 60, 60);

		graphics.drawString("" + board[0], 115, 235);
		graphics.drawString("" + board[7], 635, 235);
		int x1 = 200;
		for (int i = 1; i <= 6; i++) {
			graphics.drawString("" + board[i], x1, 275);
			x1 = x1 + 70;
		}
		int x2 = 200;
		for (int i = 13; i >= 8; i--) {
			graphics.drawString("" + board[i], x2, 200);
			x2 = x2 + 70;
		}

		graphics.drawString("Computer Player", 200, 135);
		graphics.drawString("Player 0", 200, 335);

		setImage(pic);


	}

	public boolean not_my_mancala(int current_position, int player) {
		if (player == 0 && current_position == 0) {
			return true;
		} else if (player == 1 & current_position == 7) {
			return true;
		} return false;
	}

	public boolean isEmpty(int position) {
		// System.out.println("isEmpty is called");
		if (board[position] == 0) {
			return true;
		} return false;
	}

	public boolean checkWin() {
		int player0_count = 0;
		int player1_count = 0;
		for (int i = 1; i < 7; i++) {
			if (board[i] == 0) {
				player0_count++;
			}
		}
		for (int i = 8; i < 14; i++) {
			if (board[i] == 0) {
				player1_count++;
			}
		}
		return player0_count == 6 || player1_count == 6;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}

	public void endGame() {
		int player0 = board[7];
		int player1 = board[0];
		String fate = "";
		if (player0 > player1) {
			fate = "Player 0 wins! The score is " + player0 + " to " + player1 + ".";
		} else if (player0 < player1) {
			fate = "Computer Player wins! The score is " + player1 + " to " + player0 + ".";
		} else {
			fate = "You tied. The score is " + player0 + " to " + player1 + ".";
		}
		Picture p = new Picture("game//win.png");
		Graphics2D graphics = p.createGraphics();
		graphics.setColor(Color.black);
		graphics.setFont(new Font("Times", Font.BOLD, 26));
		graphics.drawString(fate, 60, 60);
		setImage(p);
	}

	public boolean outOfBounds(int position) {
		if (position == 0 || position == 7 || position == -1) {
			return true;
		}
		return false;
	}

	public void switchTurns() {
		System.out.println("switching turns");
		String message;
		player = (player + 1) % 2;
		if (player0) {
			System.out.println("cp's turn");
			player0 = false;
			updateBoard("Computer Player's turn");
			int ans = cp();
			message = "Computer Player chooses " + ans;
			updateBoard(message);
			
			updateBoard("Player 0, your move?");
		} else {	
			System.out.println("my turn");
			updateBoard("Player 0, your move?");
			player0 = true;
		}
		System.out.println("done switch");
	}
	
	public int cp(){	
		// int position = 0;
//		do {
//			// select position in [8, 13]
//			position = 8 + (int)(Math.random() * 6);	
//		}
//		while(board[position] != 0);
		
		int position = 0;		
		boolean flag = true;
		while(flag) {
			position = 8 + (int)(Math.random() * 6);
			if (board[position] == 0) {
				position = 8 + (int)(Math.random() * 6);
		} else {
			flag = false;
		}	
		}
	
		
		System.out.println("CP position: " + position);
		int points = board[position];		
		board[position] = 0;
		int index = (position + 1) % 14;
		while(points > 0) {
			if (not_my_mancala(index, player)) {
				index = (index + 1) % 14;
			} else {
				board[index] = board[index] + 1;
				index = (index + 1) % 14;
				points--;
			}
		} 
		int last_position = (14 + index - 1) % 14;
		int opp_side = 14 - last_position;

		if (player == 1 && !(this.isEmpty(last_position)) && this.anotherTurn(last_position, player) && this.checkWin() == false) {
			updateBoard("Computer Player gets another turn.");
			cp();
		} else {
			System.out.println("checking for special rule");
			if (player == 1 && last_position >= 8 && last_position <= 13 && board[last_position] == 1) { 
				board[0] = board[0] + board[opp_side]; 
				board[opp_side] = 0; 
			}
			switchTurns();
			if (checkWin()) {
				endGame();
			}
		}
		return position;
	}
	
	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		if (main == true && pix.getX() > 0 && pix.getY() > 0 && pix.getX() < 600 && pix.getY() < 700) {
			updateBoard("Player 0, your move?");
			main = false;
		} else {
			System.out.println("back to the start");
			int position = 0;
			if (player == 0) {
				updateBoard("Player 0, your move?");
				position = check(pix.getX(), pix.getY());
				if (outOfBounds(position)) {
					updateBoard("You can't click that.");
				} else {
					updateBoard("Player 0, your move?");
				}
			} 
			int points = board[position];		
			board[position] = 0;
			int index = (position + 1) % 14;
			while(points > 0) {
				// rule 3: If you run into your opponent's Mancala, you skip it
				if (not_my_mancala(index, player)) {
					index = (index + 1) % 14;
				} else {
					// rule 3: If you run into your own Mancala, add 1
					// rule 2: Moving counter-clockwise, the player deposits one of
					// the stones until the stones run out
					board[index] = board[index] + 1;
					index = (index + 1) % 14;
					points--;
					// rule 6: Always place all captured pieces in your Mancala
				}
			} 

			int last_position = (14 + index - 1) % 14;
			int opp_side = 14 - last_position;

			if (player == 0 && !(this.isEmpty(last_position)) && this.anotherTurn(last_position, player) && this.checkWin() == false) {
				updateBoard("Player " + player + ", you get another turn!");
			} else if (player == 1 && !(this.isEmpty(last_position)) && this.anotherTurn(last_position, player) && this.checkWin() == false) {
				updateBoard("Computer Player gets another turn.");
			} else {
				System.out.println("checking for special rule");
				if (player == 0 && last_position >= 1 && last_position <= 6 && board[last_position] == 1) {
					board[7] = board[7] + board[opp_side];
					board[opp_side] = 0;
				} else if (player == 1 && last_position >= 8 && last_position <= 13 && board[last_position] == 1) { 
					board[0] = board[0] + board[opp_side]; 
					board[opp_side] = 0; 
				}
				updateBoard("Player 0, your move?");
				switchTurns();
				if (checkWin()) {
					endGame();
				}
			}

		}
	}

}

/*
	int position = 0;		
boolean flag = true;
while(flag) {
	position = 8 + (int)(Math.random() * 6);
	if (board[position] == 0) {
		position = 8 + (int)(Math.random() * 6);
	} else {
		flag = false;
	}	
}
*/

