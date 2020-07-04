import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

// link to rules: https://endlessgames.com/wp-content/uploads/Mancala_Instructions.pdf

public class game {
	private int[] board = {0, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4}; 
							// user 			// computer
	
	public boolean not_my_mancala(int current_position, int player) {
		if (player == 0 && current_position == 0) {
			return true;
		} else if (player == 1 & current_position == 7) {
			return true;
		} return false;
	}
	
	public int move(int position, int player) {
			int points = board[position];
			board[position] = 0;
			int index = (position + 1) % 14;
			while(points > 0) {
				// rule 3: If you run into your opponent's Mancala, you skip it
				if (not_my_mancala(index, player)) {
					System.out.println("index:" + index + " player: " + player);
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
			int last_position = index - 1;
			int opp_side = 14 - last_position;
			System.out.println("opp_side: " + opp_side);
			if (player == 0) {
				if (last_position >= 1 && last_position <= 6 && board[last_position] == 0) {
					board[7] = board[7] + board[opp_side];
					board[opp_side] = 0;
				}
			} else if (player == 1) {
				if (last_position >= 8 && last_position <= 13 && board[last_position] == 0) { // on your side
					board[0] = board[0] + board[opp_side]; // add opposite side to your mancala
					board[opp_side] = 0; // set opposite side equal to zero
				}
			}
			System.out.println("last_position: " + last_position);
			return last_position;
	}		
	
	// rule 4: If the last piece you drop is in your Mancala, you take another turn
	public boolean anotherTurn(int again, int player) {
		if (player == 0 && again == 7) {
			return true;
		} else if (player == 1 && again == 0){
			return true;
		} return false;
	}
	
	public void printBoard() {
		System.out.println("   13 12 11 10  9  8");
		System.out.println("   -----------------");
		System.out.print("    ");
		for (int i = 13; i > 7; i--) {
			System.out.print(board[i] + "  ");
		}
		System.out.println("\n" + "|" + board[0] + "|"+ "                  " + "|" + board[7] + "|");
		System.out.print("    ");
		for (int i = 1; i < 7; i++) {
			System.out.print(board[i] + "  ");
		}
		System.out.println("    ");
		System.out.println("   -----------------");
		System.out.println("    1  2  3  4  5  6");
		
	}
	
	public boolean isEmpty(int position) {
		if (board[position] == 0) {
			return true;
		} return false;
	}
	
	public static void main(String[] args) {
		game a = new game();
		int player = 0;
		while(a.checkWin() == false) {
			boolean flag = false;
			Scanner sc = new Scanner(System.in);
			while(flag == false) {
				a.printBoard();
				if (player == 0) {
					System.out.println("\nPlayer 0: pick a position from 1 - 6");
					// System.out.println("-----------------------------------------------");
				} else {
					System.out.println("\nPlayer 1: pick a position from 8 - 13");
					// System.out.println("-----------------------------------------------");
				}
				int ans = sc.nextInt();
				if (player == 0 && ans >= 1 && ans <= 6 && !(a.isEmpty(ans))){
					flag = true;
					int again = a.move(ans, player);
					// rule 4
					if (a.anotherTurn(again, player) && a.checkWin() == false) {
						System.out.println("You get another turn!");
						System.out.println(" ");
						flag = false;
					}
				} else if (player == 1 && ans >= 8 & ans <= 13 && !(a.isEmpty(ans))){
					flag = true;
					int again = a.move(ans, player);
					// rule 4
					if (a.anotherTurn(again, player) && a.checkWin() == false) {
						System.out.println("You get another turn!");
						System.out.println(" ");
						flag = false;
					}
				} else if (a.isEmpty(ans)){
					System.out.println("Choose another box. The one you chose is empty.");
				} else {
					System.out.println("not in range");
				}
			}
			player = (player + 1) % 2;
		} a.gameOver();
		
	}
	
	// rule 9: Count all the pieces in each Mancala
	// The winner is the player with the most pieces
	public void gameOver() {
		if (board[0] > board[7]) {
			System.out.println("Player 1 won! " + board[0] + " vs. " + board[7]);
		} else if (board[0] < board[7]) {
			System.out.println("Player 0 won! " + board[7] + " vs. " + board[0]);
		}
	}
	
	// rule 7: The game ends when all 6 pockets on one side of the Mancala board
	// are empty
	public boolean checkWin() {
		int player0_count = 0;
		int player1_count = 0;
		for (int i = 1; i < 7; i++) {
			if (board[i] == 0) {
				player0_count++;
			}
		} for (int i = 8; i < 14; i++) {
			if (board[i] == 0) {
				player1_count++;
			}
		}
		if (player0_count == 6 || player1_count == 6) {
			return true;
		} else {
			return false;
		}
	}
}

// graphics.setColor(Color.black);
//graphics.setFont(new Font("Times", Font.BOLD, 26));
//graphics.drawString("Choose a category to learn more about me!", 60, 60);
//// Picture p = new Picture("game/board.png");
//// graphics.drawImage(p.getBufferedImage(), 0, 0, this);
