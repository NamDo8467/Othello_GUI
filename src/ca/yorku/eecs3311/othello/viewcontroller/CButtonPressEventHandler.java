package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSAny;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSGreedy;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSHuman;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSRandom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	private OthelloControllerHumanVSAny othelloController;
	
	public CButtonPressEventHandler(OthelloControllerHumanVSAny othelloController) {
		this.othelloController = othelloController;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		
		if (source.getText() == "Player vs Player") {
			othelloController.othello.mode = "Player vs Player";
			othelloController.setControllerType(new OthelloControllerHumanVSHuman(this.othelloController.othello));
			
		}else if(source.getText() == "Player vs AI") {
			othelloController.othello.mode = "Player VS AI";
			othelloController.setControllerType(new OthelloControllerHumanVSGreedy(this.othelloController.othello));
			
		}else if(source.getText() == "Player vs Random") {
			othelloController.othello.mode = "Player vs Random";
			othelloController.setControllerType(new OthelloControllerHumanVSRandom(this.othelloController.othello));
			
		}
		this.othelloController.play();
		this.othelloController.othello.notifyObservers();
		
	}
	
}
