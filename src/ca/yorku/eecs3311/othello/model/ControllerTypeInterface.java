package ca.yorku.eecs3311.othello.model;

import javafx.scene.layout.GridPane;

public interface ControllerTypeInterface {
	public void handleMove(int row, int col, GridPane gridBoard, Othello othello);
}
