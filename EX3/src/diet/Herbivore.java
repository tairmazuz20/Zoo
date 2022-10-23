package diet;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import food.EFoodType;
import food.IEdible;

/**
 * Defines Animals That Eats  Vegtables.
 * @version ....
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 * @see Elephant,Turtle,Giraffe
 */
public  class Herbivore   implements IDiet {

	
	/**
	 * Default Constructor
	 */
	public Herbivore() {
		
	}
	

	/**
	 * Checks If Food Type Given Is Legal For carnivore To eat.
	 * @parameter EFoodType food- Gets an Enum-EFoodType Parameter that Mentions Any Kind Of Animal's Food Type.
	 * @return If Food Type Is Vegtable Returns True, Else False.
	 * @see EFoodType
	 */
	@Override
	public boolean canEat(EFoodType food) {
		
		
		if(food==EFoodType.VEGTABLE) {
			
			
			return true;
		}
		
		return false;
	}
	

	
	/**
	 * Checks if animal can eat given food and returns the weight the animal gained.
	 * @param  animal: animal from type Animal to Access Animal's Weight.
	 * 		   food: food from type IEdible to feed the animal
	 * @return how much weight the animal gained throughout eating.
	 * @see IEdible
	 */
	public double eat(Animal animal, IEdible food)
	{
			if(this.canEat(food.getFoodtype()))
			{
				animal.eatInc();
				return (animal.getWeight()*0.07);
			}
			else
				return 0;
	}
	
			
	

}
