package hw3;

import static api.Orientation.*;
import static api.CellType.*;

import java.util.ArrayList;

import api.Cell;

/**
 * Utilities for parsing string descriptions of a grid.
 */
public class GridUtil {
	/**
	 * Constructs a 2D grid of Cell objects given a 2D array of cell descriptions.
	 * String descriptions are a single character and have the following meaning.
	 * <ul>
	 * <li>"*" represents a wall.</li>
	 * <li>"e" represents an exit.</li>
	 * <li>"." represents a floor.</li>
	 * <li>"[", "]", "^", "v", or "#" represent a part of a block. A block is not a
	 * type of cell, it is something placed on a cell floor. For these descriptions
	 * a cell is created with CellType of FLOOR. This method does not create any
	 * blocks or set blocks on cells.</li>
	 * </ul>
	 * The method only creates cells and not blocks. See the other utility method
	 * findBlocks which is used to create the blocks.
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a 2D array of cells the represent the grid without any blocks present
	 */
	public static Cell[][] createGrid(String[][] desc) {
		int descLength = desc[0].length;
		Cell[][] grid = new Cell[desc.length][descLength];
		for (int i=0; i<desc.length; i++) {
			for (int k=0; k<desc[i].length; k++) {
				if (desc[i][k].equals("*")) {
					Cell newCell = new Cell(WALL, i, k);
					grid[i][k] = newCell;
				} else if (desc[i][k].equals("e")) {
					Cell newCell = new Cell(EXIT, i, k);
					grid[i][k] = newCell;
				} else if (desc[i][k].equals(".")) {
					Cell newCell = new Cell(FLOOR, i, k);
					grid[i][k] = newCell;
					//"[", "]", "^", "v", or "#"
				} else if (desc[i][k].equals("[") || desc[i][k] == "]" || desc[i][k] == "^" || desc[i][k] == "v" || desc[i][k] == "#") {
					Cell newCell = new Cell(FLOOR, i, k);
					grid[i][k] = newCell;
				}
			}
		}
		
		
		
		return grid;
	}

	/**
	 * Returns a list of blocks that are constructed from a given 2D array of cell
	 * descriptions. String descriptions are a single character and have the
	 * following meanings.
	 * <ul>
	 * <li>"[" the start (left most column) of a horizontal block</li>
	 * <li>"]" the end (right most column) of a horizontal block</li>
	 * <li>"^" the start (top most row) of a vertical block</li>
	 * <li>"v" the end (bottom most column) of a vertical block</li>
	 * <li>"#" inner segments of a block, these are always placed between the start
	 * and end of the block</li>
	 * <li>"*", ".", and "e" symbols that describe cell types, meaning there is not
	 * block currently over the cell</li>
	 * </ul>
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a list of blocks found in the given grid description
	 */
	public static ArrayList<Block> findBlocks(String[][] desc) throws ArrayIndexOutOfBoundsException {
		ArrayList<Block> blockList = new ArrayList<Block>();
		if (!(desc.length==0)) {
			for (int i=0; i<desc.length; i++) {
				for (int k=0; k<desc[i].length; k++) {
					if (desc[i][k].equals("[") && desc[i][k+1].equals("*") && desc[i][k+2].equals("]")) {
						Block tempBlock = new Block(i, k, 3, HORIZONTAL);
						blockList.add(tempBlock);
					} else if (desc[i][k].equals("[") && desc[i][k+1].equals("]")) {
						Block tempBlock = new Block(i, k, 2, HORIZONTAL);
						blockList.add(tempBlock);
					} else if (desc[i][k].equals("[") && desc[i][k+1].equals("*") && desc[i][k+2].equals("*")) {
						int counter = 0;
						for (int b=k; b<desc[i].length; b++) {
							if (desc[i][b].equals("*")) {
								counter++;
							}
							Block tempBlock = new Block(i, k, counter, HORIZONTAL);
							blockList.add(tempBlock);
						}
				// Vertical section
					} else if (desc[i][k].equals("^") && desc[i+1][k].equals("v")) {
						Block tempBlock = new Block(i, k, 1, VERTICAL);
						blockList.add(tempBlock);
					} else if (desc[i][k].equals("^") && desc[i+1][k].equals("*") && desc[i+2][k].equals("v")) {
						Block tempBlock = new Block(i, k, 2, VERTICAL);
						blockList.add(tempBlock);
					} else if (desc[i][k].equals("^") && desc[i+1][k].equals("*") && desc[i+2][k].equals("*")) {
						for (int b=i; b<desc.length; b++) {
							int counterB = 0;
							if (desc[b][k].equals("*")) {
								counterB++;
							}
							Block tempBlock = new Block(i, k, counterB, VERTICAL);
							blockList.add(tempBlock);
						}
					}
						
					}
			}			
		}
		return blockList;
	}
}
