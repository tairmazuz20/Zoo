package mobility;

import mobility.Point;


/**
 * Defines Animals Locateability.
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 * @see Elephant,Turtle,Giraffe
 */
public interface Ilocatable {
	/**
	 * returns Current Animal Location.
	 * @return
	 */
	Point getLocation();
	
	/**
	 * Updates Old Location to a new one.
	 * @param newLocation -of Type Point, New Animal's Location
	 * @return true, if newLocation coordinates are Legal.
	 */
	boolean setLocation(Point newLocation);

}
