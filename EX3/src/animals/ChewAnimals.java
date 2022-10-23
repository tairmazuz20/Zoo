package animals;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;


/**
* Describes Animals That Has Chewing Behavior.
* 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
* @see Elephant,Giraffe,turtle
*
*/
public abstract class ChewAnimals extends Animal {
	
	/**
	 * Default Constructor
	 */
	public ChewAnimals() {
		
	}
	/**
	 * Parameterized Constructor
	 * @param name-animal's name
	 * @param location-animal's location
	 */
	public ChewAnimals(String name,Point location) {
		
		super(name,location);
	}
	
	public ChewAnimals(int size,String color,ZooPanel panel,int speedH,int speedV)
	{
		
		super(size,color,panel,speedH,speedV);
	}
	
	/**
	 * Animal's Behavior
	 * @param behavior-String of Animal's Behavior
	 */
	public void chew(String behavior) {
		
		MessageUtility logSound=new MessageUtility();
		
		logSound.logSound(this.getName(),behavior);
	}
	
}
