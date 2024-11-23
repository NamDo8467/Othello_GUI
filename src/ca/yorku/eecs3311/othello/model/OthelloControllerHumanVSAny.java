package ca.yorku.eecs3311.othello.model;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OthelloControllerHumanVSAny {
	protected Othello othello;
	public ControllerTypeInterface controllerType;
	Player player1, player2;
	
	public Stage stage;
	public OthelloControllerHumanVSAny(Stage stage, ControllerTypeInterface controllerType) {
		this.othello = new Othello();
		this.controllerType = controllerType;
		this.stage = stage;

	}
	
	public OthelloControllerHumanVSAny(Stage stage) {
		this.othello = new Othello();
		this.stage = stage;
	}
	
	public void setControllerType(ControllerTypeInterface controllerType) {
		this.controllerType = controllerType;
	}
	
	public void play() {
		this.othello.setGameGrid(this.stage);
		System.out.println(this.othello.getObserversSize());
		ArrayList<Rectangle> cells = this.othello.getCells();
		GridPane gridBoard = this.othello.getBoard().gridBoard;
		for(Rectangle cell:cells) {
			cell.setOnMouseClicked((MouseEvent event) -> {
				int row = GridPane.getRowIndex(cell);
				int col = GridPane.getColumnIndex(cell);
//				System.out.println(this.othello);
				this.controllerType.handleMove(row, col, gridBoard, this.othello);
				
			});
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
