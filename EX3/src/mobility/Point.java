package mobility;

import animals.Animal;

/**
* Describes Point Object.
* 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
* @see Mobile
*
*/
public class Point {
	private  int x=0;
	private  int y=0;
	private final int minX=0,minY=0;
	private final int maxX=2200,maxY=667;
	
	/**
	 * Copy constructor
	 * @param p-Point Object To Be Copied
	 */
	public Point(Point p) {
		if(this.checkBoundries(p)) {
			this.x=p.x;
			this.y=p.y;
		}
		
	}
	/**
	 * Returns Point String Representation. 
	 */
	public String toString() {
		return "("+this.getX()+","+this.getY()+")";
	}
	/**
	 * Parameterized Constructor
	 * @param x-x coordinate
	 * @param y-y coordinate
	 */
	public Point(int x,int y) {
			this.x=x;
			this.y=y;
	}
	/**
	 * returns Point object
	 * @return Point Object
	 */
	public Point getPoint() {
		return new Point(x,y);
	}
	
	/**
	 * Change Point Values.
	 * @param p-new Point to be copied
	 * @return true if point is in boundaries, else-false.
	 */
	public boolean setpoint(Point p) {
		if(p.checkBoundries(p))
		{
			this.x=p.getX();
			this.y=p.getY();
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
			Point p1=new Point(1,3);
		
	}
	/**
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		 return this.x;
	}
	/**
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		 return this.y;
	}
	public final int getMinX() {
		return this.minX;
	}
	
	/**
	 * 
	 * @return Minimum Y Value Allowed
	 */
	public final int getMinY() {
		return this.minY;
	}
	/**
	 * 
	 * @return Maximum X Value Allowed
	 */
	public final int getMaxX() {
		return this.maxX;
	}
	/**
	 * 
	 * @return Maximum Y Value Allowed
	 */
	public final int getMaxY() {
		return this.maxY;
	}
	/**
	 * checks if Point Coordinates Are In Borders.
	 * @param p-Point Object to Check If In Borders.
	 * @return true if Point Value Are In Borders,else False.
	 */
	public static boolean checkBoundries(Point p) {
		Point p1=new Point (0,0);
		if((p.x>=p1.getMinX()&&p.x<=p1.getMaxX())&&(p.y>=p1.getMinY()&&p.y<=p1.getMaxY())) {
			return true;
		}
		
		return false;
	}


	

}
