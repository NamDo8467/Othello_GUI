package ca.yorku.eecs3311.othello.model;

public class ScenePlayerVSAI extends ScenePlayerVSAny {
	public ScenePlayerVSAI(Othello othello) {
		super(othello);
		this.setCommand(new UndoCommand(othello));

	}
}
