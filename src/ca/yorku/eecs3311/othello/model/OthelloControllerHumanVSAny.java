package ca.yorku.eecs3311.othello.model;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OthelloControllerHumanVSAny {
	public Othello othello;
	public ControllerTypeInterface controllerType;
	public Stage stage;
	public OthelloControllerHumanVSAny(Stage stage, ControllerTypeInterface controllerType)  {
		super();
		this.controllerType = controllerType;

	}
	
	public OthelloControllerHumanVSAny() {
	}
	
	public OthelloControllerHumanVSAny(Stage stage, Othello othello) {
		super();
		this.othello = othello;
		this.stage = stage;

	}
	
	public void setControllerType(ControllerTypeInterface controllerType) {
		this.controllerType = controllerType;
	}
	
	public void play() {
		this.othello.setGameGrid(this.stage);		
		ArrayList<Rectangle> cells = this.othello.getCells();
		GridPane gridBoard = this.othello.getBoard().gridBoard;
		for(Rectangle cell:cells) {
			cell.setOnMouseClicked((MouseEvent event) -> {
				int row = GridPane.getRowIndex(cell);
				int col = GridPane.getColumnIndex(cell);
				this.controllerType.handleMove(row, col, gridBoard, this.othello);
				
			});
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
