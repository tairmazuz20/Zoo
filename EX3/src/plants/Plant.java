package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.Food;
import graphics.IDrawable;
import graphics.ZooFrame;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public abstract class Plant  implements IDrawable, IEdible, Ilocatable {
	
	/*
	public final static String PICTURE_PATH = "…";
	public void loadImages(String nm);
	public void drawObject (Graphics g);
	public String getColor();

*/
	/**
	 * 
	 */
	private double height;
	
	private final static String PICTURE_PATH="C:/Users/vivoy/Desktop/e1.zip_expanded/images/";

	private BufferedImage img;
	/**
	 * 
	 */
	private Point location;
	/**
	 * 
	 */
	private double weight;

	/**
	 * 
	 */
	private ZooPanel zooPanel;
	public Plant(ZooFrame f) {
		//super(f);
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGTABLE);
		return EFoodType.VEGTABLE;
	}

	/**
	 * @return
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return new Point(590,250);
	}

	/**
	 * @return
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
	
	public void loadImages(String nm)
	{
		if(this.getClass().getSimpleName().equals("Lettuce"))
		{
			try {
					this.img=ImageIO.read(new File(PICTURE_PATH+"lettuce.png"));
				} catch (IOException e) {
								
					System.out.println("Cant Load Image.");
				}
		}
		 if(this.getClass().getSimpleName().equals("Cabbage"))
			{
				try {
					this.img=ImageIO.read(new File(PICTURE_PATH+"cabbage.png"));
				} catch (IOException e) {
								
					System.out.println("Cant Load Image.");
				}
			}
		 if(this.getClass().getSimpleName().equals("Meat"))
		 {
				try {
					this.img=ImageIO.read(new File(PICTURE_PATH+"meat.gif"));
				} catch (IOException e) {
					System.out.println("Cannot Load Meat Image");
				}

		 }
							
	}
	
	public void drawObject(Graphics g)
	{
		if(img!=null)
			g.drawImage(img,590,250, 100,100,zooPanel);
	}
	public String getColor()
	{
		return "natural";
	}
	
}

