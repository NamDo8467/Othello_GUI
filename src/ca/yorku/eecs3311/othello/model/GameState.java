package ca.yorku.eecs3311.othello.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameState {

    private OthelloBoard board;
    private char whosTurn;
    private ArrayList<Circle> tokens;

    /**
     * Capture all the important properties needed to recreate the game to the previous stage
     *
     * @param game Othello game whose state is captured
     * */
    public GameState(Othello game) {
        this.board = game.getBoard().copy();
        this.whosTurn = game.getWhosTurn();

    }

    public GameState(OthelloBoard board, char whosTurn, ArrayList<Circle> tokens) {
        this.board = board;
        this.whosTurn = whosTurn;
        this.tokens = tokens;

    }

    public OthelloBoard getBoard() { return this.board; }
    public char getWhosTurn() { return this.whosTurn; }
    
    public ArrayList<Circle> getTokens() { return this.tokens; }

    public GameState copy() {
        return new GameState(this.board, this.whosTurn, this.tokens);
    }
}