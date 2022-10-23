package animals;
import java.util.Random;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import utilities.MessageUtility; 
import graphics.*;
/**
 * Lion Class Represents Lion behavior.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *@see RoarAnimals
 */
public class Lion extends RoarAnimals{
	/**
	 * 
	 */
	private int scarCount=0;
	/**
	 * 
	 */
	private double weight=408.2;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Point startLocation=new Point(20,0);
	/**
	 * 
	 */
	private Carnivore carn=new Carnivore();
	
	
	/**
	 *  a constructor which gets 1 parameter: name and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name the name of the animal
	 */
	public Lion(String name) {
		
		
		MessageUtility.logConstractor("Animal", name);
		
		this.setName(name);
		
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		
		this.setLocation(startLocation);
		
		this.setWeight(this.weight);
		
		this.setDiet(new Carnivore());
	}
	
	/**
	 *  a constructor which gets 2 parameters: name and location and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
	 *
	 * @param name the name of the lion 
	 * @param location the location of the lion
	 */
    public Lion(String name,Point location) {
		
		super(name,location);
		
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		
		this.setWeight(weight);
		
		this.setDiet(new Carnivore());
		
		this.setLocation(startLocation);
	}
    
    public Lion(int size,String color,ZooPanel pan,int speedH,int speedV)
	{
		
		super(size,color,pan,speedH,speedV);
		this.setLocation(startLocation);
		
		this.setWeight(this.weight);
		
		this.setDiet(new Carnivore());

	}
	
	/**
	 * function that returns the count of the scars the lion object has.
	 * 
	 * @return returns the scar's count of the lion object.
	 */
	public int getScarCount() {
		
		MessageUtility.logGetter(this.getName(), "getScarCount", this.scarCount);
		return this.scarCount;
	}
	
	
	
	@Override
	/**
	 * a function that prints how the lion makes sound when it roars.
	 */
	public void makeSound() {
		
		this.roar("Roars, then stretches and shakes its mane");
	}
	
	
	/**
	 *Updates The Lion's Weight & Scar amount after Eating.
	 * @param var   IEdible, represents certain food.
	 * @return true if lion is allowed to eat var,else returns false.
	 */
	 public boolean eat(IEdible var) {
	
		Random rand=new Random();
		int chance=rand.nextInt(0,2);
		double weight=this.getDiet().eat(this, var);
		if( weight>0) 
		{	
			if(chance==1)
			{
				
			this.setWeight(weight+this.getWeight());
			this.setScar(this.getScarCount()+1);
			this.makeSound();
			MessageUtility.logBooleanFunction(this.getName(), "eat", var, true);
			return true;
			}
			else if(chance==0)
			{
				this.setWeight(weight+this.getWeight());
				this.makeSound();
				MessageUtility.logBooleanFunction(this.getName(), "eat", var, true);
			}
		}	
		else
		{
			MessageUtility.logBooleanFunction(this.getName(), "eat", var, false);
			return false;
		}
		return false;
	}
    /**
     *Calculates How much weight & Scars The Lion Gains After Eating.
     * @param animal Animal type
     * @param food IEdible food type.
     * @return returns the calculation of the weight according to the given animal class.
     */
	public double eat(Animal animal, IEdible food)
	{
		Random rand=new Random();
		int probability=rand.nextInt(0,2);
		 
			if(this.getDiet().canEat(food.getFoodtype())) {
				
				if (probability==1)
				{
					this.setScar(this.getScarCount()+1);
					this.makeSound();
			
					return this.getWeight()*0.1;
				}
				else
				{
					this.makeSound();
			
					return this.getWeight()*0.1;
				}
			
		}
		return 0;
	}
/**
 * changes the number of scars of the object to the given number of scars.
 * @param scar -number of the lion's scars 
 * @return returns true if the scars of the object were changed to the given number of scars else returns false.
 */
public boolean setScar(int scar)
{
	this.scarCount=scar;
	MessageUtility.logSetter(this.getName(), "setScar", scar, true);
	return true;
}
/**
 * returns the food type the lion can eat
 * 
 * @return returns the food type that the lion class can eat .
 */
public EFoodType getFoodtype() {
		
		MessageUtility getter=new MessageUtility();
		
		getter.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
		
		return EFoodType.NOTFOOD;
	}




	
}
