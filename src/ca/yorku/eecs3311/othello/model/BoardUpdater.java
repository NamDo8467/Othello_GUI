package ca.yorku.eecs3311.othello.model;

import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BoardUpdater implements Observer {

	@Override
	public void update(Observable o) {
		// TODO Auto-generated method stub
		Othello othello = (Othello) o;
		
		char [][] boardArray = othello.getBoardArray();
		
		GridPane gridBoard = othello.getBoard().gridBoard;
		
		// Update the GUI based on the board string array	
        for (int r = 0; r < boardArray.length; r++) {
			for(int c = 0; c < boardArray[0].length; c++) {
				Color updatedColor = Color.RED;
				if (boardArray[r][c] == OthelloBoard.P1) {
					updatedColor = Color.BLACK;
					Circle updatedToken = new Circle(70 / 2 - 5);

					updatedToken.setFill(updatedColor);
			        gridBoard.add(updatedToken, c, r);
			        othello.addTokenToTokenList(updatedToken);
			        
			     // Center the piece in the cell
			        GridPane.setHalignment(updatedToken, HPos.CENTER);
			        GridPane.setValignment(updatedToken, VPos.CENTER);
			        
					
				}else if(boardArray[r][c] == OthelloBoard.P2){
					updatedColor = Color.WHITE;
					Circle updatedToken = new Circle(70 / 2 - 5);
					updatedToken.setFill(updatedColor);
			        gridBoard.add(updatedToken, c, r);
			        othello.addTokenToTokenList(updatedToken);
			        
			     // Center the piece in the cell
			        GridPane.setHalignment(updatedToken, HPos.CENTER);
			        GridPane.setValignment(updatedToken, VPos.CENTER);
				}

			}
		}
        
	}
	
}
