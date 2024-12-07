package ca.yorku.eecs3311.othello.viewcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSAny;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSGreedy;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSHuman;
import ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSRandom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CLoadGamePressEventHandler implements EventHandler<ActionEvent> {

	private OthelloControllerHumanVSAny othelloController;
	private String mode;
	private String whosTurn;
	
	public CLoadGamePressEventHandler(OthelloControllerHumanVSAny othelloController) {
		this.othelloController = othelloController;
	}
	
	@Override
	public void handle(ActionEvent event) {
		File file = new File("saved_game.txt");
	        Scanner sc;
			try {
				sc = new Scanner(file);
				char [][] board = new char[8][8];
				int row = 0;
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.startsWith("mode")) {
						String [] arr =  line.split(":");
						othelloController.othello.mode = arr[1];
						
					}
					
					else if (line.startsWith("whosTurn")) {
						String [] arr =  line.split(":");
						othelloController.othello.setWhosTurn(arr[1].charAt(0));
					}else {
						for(int i = 0; i < line.length(); i++) {
							char token = line.charAt(i);
							board[row][i] = token;
						}
						row += 1;
						
						
						
					}

					
				}
				othelloController.othello.updateBoardFromLoadedGame(board);
				if (othelloController.othello.mode.equals("Player vs Player")) {
					othelloController.setControllerType(new OthelloControllerHumanVSHuman(othelloController.othello));
					
				}else if(othelloController.othello.mode.equals("Player vs AI")) {
					othelloController.setControllerType(new OthelloControllerHumanVSGreedy(othelloController.othello));
					
				}else if(othelloController.othello.mode.equals("Player vs Random")) {
					othelloController.setControllerType(new OthelloControllerHumanVSRandom(othelloController.othello));
					
				}
				othelloController.play();
				othelloController.othello.notifyObservers();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
				e.printStackTrace();
			}

	        
	}
}
