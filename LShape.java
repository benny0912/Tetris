package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * L Shape class that extends abstract shape
 * @author Benny Ooi
 * */
public class LShape extends AbstractShape
{	
	/**
	 * Constructs an LShape with the given position and magic state.
	 * @param givenPosition
	 *     position of this shape's center of rotation
	 * @param magic
	 * 	   true if the this shape's first cell should be magic
	 * */
	public LShape(Position givenPosition, boolean magic) 
	{
		super(givenPosition, magic);
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.ORANGE, magic), givenPosition);
		
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col() - 2);
		cells[1] = new Cell(new Block(Color.ORANGE), position1);
		
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() - 1);
		cells[2] = new Cell(new Block(Color.ORANGE), position2);
		
		Position position3 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[3] = new Cell(new Block(Color.ORANGE), position3);
		
		setCell(cells);
	}


}
