package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

public interface IDiet {
	/**
	 * Checks If Animal Can Eat The Given Parameter.
	 * @param food-EFoodType, represents animal's food
	 * @return true if the animal can eat, else false.
	 */
	public boolean canEat(EFoodType food);
	/**
	 * Checks if animal can eat given food and returns the weight the animal gained.
	 * @param  animal: animal from type Animal to Access Animal's Weight.
	 * 		   food: food from type IEdible to feed the animal
	 * @return how much weight the animal gained throughout eating.
	 * @see IEdible
	 */

	public double eat(Animal animal, IEdible food);

}
