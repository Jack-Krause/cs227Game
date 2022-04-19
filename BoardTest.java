package hw3;

import java.util.ArrayList;
import api.Orientation;//ADD THESE
import static api.Orientation.*;
import static api.Direction.*;
import static api.CellType.*;
import java.util.ArrayList;
import static api.Orientation.*;
import static api.CellType.*;
import api.Cell;
import static ui.GameMain.*;



public class BoardTest {
	
	private static ArrayList<Block> makeTest1Blocks() {
		ArrayList<Block> blocks = new ArrayList<Block>();
		blocks.add(new Block(2, 1, 2, HORIZONTAL));
		return blocks;
	}


	public static void main(String[] args) {
		System.out.println("Making board with testGrid1");
		Board board = new Board(testGrid1, makeTest1Blocks());
		System.out.println(board.toString());
	}

}
