package ca.yorku.eecs3311.othello.model;

public class ScenePlayerVSRandom extends ScenePlayerVSAny {
	public ScenePlayerVSRandom(Othello othello) {
		super(othello);
		this.setCommand(new UndoCommand(othello));
	}
}
