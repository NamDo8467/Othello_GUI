package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	// --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.
	final int PREF_HEIGHT = 50;
	final int BUTTON_HEIGHT = 40;
	final int BUTTON_WIDTH = 120;
	final int GAME_NAME_LABEL_HEIGHT = 40;
	final int GAME_NAME_LABEL_WIDTH = 120;
	public static final int SCENE_HEIGHT = 600;
	public static final int SCENE_WIDTH = 650;
	
	@Override
	public void start(Stage stage) throws Exception {
		// Create and hook up the Model, View and the controller
		
		// MODEL
		Othello othello = new Othello(stage);		
		OthelloControllerHumanVSAny othelloController = new OthelloControllerHumanVSAny(othello);
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
		CButtonPressEventHandler cpresshandler= new CButtonPressEventHandler(othelloController);
		CLoadGamePressEventHandler cloadGamehandler = new CLoadGamePressEventHandler(othelloController);
	
		// VIEW
		Label gameNameLabel = new Label("Othello");
		gameNameLabel.setFont(new Font(25));
		gameNameLabel.setPrefSize(GAME_NAME_LABEL_WIDTH, GAME_NAME_LABEL_HEIGHT);
		gameNameLabel.setAlignment(Pos.CENTER);

		
		Button vPlayerVSPlayerButton = new Button("Player vs Player");
		Button vPlayerVSAIButton = new Button("Player vs AI");
		Button vPlayerVSRandomButton = new Button("Player vs Random");
		Button vLoadGameButton = new Button("Load game");
		vLoadGameButton.setFont(new Font(11));
		Button [] buttonArray = {vPlayerVSAIButton, vPlayerVSPlayerButton, vPlayerVSRandomButton, vLoadGameButton};
		
		// VIEW->CONTROLLER hookup
		vPlayerVSPlayerButton.setOnAction(cpresshandler);
		vPlayerVSAIButton.setOnAction(cpresshandler);
		vPlayerVSRandomButton.setOnAction(cpresshandler);
		vLoadGameButton.setOnAction(cloadGamehandler);
		// MODEL->VIEW hookup
		
		
		GridPane grid = new GridPane();
		
		grid.add(gameNameLabel, 0, 0);
		grid.add(vPlayerVSPlayerButton, 0, 1);
		grid.add(vPlayerVSAIButton, 0, 2);
		grid.add(vPlayerVSRandomButton, 0, 3);
		grid.add(vLoadGameButton,0,4);
		
		RowConstraints row0 = new RowConstraints();
		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		RowConstraints row3 = new RowConstraints();
		RowConstraints row4 = new RowConstraints();
		
		RowConstraints [] rowConstraintArray = {row0, row1, row2, row3, row4};
		for(RowConstraints row: rowConstraintArray) {
			grid.getRowConstraints().add(row);
			row.setPrefHeight(PREF_HEIGHT);
		}
		
		for(Button button:buttonArray) {
			button.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
			button.setFocusTraversable(false);
			GridPane.setHalignment(button, HPos.CENTER);
			GridPane.setValignment(button, VPos.CENTER);
		}		
		grid.setAlignment(Pos.CENTER);
		
		
		
		
		// SCENE
		Scene scene = new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT);
		
		GridPane g = new GridPane();
		stage.setTitle("Othello");
		stage.setScene(scene);
		
				
		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
