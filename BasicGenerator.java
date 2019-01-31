
package hw4;

import api.Generator;
import api.Position;
import api.Shape;
import java.util.Random;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 * @author Benny Ooi
 */
public class BasicGenerator implements Generator
{
  
  /**
   * Returns a new Shape instance according to this generator's strategy.
   * @param width
   *     the width of the game grid
   * @return 
   *     a new shape  
   * */
  @Override
  public Shape getNext(int width)
  {
	 Random rand = new Random();
	 int num = rand.nextInt(10); //output 0 to 9
	 int i = rand.nextInt(6); //output 0 to 5
	 int mid = width / 2;
	 boolean magic = false;
	 
	 if(num < 2)
	 {
		 magic = true;
	 }
	 else
	 {
		 magic = false;
	 }
	 
	 if(i == 0)
	 {
		 return new IShape(new Position(-2, mid), magic);
	 }
	 else if(i == 1)
	 {
		 return new JShape(new Position(-1, mid), magic);
	 }
	 else if(i == 2)
	 {
		 return new LShape(new Position(-1, mid + 1), magic);
	 }
	 else if(i == 3)
	 {
		 return new OShape(new Position(-1, mid), magic);
	 }
	 else if(i == 4)
	 {
		 return new SZShape(new Position(-1, mid), magic);
	 }
	 else
	 {
		 return new TShape(new Position(0, mid), magic);
	 }
	 
  }
}
