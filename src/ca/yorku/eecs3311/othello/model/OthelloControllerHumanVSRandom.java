package ca.yorku.eecs3311.othello.model;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a random strategy. 
 * 
 * @author student
 *
 */
public class OthelloControllerHumanVSRandom extends OthelloControllerVerbose implements ControllerTypeInterface {

	/**
	 * Constructs a new OthelloController with a new Othello game.
	 * Human VS Random strategy
	 */
	public OthelloControllerHumanVSRandom(Othello othello) {
		this.player1 = new PlayerHuman(othello, OthelloBoard.P1);
		this.player2 = new PlayerRandom(othello, OthelloBoard.P2);
		
		ScenePlayerVSAny scenePlayerVSRandom = new ScenePlayerVSRandom(othello);
		othello.stage.setScene(scenePlayerVSRandom.getScene());
	}
	
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
		        
		        Move randomMove = this.player2.getMove();
		        othello.move(randomMove.getRow(), randomMove.getCol());
		        
		        // Update the history stack and re-draw the board	        
		        othello.historyStack.push(gameState);
		        othello.notifyObservers();
		        
			}
			
		}
	}
	/**
	 * Run main to play a Human (P1) against the computer P2. 
	 * The computer uses a random strategy, that is, it randomly picks 
	 * one of its possible moves.
	 * The output should be almost identical to that of OthelloControllerHumanVSHuman.

	 * @param args
	 */
	public static void main(String[] args) {
//		OthelloControllerHumanVSRandom oc = new OthelloControllerHumanVSRandom();
//		oc.play();
	}



}


