package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.scene.control.Label;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;

public class VScoreAndTurn extends Label implements Observer {
	public VScoreAndTurn() {
		// TODO Auto-generated constructor stub
		this.setText("Black: 0 | White: 0 | Black's turn");
		
	}

	@Override
	public void update(Observable o) {
		Othello othello = (Othello) o;
		String turn = "";
		if(othello.getWhosTurn() == OthelloBoard.P1) {
			turn = "Black's turn";
		}else if(othello.getWhosTurn() == OthelloBoard.P2) {
			turn = "White's turn";
		}
		this.setText("Black: " + othello.getCount(OthelloBoard.P1) + "| White: " + othello.getCount(OthelloBoard.P2) + "| " + turn);
		
	}

}
