package ca.yorku.eecs3311.othello.model;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a greedy strategy. 
 * 
 * @author student
 *
 */
public class OthelloControllerHumanVSGreedy extends OthelloControllerVerbose implements ControllerTypeInterface {

	public OthelloControllerHumanVSGreedy(Othello othello) {
		this.player1 = new PlayerHuman(othello, OthelloBoard.P1);
		this.player2 = new PlayerGreedy(othello, OthelloBoard.P2);
		ScenePlayerVSAny scenePlayerVSAI = new ScenePlayerVSAI(othello);
		othello.stage.setScene(scenePlayerVSAI.getScene());
	}
	
	@Override
	public void handleMove(int row, int col, GridPane gridBoard, Othello othello) {
		
		if (othello.isGameOver() == false) {
			char whosTurn = othello.getWhosTurn();
			Move move = null;
			move = new Move(row, col);
			
			
			Othello othelloCopy = othello.copy();
			
			// Capture the current game state
			GameState gameState = new GameState(othelloCopy.getBoard(), othello.getWhosTurn(), othello.getBoard().copyTokens());
			
			boolean canMove = othello.move(move.getRow(), move.getCol());
			if (canMove) {				
				Color color = Color.RED;
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
		        
		        // Player2 makes a move
		        Move greedyMove = this.player2.getMove();
		        othello.move(greedyMove.getRow(), greedyMove.getCol());
		        
		        // Update the history stack and re-draw the board
		        othello.historyStack.push(gameState);
		        othello.notifyObservers();
			}
			
		}
		
	}

	/**
	 * Run main to play a Human (P1) against the computer P2. 
	 * The computer uses a greedy strategy, that is, it picks the first
	 * move which maximizes its number of token on the board.
	 * The output should be almost identical to that of OthelloControllerHumanVSHuman.
	 * @param args
	 */
	public static void main(String[] args) {
//		OthelloControllerHumanVSGreedy oc = new OthelloControllerHumanVSGreedy();
//		oc.play();
	}


}
