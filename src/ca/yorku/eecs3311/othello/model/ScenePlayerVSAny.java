package ca.yorku.eecs3311.othello.model;

import java.util.ArrayList;

import ca.yorku.eecs3311.othello.viewcontroller.OthelloApplication;
import ca.yorku.eecs3311.othello.viewcontroller.VScoreAndTurn;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public abstract class ScenePlayerVSAny {
	
	protected Othello othello;
	
	protected Scene scene;
	
	private Command command;
	
	private GridPane gridBoard;
	private ArrayList<Rectangle> cells;
	private ArrayList<Circle> tokens;
	

	
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

		restartButton.setFocusTraversable(false);
		restartButton.setPrefWidth(55);
		restartButton.setPrefHeight(30);
		
		restartButton.setOnMouseClicked((MouseEvent event) ->{
			this.othello.resetBoard();
		});
		
		undoButton.setFocusTraversable(false);
		undoButton.setPrefWidth(55);
		undoButton.setPrefHeight(30);
		
		undoButton.setOnMouseClicked((MouseEvent event) -> {
			this.pressButton();
		});
		
		bp.setRight(buttonBox);
		bp.setBottom(score);
		
		buttonBox.getChildren().addAll(restartButton, undoButton);
		buttonBox.setAlignment(Pos.CENTER);
		
		bp.setCenter(this.othello.getBoard().gridBoard);
		this.othello.attach(score);

		this.scene = new Scene(bp, OthelloApplication.SCENE_WIDTH, OthelloApplication.SCENE_HEIGHT);

//		this.othello.stage.setScene(scene);
		
		
		
		
		
//		for (int row = 0; row < Othello.DIMENSION; row++) {
//            for (int col = 0; col < Othello.DIMENSION; col++) {
//                Rectangle tile = new Rectangle(OthelloBoard.CELL_WIDTH, OthelloBoard.CELL_HEIGHT);
//                
//                // Set color for a checkerboard pattern
//                tile.setFill((row + col) % 2 == 0 ? Color.GREEN : Color.DARKGREEN);
//                
//                gridBoard.add(tile, col, row);
//                
//                
//        		if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
////        			System.out.println("Row: " + row + " Col: " + col);
//                	Circle token = new Circle(OthelloBoard.CELL_SIZE / 2 - 5);
//                    
//                    token.setFill(Color.BLACK);
//                    gridBoard.add(token, col, row);
//                    tokens.add(token);
//                    GridPane.setHalignment(token, HPos.CENTER);
//                    GridPane.setValignment(token, VPos.CENTER);
//                               
//        		}
//
//                if((row == 4 && col == 3) || (row == 3 && col == 4)) {
////                	System.out.println("Row: " + row + " Col: " + col);
//                	Circle token = new Circle(OthelloBoard.CELL_SIZE / 2 - 5);
//                    
//                    token.setFill(Color.WHITE);
//                    gridBoard.add(token, col, row);
//                    tokens.add(token);
////                    System.out.println(tokens);
//                    GridPane.setHalignment(token, HPos.CENTER);
//                    GridPane.setValignment(token, VPos.CENTER);
//                    
//                    
//                }
//                
//                
//                
//                cells.add(tile);
//            }
//
//	
//
//		}
//		
//		 
//		gridBoard.setAlignment(Pos.CENTER);
//		
//		gridBoard.setGridLinesVisible(true);
		
		
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
	
	public void addTheFirst4Token(int row, int col) {
		

	}

	

}
