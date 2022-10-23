package animals;
import java.awt.Panel;

import diet.Herbivore;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

/**
 *Elephant Class That Describes Elephant behavior.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *@see ChewAnimals
 */
public class Elephant extends ChewAnimals  {
	/**
	 * 
	 */
	private double trunkLength;
	/**
	 * 
	 */
	private double weight=500;
	/**
	 * 
	 */
	private Point location=new Point(50,90);
	/**
	 * 
	 */
	private Herbivore herb=new Herbivore();
	
	/**
	 * a constructor which gets 1 parameter: name and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name String ,name of the elephant
	 */
	public Elephant(String name) {
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(weight);
		this.setLocation(location);
		this.setDiet(new Herbivore()); 
	}
	
	public Elephant(int size,String color,ZooPanel panel,int speedH,int speedV)
	{
		
		super(size,color,panel,speedH,speedV);
		this.setWeight(this.weight);
		this.setDiet(new Herbivore());
		this.setLocation(location);


	}
	/**
	 *a constructor which gets 2 parameters: name and location and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
	 *
	 * @param name the name of the elephant
	 * @param location the location of the elephant
	 */
	public Elephant(String name,Point location) {
		
		super(name,location);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(weight);
		this.setDiet(new Herbivore());
		
	}
    /**
     * a constructor which gets 2 parameters: name and trunk length and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
     * 
     * @param name the name of the elephant
     * @param trunckLength the trunk length of the elephant
     */
	public Elephant(String name, double trunckLength)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.trunkLength=trunckLength;
		this.setDiet(new Herbivore());
		this.setLocation(location);
		this.setWeight(weight);
	}
	

	@Override
	/**
	 *  prints how the elephant makes sound when it chews.
	 */
	public void makeSound() {
		this.chew("Trumpets with joy while flapping its ears, then chews");
		
	}
	/**
	  Updates Elephant's Trunk Length According To the Given Parameter.
	 * @param d-double, Trunk length.
	 * @return true if trunk length is legal,else false.
	 */
	public boolean settrunkLength(double d) {
		if(d>=0.5 && d<=3)
		{
			this.trunkLength=d;
			MessageUtility.logSetter(this.getName(), "settrunkLength", d, true);
			return true;
		}
		MessageUtility.logSetter(this.getName(), "settrunkLength", d, false);
		return false;
		
	}



}
