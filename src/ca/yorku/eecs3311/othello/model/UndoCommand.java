package ca.yorku.eecs3311.othello.model;

public class UndoCommand implements Command {
	private Othello othello;
	
	public UndoCommand(Othello othello) {
		this.othello = othello;
	
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.othello.undo(); 
	}

}
