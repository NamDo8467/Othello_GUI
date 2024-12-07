package ca.yorku.eecs3311.othello.model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import ca.yorku.eecs3311.othello.viewcontroller.OthelloApplication;
import ca.yorku.eecs3311.othello.viewcontroller.VScoreAndTurn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public abstract class ScenePlayerVSAny {
	
	protected Othello othello;
	
	protected Scene scene;
	
	private Command command;
	
	private GridPane gridBoard;
	private ArrayList<Rectangle> cells;
	private ArrayList<Circle> tokens;
	
	private final int BUTTON_HEIGHT = 30;
	private final int BUTTON_WIDTH = 55;

	
	public ScenePlayerVSAny(Othello othello) {
		this.othello = othello;
		this.gridBoard = othello.getBoard().gridBoard;
		this.cells = othello.getBoard().cells;
		this.tokens = othello.getBoard().tokens;
		
		
		
		BorderPane bp = new BorderPane();
		VScoreAndTurn score = new VScoreAndTurn();
		
		VBox buttonBox = new VBox(10);
		buttonBox.setPadding(new Insets(0, 5, 0, 5));
		Button restartButton = new Button("Restart");
		
		Button undoButton = new Button("Undo");
		
		Button saveGameButton = new Button("Save game");

		restartButton.setFocusTraversable(false);
		restartButton.setPrefWidth(BUTTON_WIDTH);
		restartButton.setPrefHeight(BUTTON_HEIGHT);
		
		restartButton.setOnMouseClicked((MouseEvent event) ->{
			this.othello.resetBoard();
		});
		
		undoButton.setFocusTraversable(false);
		undoButton.setPrefWidth(BUTTON_WIDTH);
		undoButton.setPrefHeight(BUTTON_HEIGHT);
		
		undoButton.setOnMouseClicked((MouseEvent event) -> {
			this.pressButton();
		});
		
		saveGameButton.setFocusTraversable(false);
		saveGameButton.setPrefWidth(BUTTON_WIDTH + 20);
		saveGameButton.setPrefHeight(BUTTON_HEIGHT);
		
		saveGameButton.setOnMouseClicked((MouseEvent event) ->{
			Othello othelloCopy = this.othello.copy();
			
			// Capture the current state of the game
			GameState gameState = new GameState(othelloCopy.getBoard(), othello.getWhosTurn(), othello.getBoard().copyTokens());
		
			try {
		      FileOutputStream file = new FileOutputStream("saved_game.txt");
		      
		      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);
		      char [][] currentBoard = gameState.getBoard().board;
		   	    
		      outputStreamWriter.write("mode:" + othelloCopy.mode);
		      outputStreamWriter.write("\n");
		      outputStreamWriter.write("whosTurn:" + othelloCopy.getWhosTurn());
		      outputStreamWriter.write("\n");
		      int rows = currentBoard.length;
		      int cols = currentBoard[0].length;
		      
		      for (int i = 0; i < rows; i++) {
		    	  for (int j = 0; j < cols; j++) {
					outputStreamWriter.write(currentBoard[i][j]);
				}
		    	  outputStreamWriter.write("\n");
				
		      }
		      
		      
		      outputStreamWriter.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("Saved game file not found");
//		      e.printStackTrace();
		    }catch (IOException e2) {
		    	System.out.println("An error occurred while attempting to save the file");
			}
		
		});
		
		bp.setRight(buttonBox);
		bp.setBottom(score);
		
		buttonBox.getChildren().addAll(restartButton, undoButton, saveGameButton);
		buttonBox.setAlignment(Pos.CENTER);
		
		bp.setCenter(this.othello.getBoard().gridBoard);
		this.othello.attach(score);

		this.scene = new Scene(bp, OthelloApplication.SCENE_WIDTH, OthelloApplication.SCENE_HEIGHT);
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
        command.execute();
    }
	
	public void saveGame() {
		
		
	}

	

}
