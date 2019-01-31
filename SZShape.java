package hw4;

import java.awt.Color;

import api.Cell;
import api.Position;
import api.Block;

/**
 * SZ Shape class that extends abstract shape
 * @author Benny Ooi
 * */
public class SZShape extends AbstractShape
{	
	
	/**
	 * True if is magic, false otherwise
	 * */
	private boolean isMagic;

	/**
	 * Constructs an SZShape with the given position and magic state.
	 * @param givenPosition
	 *     position of this shape's center of rotation
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 * */
	public SZShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, magic);
		isMagic = magic;
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.GREEN, magic), givenPosition);
		
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[1] = new Cell(new Block(Color.GREEN), position1);
		
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() + 1);
		cells[2] = new Cell(new Block(Color.GREEN), position2);
		
		Position position3 = new Position(givenPosition.row() + 2, givenPosition.col() + 1);
		cells[3] = new Cell(new Block(Color.GREEN), position3);
		
		setCell(cells);
	}

	
	/**
	 * This shape transform or flip across the vertical axis and
	 * change color. (Does not rotate)
	 * @Override
	 *    transform method in super class
	 * */
	@Override
	public void transform() 
	{
		Cell[] cells = getCells();
		int magicPosition = 0;
		for(int i = 0; i < cells.length;i++)
		{
			if(cells[i].getBlock().isMagic())
			{
				magicPosition = i;
			}
		}
		
		if(cells[0].getBlock().getColorHint() == Color.RED)
		{
			cells[0].setCol(cells[0].getCol() - 1);
			cells[1].setCol(cells[1].getCol() - 1);
			cells[2].setCol(cells[2].getCol() + 1);
			cells[3].setCol(cells[3].getCol() + 1);
			for(int i = 0; i < cells.length; i++)
			{
				if(i == magicPosition)
				{
					cells[i].setBlock(new Block(Color.GREEN, isMagic));
				}
				else
				{
					cells[i].setBlock(new Block(Color.GREEN));
				}
			}
			setCell(cells);
		}
		else
		{
			cells[0].setCol(cells[0].getCol() + 1);
			cells[1].setCol(cells[1].getCol() + 1);
			cells[2].setCol(cells[2].getCol() - 1);
			cells[3].setCol(cells[3].getCol() - 1);
			for(int i = 0; i < cells.length; i++)
			{
				if(i == magicPosition)
				{
					cells[i].setBlock(new Block(Color.RED, isMagic));
				}
				else
				{
					cells[i].setBlock(new Block(Color.RED));
				}
			}
			setCell(cells);
		}
	}

}
