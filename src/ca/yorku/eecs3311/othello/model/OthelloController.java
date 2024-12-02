package ca.yorku.eecs3311.othello.model;

import javafx.stage.Stage;

public abstract class OthelloController {

	protected Othello othello;
	public ControllerTypeInterface controllerType;
//	protected HistoryStack historyStack;
	Player player1, player2;
	
	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with a user at the console.
	 */
	public Stage stage;
	public OthelloController() {
		this.othello = new Othello();
//		this.historyStack = new HistoryStack();
//		this.stage = stage;
	}

	public void play() {
//		this.othello.setGameGrid(this.stage);
//		ArrayList<Rectangle> cells = this.othello.getCells();
//		GridPane gridBoard = this.othello.getBoard().gridBoard;
//		for(Rectangle cell:cells) {
//			cell.setOnMouseClicked((MouseEvent event) -> {
//				int row = GridPane.getRowIndex(cell);
//				int col = GridPane.getColumnIndex(cell);
//			});
//		}
				
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
	
//	protected void handleMove(int row, int col, GridPane gridBoard) {
//		if (this.othello.isGameOver() == false) {
//			char whosTurn = othello.getWhosTurn();
//			Move move = null;
//			move = new Move(row, col);
//			
//			boolean canMove = othello.move(move.getRow(), move.getCol());
//			if (canMove) {
//				char [][] boardArray = this.othello.getBoardArray();
//				
//				Color color = Color.RED;
//				if (whosTurn == OthelloBoard.P1) {
//					color = Color.BLACK;
//				}
//				if (whosTurn == OthelloBoard.P2) {
//					color = Color.WHITE;
//				}
//
//				Circle piece = new Circle(70 / 2 - 5);
//		        piece.setFill(color);
//		        gridBoard.add(piece, col, row);
//		        
//		        // Center the piece in the cell
//		        GridPane.setHalignment(piece, HPos.CENTER);
//		        GridPane.setValignment(piece, VPos.CENTER);
//		        
//		        if (player2 instanceof PlayerGreedy) {
//					Move greedyMove = this.handleMoveGreedy();
//					this.othello.move(greedyMove.getRow(), greedyMove.getCol());
//				}
//		        
//		        
//		        // Update the GUI based on the board string array
//		        for (int r = 0; r < boardArray.length; r++) {
//					for(int c = 0; c < boardArray[0].length; c++) {
//						Color updatedColor = Color.RED;
//						if (boardArray[r][c] == OthelloBoard.P1) {
//							updatedColor = Color.BLACK;
//							Circle updatedPiece = new Circle(70 / 2 - 5);
//					        updatedPiece.setFill(updatedColor);
//					        gridBoard.add(updatedPiece, c, r);
//
//					     // Center the piece in the cell
//					        GridPane.setHalignment(updatedPiece, HPos.CENTER);
//					        GridPane.setValignment(updatedPiece, VPos.CENTER);
//							
//						}else if(boardArray[r][c] == OthelloBoard.P2){
//							updatedColor = Color.WHITE;
//							Circle updatedPiece = new Circle(70 / 2 - 5);
//					        updatedPiece.setFill(updatedColor);
//					        gridBoard.add(updatedPiece, c, r);
//					     // Center the piece in the cell
//					        GridPane.setHalignment(updatedPiece, HPos.CENTER);
//					        GridPane.setValignment(updatedPiece, VPos.CENTER);
//						}
//
//					}
//				}
//			}
//			
//		}else {
//			this.othello.notifyObservers();
//		}
//	}
	
//	protected Move handleMoveGreedy() {
//		return player2.getMove();
//	}
	

	protected void reportMove(char whosTurn, Move move) { }
	protected void report() { }
	protected void reportFinal() { }
}
