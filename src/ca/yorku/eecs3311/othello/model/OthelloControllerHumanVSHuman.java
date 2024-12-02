package ca.yorku.eecs3311.othello.model;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Run the main from this class to play two humans against eachother. Only
 * minimal modifications to this class are permitted.
 * 
 * @author student
 *
 */
public class OthelloControllerHumanVSHuman extends OthelloControllerVerbose implements ControllerTypeInterface {
	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with two users at the console.
	 */
	public OthelloControllerHumanVSHuman(Othello othello) {
		this.player1 = new PlayerHuman(othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(othello, OthelloBoard.P2);
		ScenePlayerVSAny scenePlayerVSPlayer = new ScenePlayerVSPlayer(othello);
		othello.stage.setScene(scenePlayerVSPlayer.getScene());
	}
	
	public void handleMove(int row, int col, GridPane gridBoard, Othello othello) {
		if (othello.isGameOver() == false) {
			char whosTurn = othello.getWhosTurn();
			
			OthelloBoard boardArrayCopy = othello.getBoard();
			char [][] b = boardArrayCopy.board;
			Move move = null;
			move = new Move(row, col);
			
			Othello othelloCopy = othello.copy();
			
			GameState gameState = new GameState(othelloCopy.getBoard(), othello.getWhosTurn(), othello.getBoard().copyTokens());
//			System.out.println("-----------------------");
			boolean canMove = othello.move(move.getRow(), move.getCol());
			
			
			if (canMove) {
				Color color = Color.RED;
				char [][] boardArray = othello.getBoardArray();
				if (whosTurn == OthelloBoard.P1) {
					color = Color.BLACK;
				}
				if (whosTurn == OthelloBoard.P2) {
					color = Color.WHITE;
				}

				Circle token = new Circle(70 / 2 - 5);
		        token.setFill(color);
		        gridBoard.add(token, col, row);
		        othello.addTokenToTokenList(token);
		        
		        // Center the piece in the cell
		        GridPane.setHalignment(token, HPos.CENTER);
		        GridPane.setValignment(token, VPos.CENTER);

		        
		        // Update the history stack
//		        System.out.println(othello.getCount(OthelloBoard.P1));
//				System.out.println(whosTurn);
		        
		        
//				System.out.println(gameState.getTokens().size());
		        othello.historyStack.push(gameState);
		        othello.notifyObservers();
		        
		        // Update the GUI based on the board string array		    
//		        for (int r = 0; r < boardArray.length; r++) {
//					for(int c = 0; c < boardArray[0].length; c++) {
//						Color updatedColor = Color.RED;
//						if (boardArray[r][c] == OthelloBoard.P1) {
//							updatedColor = Color.BLACK;
//							Circle updatedToken = new Circle(70 / 2 - 5);
//							
//							updatedToken.setFill(updatedColor);
//					        gridBoard.add(updatedToken, c, r);
//					        othello.addTokenToTokenList(updatedToken);
//					        
//					     // Center the piece in the cell
//					        GridPane.setHalignment(updatedToken, HPos.CENTER);
//					        GridPane.setValignment(updatedToken, VPos.CENTER);
//					        
//							
//						}else if(boardArray[r][c] == OthelloBoard.P2){
//							updatedColor = Color.WHITE;
//							Circle updatedToken = new Circle(70 / 2 - 5);
//							updatedToken.setFill(updatedColor);
//					        gridBoard.add(updatedToken, c, r);
//					        othello.addTokenToTokenList(updatedToken);
//					        
//					     // Center the piece in the cell
//					        GridPane.setHalignment(updatedToken, HPos.CENTER);
//					        GridPane.setValignment(updatedToken, VPos.CENTER);
//						}
//
//					}
//				}
			}
			
		}
	}

	/**
	 * Run main to play two Humans against each other at the console.
	 * @param args
	 */
	public static void main(String[] args) {
//		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
//		oc.play();
	}

}

