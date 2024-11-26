package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;

public class VScoreAndTurn extends Label implements Observer {
	private String turn;
	private String winner;
	public VScoreAndTurn() {
		// TODO Auto-generated constructor stub
		this.setText("Black: 0 | White: 0 | Black's turn");
		this.setFont(new Font(15));
		this.setPadding(new Insets(0, 0.0, 5.0, 10.0));
		
	}

	@Override
	public void update(Observable o) {
		Othello othello = (Othello) o;
//		System.out.println(othello);
//		String turn = "";
//		String winner = "";
		if (othello.isGameOver() == true) {
			winner = (othello.getWinner() == 'X') ? "Black" : "White";
			this.setText("Black: " + othello.getCount(OthelloBoard.P1) + " | White: " + othello.getCount(OthelloBoard.P2) + " | " + winner + " won !!!");
		}else {
			if(othello.getWhosTurn() == OthelloBoard.P1) {
				turn = "Black's turn";
			}else if(othello.getWhosTurn() == OthelloBoard.P2) {
				turn = "White's turn";
			}
			this.setText("Black: " + othello.getCount(OthelloBoard.P1) + " | White: " + othello.getCount(OthelloBoard.P2) + " | " + turn);
		}
		
		
	}

}
