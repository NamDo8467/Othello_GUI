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
			
			Move move = null;
			move = new Move(row, col);
			
			Othello othelloCopy = othello.copy();
			
			// Capture the current state of the game
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

		        
		        // Update the history stack and re-draw the board	        
		        othello.historyStack.push(gameState);
		        othello.notifyObservers();
		        
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

