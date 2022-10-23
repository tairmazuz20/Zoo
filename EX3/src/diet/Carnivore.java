package diet;
import java.util.Random;

import animals.Animal;
import animals.Bear;
import animals.Giraffe;
import animals.Lion;

import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;



/**
 * Defines Animals That Eats Only Meat.
 * @version ....
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 * @see Lion 
 */

public  class Carnivore  implements IDiet {

	
	/**
	 * Default Constructor
	 */
	public Carnivore() {
		
	}
	

	
	/**
	 * Checks If Food Type Given Is Legal For carnivore To eat.
	 * @parameter EFoodType food- Gets an Enum-EFoodType Parameter that Mentions Any Kind Of Animal's Food Type.
	 * @return If Food Type Is Meat Returns True, Else False.
	 * @see EFoodType
	 */
	@Override
	public boolean canEat(EFoodType food) {
		
		if (food==EFoodType.MEAT) {
			
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
	@Override
	public double eat(Animal animal, IEdible food)
	{
		
			if(this.canEat(food.getFoodtype())) {
				animal.eatInc();
				return (animal.getWeight()*0.1);
				
			}
			else
			
				return 0;
		
	}
	
	
	
	
	
	}
	
	
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


