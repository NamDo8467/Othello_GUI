package ca.yorku.eecs3311.othello.model;
import java.util.ArrayList;

public class HistoryStack {
	
	private ArrayList<char[][]> stack;
	public HistoryStack() {
		this.stack = new ArrayList<char[][]>();
	}
	
	public void add(char[][] board) {
		this.stack.add(board);
	}
	

	public static void main(String[] args) {
		System.out.println("This is the History Stack");

	}

}
