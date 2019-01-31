package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;


/**
 * T Shape class that extends abstract shape
 * @author Benny Ooi
 * */
public class TShape extends AbstractShape
{	
	
	/**
	 * Constructs a TShape with the given position and magic state.
	 * @param givenPosition
	 *     position of this shape's center of rotation
	 * @param magic
	 * 	   true if the this shape's first cell should be magic
	 * */
	public TShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, magic);
		Cell[] cells = new Cell[4];
		Position position1 = new Position(givenPosition.row() - 1, givenPosition.col());
		cells[0] = new Cell(new Block(Color.MAGENTA, magic), position1);
		
		Position position2 = new Position(givenPosition.row(), givenPosition.col() - 1);
		cells[1] = new Cell(new Block(Color.MAGENTA), position2);
		
		Position position3 = new Position(givenPosition.row(), givenPosition.col());
		cells[2] = new Cell(new Block(Color.MAGENTA), position3);
		
		Position position4 = new Position(givenPosition.row(), givenPosition.col() + 1);
		cells[3] = new Cell(new Block(Color.MAGENTA), position4);
		
		setCell(cells);
	}
	
}
