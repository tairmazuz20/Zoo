package mobility;
import mobility.Ilocatable;
import mobility.Point;
import java.lang.Math;

import animals.Animal;
import diet.Carnivore;


/**
* Describes Animals Movements And Locateability.
* 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
* @see Animal
*
*/
public abstract class Mobile implements Ilocatable {

	private Point location=new Point(0,0);
	private  double totalDistance = 0;
	
	/**
	 * Copy Constructor
	 * @param location1 Parameter to be copied.
	 */
	public Mobile(Point location1) {
			this.location.setpoint(location1);
	}
	/**
	 * Default Constructor
	 */
	public Mobile() {
	}
	
	
	
	/**
	 * Updates The Old Animal's Location to The New One.
	 * @param newLocation -Point Object To Be copied.
	 * @return true if point borders are legal,else false.
	 */
	public boolean setLocation(Point newLocation) {
		Point p1=new Point(0,0);
		if(p1.checkBoundries(newLocation)) {
			this.location.setpoint(newLocation);
			return true;
		}
		else {
			return false;
		}
	}
	
	
    /**
     * Calculates The Distance Between Two Points
     * @param p-Point object To Be calculated With.
     * @return The Distance Between current Location And Given Location.
     */
	public double calcDistance(Point p) {
		double dis=0; 
		dis+=Math.sqrt(Math.pow(p.getX()-getLocation().getX(),2)+Math.pow(p.getY()-getLocation().getY(),2));
		System.out.println("distance: "+dis);
		return dis; 
	}
	/**
	 * Adding Animals Travels meters
	 * @param distance-the result of calculating distance between 2 points.
	 */
	public void addTotalDistance(double distance) {
		this.totalDistance+=distance;
	}
	
	/**
	 * Moves the Animal According To the Given Point
	 * @param point-Point object to Move The Animals
	 * @return The Distance between The Points.
	 */
	public double move(Point point) {
		Point p1=new Point(0,0);
		if(p1.checkBoundries(point)) {
				double d=this.calcDistance(point);
				this.addTotalDistance(d);
				this.setLocation(point);
				return d;
			}
			return 0;
		
		}
	
	/**
	 * 
	 * @return total distance
	 */
	public double getTotalDistance() {
		return this.totalDistance;
	}
	/**
	 * Returns Current Animal's Location.
	 */
	public Point getLocation()
	{
		//System.out.println("location: "+location);
		return location;
		
	}
	
	

}

