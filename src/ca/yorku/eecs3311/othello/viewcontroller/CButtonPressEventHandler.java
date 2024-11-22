package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloController;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSHuman;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private OthelloController othello;
	public CButtonPressEventHandler(OthelloController othello, Stage stage) {
		this.othello = othello;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		if(source.getText()=="Player vs Player") {
//			OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman(stage);
			othello.play();
//			othello.setGameGrid(this.stage);
		} else if(source.getText()=="Player vs AI") {
//			mcounter.decrement();
		} else if(source.getText() == "Player vs Random") {
			
		}
		
	}
	
}
