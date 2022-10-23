package graphics;

import java.awt.Graphics;

/**
 * A class that defines IDrawable 
 * @version 1.1 4 April 2021
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *    
 */
public interface IDrawable {
	public final static String PICTURE_PATH="C:\\Users\\vivoy\\Desktop\\תאיר\\Java Peoject\\images";
	public void loadImages(String nm);
	public void drawObject(Graphics g);
	public String getColor();
	
}
