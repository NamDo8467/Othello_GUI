package ca.yorku.eecs3311.othello.viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CButtonPressEventHandler implements EventHandler<ActionEvent> {
	
	public CButtonPressEventHandler() {
		
	}

	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		if(source.getText()=="Player vs Player") {
//			mcounter.increment();
		} else if(source.getText()=="Player vs AI") {
//			mcounter.decrement();
		} else if(source.getText() == "Player vs Random") {
			
		}
		
	}
	
}
