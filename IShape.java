package hw4;
import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * I Shape class that extends abstract shape
 * @author Benny Ooi
 * */
public class IShape extends AbstractShape
{	
	
	/**
	 * Constructs an IShape with the given position and magic state.
	 * @param givenPosition
	 *     position of this shape's center of rotation
	 * @param magic
	 * 	   true if the this shape's first cell should be magic
	 * */
	public IShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, magic);
	    Cell[] cells = new Cell[3];
	    cells[0] = new Cell(new Block(Color.CYAN, magic), givenPosition );
	    
	    Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
	    cells[1] = new Cell(new Block(Color.CYAN), position1);
	    
	    Position position2 = new Position(givenPosition.row() + 2, givenPosition.col());
	    cells[2] = new Cell(new Block(Color.CYAN), position2);
	    
	    setCell(cells);
	}

}
