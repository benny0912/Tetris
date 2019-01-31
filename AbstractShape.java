
package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 * @author Benny Ooi
 */
public abstract class AbstractShape implements Shape
{
	/**
	 *Given position from the subclass of shapes
	 * */
	private Position position;
	
	/**
	 * Cell array of objects that contain blocks in this shape
	 * */
	private Cell[] cells;

	
	
	/**
	 * Abstract constructor that implement shape interface. Most of 
	 * the common use method or code will be implement in this class 
	 * and inherit by six subclasses.
	 * @param givenPosition
	 *     position of the subclass shape's center of rotation
	 * @param magic
	 *     true if the this shape's first cell should be magic
	 * */
	protected AbstractShape(Position givenPosition, boolean magic)
	{
		position = givenPosition;
	}
	
	/**
	 * Returns a new array of Cell objects representing the blocks in this shape 
	 * along with their absolute positions. (Note that modifications to the array or Cell objects 
	 * returned by this method should NOT affect this shape.)
	 * @return 
	 *    the cells occupied by this shape
	 * */
	public Cell[] getCells()
	{
		Cell[] copy = new Cell[cells.length];
		for(int i = 0; i < cells.length; i++)
		{
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}

	/**
	 *Get the cell array object data from other shape and set into this class.
	 *@param cell
	 *    cell array objects from other shape
	 * */
	protected void setCell(Cell[] cell)
	{
		cells = new Cell[cell.length];
		for(int i = 0; i < cell.length; i++)
		{
			cells[i] = cell[i];
		}
	}
	
	/**
	 * Shifts the position of this shape down (increasing the row) by one. 
	 * No bounds checking is done.
	 * */
	public void shiftDown() 
	{
		position.setRow(position.row() + 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setRow(cells[i].getRow() + 1);
		}
	}
	
	/**
	 * Shifts the position of this shape left (decreasing the column) by one. 
	 * No bounds checking is done.
	 * */
	public void shiftLeft() 
	{
		position.setCol(position.col() - 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setCol(cells[i].getCol() - 1);
		}
	}
	
	/**
	 * Shifts the position of this shape right (increasing the column) by one. 
	 * No bounds checking is done.
	 * */
	public void shiftRight() 
	{
		position.setCol(position.col() + 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setCol(cells[i].getCol() + 1);
		}
	}
	

	/**
	 * Rotate counterclockwise about the shape's given position (center of rotation)
	 * without manipulate it's initial state and magic position
	 * Note: OTetromino and SZTetromino need to override this method
	 * */
	public void transform() 
	{
		for(int i = 0; i < cells.length; i++)
		{
			int row = cells[i].getRow() - position.row();
			int column = cells[i].getCol() - position.col();
			int temp = column;
			column = row + position.col();
			row = -1 * temp + position.row();
			cells[i].setCol(column);
			cells[i].setRow(row);
		}
	}
	
	/**
	 * Cycles the blocks within the cells of this shape. Each block is shifted forward to the next cell 
	 * (in the original ordering of the cells). The last block wraps around
	 * to the first cell.
	 * */
	public void cycle()
	{
		for(int i = 0; i < cells.length; i++)
		{
			if(i == cells.length - 1 && cells[i].getBlock().isMagic())
			{
				Block a = cells[i].getBlock();
				cells[i].setBlock(cells[0].getBlock());
				cells[0].setBlock(a);
				break;
			}
			if(cells[i].getBlock().isMagic())
			{
				Block a = cells[i + 1].getBlock();
				cells[i + 1].setBlock(cells[i].getBlock());
				cells[i].setBlock(a);
				break;
			}
		}
		
	}
	
	/**
	 * Returns a deep copy of this object having the correct runtime type.
	 * @override
	 *  	  clone in class java.lang.Object
	 * @return
	 *    a deep copy of this object
	 * */
	@Override
	public Shape clone()
	{
	  try
	  {
	    AbstractShape s = (AbstractShape) super.clone();
	
	    //make it into a deep copy
	    s.position = new Position(position);
	    s.cells = new Cell[cells.length];
	    for(int i = 0; i < cells.length; i++)
	    {
	    		s.cells[i] = new Cell(cells[i]);
	    }
	    return s;
	    
	  }
	  catch (CloneNotSupportedException e)
	  {
	    // can't happen
	    return null;
	  }
	}
}
