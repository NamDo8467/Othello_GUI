package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloController;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSAny;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSGreedy;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSHuman;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSRandom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CButtonPressEventHandler implements EventHandler<ActionEvent> {
	
//	private Stage stage;
	private OthelloControllerHumanVSAny othelloController;
	public CButtonPressEventHandler(OthelloControllerHumanVSAny othelloController) {
		this.othelloController = othelloController;
//		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		
		if (source.getText() == "Player vs Player") {
			
			othelloController.setControllerType(new OthelloControllerHumanVSHuman(this.othelloController.othello));
			
		}else if(source.getText() == "Player vs AI") {
			
			othelloController.setControllerType(new OthelloControllerHumanVSGreedy(this.othelloController.othello));
			
		}else if(source.getText() == "Player vs Random") {
			
			othelloController.setControllerType(new OthelloControllerHumanVSRandom());
			
		}
		this.othelloController.play();
		
		
//		if(source.getText()=="Player vs Player") {
////			OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman(stage);
//			othelloController.play();
////			othelloController.setGameGrid(this.stage);
//		} else if(source.getText()=="Player vs AI") {
//			othelloController.play();
////			mcounter.decrement();
//		} else if(source.getText() == "Player vs Random") {
//			
//		}else {
//			System.out.println("hdskjfhkadsf");
//		}
		
	}
	
}
