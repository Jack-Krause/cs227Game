package hw3;

import java.util.ArrayList;

import api.Cell;

public class gridUtilTest {
	
	public static final String[][] testDescription1 = 
		{ 		{"*", "*", "*", "*", "*"},
				{"*", ".", ".", ".", "*"},
				{"*", "[", "]", ".", "e"},
				{"*", ".", ".", ".", "*"},
				{"*", "*", "*", "*", "*"}};

	public static void main(String[] args) {
 		Cell[][] cells = GridUtil.createGrid(testDescription1);
		System.out.println("Using testDescription1, cell (2, 4) is an exit is " + cells[2][4].isExit() + ", expected is true");
		System.out.println("cell (1,1) is a floor is " + cells[1][1].isFloor() + ", expected is true");
		System.out.println(cells[1][1].isWall());
		ArrayList<Block> blocks = GridUtil.findBlocks(testDescription1);
		System.out.println("Using testDescription1, number of blocks is " + blocks.size() + ", expected is 1.");
		System.out.println("Using testDecription1, first block is length " + blocks.get(0).getLength() + ", expected is 2.");
	}
	

	
}
