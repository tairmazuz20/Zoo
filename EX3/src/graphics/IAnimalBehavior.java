package graphics;

import diet.IDiet;

/**
 * A class that defines IAnimalBehavior 
 * @version 1.1 4 April 2021
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *    
 */
public interface IAnimalBehavior {
	public String getAnimalName();
	public int getSize();
	public void eatInc();
	public int getEatCount();
	public boolean getChanges();
	public void setChanges(boolean state);
	public void setSuspended();
	public void setResumed();
}
