
package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 * @author Benny Ooi
 */
public class MagicTetris extends AbstractGame
{
	/**
	 * True if the grid is currently in gravity mode, false otherwise.
	 * */
	private boolean gravity;
	
	/**
	 * The total score of the game.
	 * */
    private int score;
    
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
    gravity = false;
    score = 0;
  }
  
  
  /**
   * Returns a list of locations for all cells that form part of 
   * a collapsible set. This list may contain duplicates.
   * @return 
   *      list of locations for positions to be collapsed*/
  @Override
  public List<Position> determinePositionsToCollapse()
  {
	  List<Position> list = new ArrayList<Position>();
	  List<Position> temp = new ArrayList<Position>();
	  boolean empty = true;
	  int count = 0;
	  int height = super.getHeight();
	  int width = super.getWidth();
	  if(gravity)
	  {
		  for(int i = 0; i < height; i++)
		  {
			  for(int j = 0; j < width; j++)
			  {
				  if(super.getBlock(i, j) != null)
				  {
					  for(int k = i + 1; k < height; k++)
					  {
						  if(super.getBlock(k, j) == null)
						  {
							  Position p = new Position(k, j);
							  list.add(p);
						  }
						  else
						  {
							  break;
						  }
					  }
				  }
				  
			  }
		  }
		  gravity = false;
	  }
	  else
	  {
		  for(int i = 0; i < height; i++)
		  {
			  for(int j = 0; j < width; j++)
			  {
				  if(super.getBlock(i, j)!= null)
				  {
					  Position p =new Position(i, j);
					  temp.add(p);
					  empty = false;
					  if(super.getBlock(i, j).isMagic())
					  {
						  count++;
						  if(count >= 3)
						  {
							  gravity = true;
						  }
					  }
				  }
				  else
				  {
					  empty = true;
					  temp.removeAll(temp);
					  break;
				  } 
			  }
			  if(!empty)
			  {
				  list.addAll(temp);
				  score = (int) (score + Math.pow(2, count));  
			  }
		  }
	  }
    return list;
  }

  
  /**
   * Returns the current score.
   * @return
   *    the current score
   *  */
  @Override
  public int determineScore()
  {
    return score;
  }

}
