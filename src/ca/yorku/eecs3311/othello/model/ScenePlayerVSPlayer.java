package ca.yorku.eecs3311.othello.model;

public class ScenePlayerVSPlayer extends ScenePlayerVSAny {
	public ScenePlayerVSPlayer(Othello othello) {
		super(othello);
		this.setCommand(new UndoCommand(othello));
	}
}
