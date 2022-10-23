package animals;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;



/**
* Describes Animals That Has Roar Behavior.
* 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
* @see Elephant,Giraffe,turtle
*
*/
public abstract class RoarAnimals extends Animal {
	
	/**
	 * Default Constructor
	 */
	public RoarAnimals(){
		
	}
	
	public RoarAnimals(int size,String color,ZooPanel pan,int speedH,int speedV)
	{
		
		super(size,color,pan,speedH,speedV);
	}

	/**
	 * Parameterized Constructor
	 * @param name-animal's name
	 * @param location-animal's location
	 */
	public RoarAnimals(String name,Point location){
		
		super(name,location);
	}
	
	/**
	 * Animal's Behavior
	 * @param behavior-String of Animal's Behavior
	 */
	public void roar(String behavior) {
		MessageUtility logSound=new MessageUtility();
		
		logSound.logSound(this.getName(),behavior);
	}

}
