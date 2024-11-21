package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSHuman;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Othello othello;
	public CButtonPressEventHandler(Othello othello, Stage stage) {
		this.othello = othello;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		if(source.getText()=="Player vs Player") {
			othello.setGameGrid(this.stage);
		} else if(source.getText()=="Player vs AI") {
//			mcounter.decrement();
		} else if(source.getText() == "Player vs Random") {
			
		}
		
	}
	
}
