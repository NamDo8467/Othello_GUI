package ca.yorku.eecs3311.othello.model;
import ca.yorku.eecs3311.util.Observable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Capture an Othello game. This includes an OthelloBoard as well as knowledge
 * of how many moves have been made, whosTurn is next (OthelloBoard.P1 or
 * OthelloBoard.P2). It knows how to make a move using the board and can tell
 * you statistics about the game, such as how many tokens P1 has and how many
 * tokens P2 has. It knows who the winner of the game is, and when the game is
 * over.
 * 
 * See the following for a short, simple introduction.
 * https://www.youtube.com/watch?v=Ol3Id7xYsY4
 * 
 * @author student
 *
 */
public class Othello extends Observable {
	public static final int DIMENSION=8; // This is an 8x8 game
	
	private OthelloBoard board=new OthelloBoard(Othello.DIMENSION);
	private char whosTurn = OthelloBoard.P1;
	private int numMoves = 0;
	public HistoryStack historyStack;
	public Stage stage;
	public String mode;
	
	
	public BoardUpdater boardUpdater = new BoardUpdater();
	
	public Othello() {
		this.attach(boardUpdater);
	}
	
	public Othello(Stage stage) {
		this.stage = stage;
		this.historyStack = new HistoryStack();
		this.attach(boardUpdater);
		
		
	}
	
	/**
	 * set up the game based on the state parameter
	 * @param state - GameState
	 */
	public void setState(GameState state) {
		this.board = state.getBoard();
		this.whosTurn = state.getWhosTurn();
		this.board.tokens = state.getTokens();
		this.notifyObservers();
		
	}
	
	/**
	 * Undo the move
	 */
	public void undo() {
		GameState previousState = this.historyStack.pop();
		if (previousState == null) {
			return;
		}

		this.board.gridBoard.getChildren().removeAll(this.board.tokens);
		while (this.board.tokens.size() > 0) {
			this.board.tokens.remove(0);
		}
		
		this.setState(previousState);
		
	}
	
	/**
	 * return the list of all the cells in the board
	 * @return cells - ArrayList typed Rectangle
	 */
	protected ArrayList<Rectangle> getCells() {
		return this.board.cells;
	}
	
	/**
	 * 
	 * @return board - OthelloBoard
	 */
	protected OthelloBoard getBoard() {
		return this.board;
	}
	
	
	/**
	 * Return the array representation of the current board
	 * @return char[][] board
	 */
	protected char[][] getBoardArray() {
		return this.board.board;
	}
	
	

	/**
	 * return P1,P2 or EMPTY depending on who moves next.
	 * 
	 * @return P1, P2 or EMPTY
	 */
	public char getWhosTurn() {
		return this.whosTurn;
	}
	
	/**
	 * Set whosTurn (mostly used when users are loading the game from saved_game.txt)
	 * @param whosTurn - char
	 */
	public void setWhosTurn(char whosTurn) {
		this.whosTurn = whosTurn;
	}
	
	/**
	 * 
	 * @param row 
	 * @param col
	 * @return the token at position row, col.
	 */
	public char getToken(int row, int col) {
		return this.board.get(row, col);
	}

	/**
	 * Attempt to make a move for P1 or P2 (depending on whos turn it is) at
	 * position row, col. A side effect of this method is modification of whos turn
	 * and the move count.
	 * 
	 * @param row
	 * @param col
	 * @return whether the move was successfully made.
	 */
	public boolean move(int row, int col) {
		if(this.board.move(row, col, this.whosTurn)) {
			this.whosTurn = OthelloBoard.otherPlayer(this.whosTurn);
			char allowedMove = board.hasMove();
			if(allowedMove!=OthelloBoard.BOTH)this.whosTurn=allowedMove;
			this.numMoves++;
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 
	 * @param player P1 or P2
	 * @return the number of tokens for player on the board
	 */
	public int getCount(char player) {
		return board.getCount(player);
	}


	/**
	 * Returns the winner of the game.
	 * 
	 * @return P1, P2 or EMPTY for no winner, or the game is not finished.
	 */
	public char getWinner() {
		if(!this.isGameOver())return OthelloBoard.EMPTY;
		if(this.getCount(OthelloBoard.P1)> this.getCount(OthelloBoard.P2))return OthelloBoard.P1;
		if(this.getCount(OthelloBoard.P1)< this.getCount(OthelloBoard.P2))return OthelloBoard.P2;
		return OthelloBoard.EMPTY;
	}


	/**
	 * 
	 * @return whether the game is over (no player can move next)
	 */
	public boolean isGameOver() {
		return this.whosTurn==OthelloBoard.EMPTY;
	}

	/**
	 * 
	 * @return a copy of this. The copy can be manipulated without impacting this.
	 */
	public Othello copy() {
		Othello o= new Othello();
		o.board = this.board.copy();
		o.numMoves = this.numMoves;
		o.whosTurn = this.whosTurn;
		o.mode = this.mode;
		return o;
	}
	
	/**
	 * Reset the board and scores
	 */
	public void resetBoard() {
		this.board.resetBoard();
		this.whosTurn = OthelloBoard.P1;
		this.notifyObservers();
	}
	
	public void updateBoardFromLoadedGame(char[][] loadedBoard) {
		
		
		this.board.gridBoard.getChildren().removeAll(this.board.tokens); // remove all the tokens (the circles) from the GUI board
		
		// remove all the tokens from the tokens list
		while (this.board.tokens.size() > 0) {
			this.board.tokens.remove(0);
		}
		
		this.board.updateBoardFromLoadedGame(loadedBoard);
	}
	
	/**
	 * Add the token to the current token list
	 * @param token
	 */
	public void addTokenToTokenList(Circle token) {
		this.board.addTokenTokenList(token);
		
	}


	/**
	 * 
	 * @return a string representation of the board.
	 */
	public String getBoardString() {
		return board.toString()+"\n";
	}


	/**
	 * run this to test the current class. We play a completely random game. DO NOT
	 * MODIFY THIS!! See the assignment page for sample outputs from this.
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		Random rand = new Random();


		Othello o = new Othello();
		System.out.println(o.getBoardString());
		while(!o.isGameOver()) {
			int row = rand.nextInt(8);
			int col = rand.nextInt(8);

			if(o.move(row, col)) {
				System.out.println("makes move ("+row+","+col+")");
				System.out.println(o.getBoardString()+ o.getWhosTurn()+" moves next");
			}
		}

	}
}


