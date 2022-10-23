package animals;
import utilities.MessageUtility;
import diet.Carnivore;
import diet.Herbivore;
import food.IEdible;
import graphics.ZooPanel;
import food.EFoodType;
import mobility.Point;


/**
 * a class which will build new objects from turtle type.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *@see ChewAnimals
 *
 */
public class Turtle extends ChewAnimals  {
	
	/**
	 * 
	 */
	private double weight =1;
	/**
	 * 
	 */
	private Point p=new Point(80,0);
	/**
	 * 
	 */
	private int age=1;
	/**
	 *  a constructor which gets 1 parameter: name and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name the name of the  turtle
	 */
    public Turtle(String name){
    	
    	MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(this.weight);
		this.setLocation(p);
		this.setDiet(new Herbivore());
	}
    
    public Turtle(int size,String color,ZooPanel panel,int speedH,int speedV)
	{
		
		super(size,color,panel,speedH,speedV);
		this.setLocation(p);
		
		this.setWeight(this.weight);
		
		this.setDiet(new Herbivore());

	}
    /**
     * a constructor which gets 2 parameters: name and location and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
     * 
     * @param name the name of the turtle
     * @param p1 the location of the turtle
     */
	public Turtle(String name,Point p1)
	{
		super(name,p1);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(this.weight);
		this.setDiet(new Herbivore());
	}
	/**
	 * a constructor which gets 2 parameters: name and age and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
	 * 
	 * @param name the name of the turtle
	 * @param age the age of the turtle
	 */
	public Turtle(String name,int age)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setAge(age);
		this.setWeight(weight);
		this.setDiet(new Herbivore());
	}
	/**
	 * Updates The turtle's age according to the given parameter.
	 * @param age -int, represents turtle's age 
	 * @return true if the age is legal,else returns false.
	 */
	public boolean setAge(int age) {
		
		if (age<0||age>500) {
			
			MessageUtility setter=new MessageUtility();
			
			setter.logSetter(this.getName(), "setAge", age, false);
			
			return false;
		}
		else
			
		this.age=age;
		
		MessageUtility setter=new MessageUtility();
		
		setter.logSetter(this.getName(), "setAge", this.age, true);	
		
		return true;
	}
	@Override
	/**
	 * prints how the turtle makes sound when it chews.
	 */
	public void makeSound() {
		
		chew("Retracts its head in then eats quietly");
	}

	
}	