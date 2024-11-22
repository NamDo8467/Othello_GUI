package ca.yorku.eecs3311.othello.model;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public abstract class OthelloController {

	protected Othello othello;
//	protected char whosTurn;
	Player player1, player2;
	
	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with a user at the console.
	 */
	public Stage stage;
	public OthelloController(Stage stage) {
		this.othello = new Othello();
		this.stage = stage;
//		this.whosTurn = this.othello.getWhosTurn();
//		this.othello.setGameGrid(stage);
	}
	
	 

	public void play() {
		this.othello.setGameGrid(this.stage);
		ArrayList<Rectangle> cells = this.othello.getCells();
		GridPane gridBoard = this.othello.getBoard().gridBoard;

		for(Rectangle cell:cells) {
			
			cell.setOnMouseClicked((MouseEvent event) -> {
				int row = GridPane.getRowIndex(cell);
				int col = GridPane.getColumnIndex(cell);
				this.handleMove(row, col, gridBoard);
			});
		}
		
		
//		if(whosTurn==OthelloBoard.P1)move = player1.getMove();
//		if(whosTurn==OthelloBoard.P2)move = player2.getMove();
//		this.othello.setGameGrid(stage);
//		while (!othello.isGameOver()) {
//			this.report();
//			
//			Move move=null;
//			char whosTurn = othello.getWhosTurn();
//			
//			if(whosTurn==OthelloBoard.P1)move = player1.getMove();
//			if(whosTurn==OthelloBoard.P2)move = player2.getMove();
//
//			this.reportMove(whosTurn, move);
//			othello.move(move.getRow(), move.getCol());
//		}
//		this.reportFinal();
	}
	
	protected void handleMove(int row, int col, GridPane gridBoard) {
		if (this.othello.isGameOver() == false) {
			System.out.println(othello.getWhosTurn());
			char whosTurn = othello.getWhosTurn();
			Move move = null;
			move = new Move(row, col);
			
			boolean canMove = othello.move(move.getRow(), move.getCol());
			String boardString = this.othello.getBoardString();
			System.out.println(boardString);
			if (canMove) {
				char [][] boardArray = this.othello.getBoardArray();
				
				Color color = Color.RED;
				if (whosTurn == OthelloBoard.P1) {
					color = Color.BLACK;
				}
				if (whosTurn == OthelloBoard.P2) {
					color = Color.WHITE;
				}

				Circle piece = new Circle(70 / 2 - 5);
		        piece.setFill(color);
		        gridBoard.add(piece, col, row);
		        
		        // Center the piece in the cell
		        GridPane.setHalignment(piece, HPos.CENTER);
		        GridPane.setValignment(piece, VPos.CENTER);
		        
		        
		        
		        
		        for (int r = 0; r < boardArray.length; r++) {
					for(int c = 0; c < boardArray[0].length; c++) {
						Color updatedColor = Color.RED;
						if (boardArray[r][c] == OthelloBoard.P1) {
							updatedColor = Color.BLACK;
							Circle updatedPiece = new Circle(70 / 2 - 5);
					        updatedPiece.setFill(updatedColor);
					        gridBoard.add(updatedPiece, c, r);

					     // Center the piece in the cell
					        GridPane.setHalignment(updatedPiece, HPos.CENTER);
					        GridPane.setValignment(updatedPiece, VPos.CENTER);
							
						}else if(boardArray[r][c] == OthelloBoard.P2){
							updatedColor = Color.WHITE;
							Circle updatedPiece = new Circle(70 / 2 - 5);
					        updatedPiece.setFill(updatedColor);
					        gridBoard.add(updatedPiece, c, r);
					     // Center the piece in the cell
					        GridPane.setHalignment(updatedPiece, HPos.CENTER);
					        GridPane.setValignment(updatedPiece, VPos.CENTER);
						}

					}
				}
			}
			
		}
	}
	

	protected void reportMove(char whosTurn, Move move) { }
	protected void report() { }
	protected void reportFinal() { }
}
