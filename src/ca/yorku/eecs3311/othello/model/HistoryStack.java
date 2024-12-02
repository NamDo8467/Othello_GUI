package ca.yorku.eecs3311.othello.model;
import java.util.ArrayList;

public class HistoryStack {
	
	private ArrayList<GameState> stack;
	public HistoryStack() {
		this.stack = new ArrayList<GameState>();
	}
	
	public boolean isEmpty() { 
		return this.stack.size() == 0; 
	}
	
	
	public void push(GameState state) {
		this.stack.add(state);
	}
	
	public GameState pop() {
		if(this.isEmpty()) { 
			return null; 
		}
		return this.stack.remove(this.stack.size() - 1);
	}
	public int getSize() {
		return this.stack.size();
	}

	public static void main(String[] args) {
		System.out.println("This is the History Stack");

	}

}
