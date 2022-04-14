package hw3;

import static api.Orientation.*;
import static api.Direction.*;
import static api.CellType.*;

public class BlockTest {

	public static void main(String[] args) {

		Block block = new Block(2, 1, 2, HORIZONTAL);
		System.out.println("Block is " + block);
		block.move(DOWN); // horizontal blocks not allowed to move down
		System.out.println("After move DOWN, block is " + block);
		System.out.println("Expected block at (row=2, col=2).");
		
	}

}
