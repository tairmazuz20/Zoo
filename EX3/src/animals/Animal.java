package animals;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import diet.Carnivore;
import diet.IDiet;
import mobility.Point;
import plants.Cabbage;
import mobility.Mobile;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;

import graphics.ZooFrame;
import graphics.ZooPanel;
import diet.IDiet;
import utilities.MessageUtility;


/**
 * Describes The Behavior That All The Animals Have.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *
 */
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior,Runnable {

	private String name;
	private  double weight=0;
	private IDiet diet = null;
	
	private boolean dead=false;
	
	private final int EAT_DISTANCE = 10;
	private int size,new_x,new_y;
	private String color;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private Thread thread;
	protected boolean threadSuspended= false;
	private int dis=5;
	private int x_dir=1;
	private int y_dir=1;
	private int eatCount;
	private ZooPanel panel;
	private BufferedImage img1, img2;
	private static final int mainPanelWidth=2200;
	private static final int mainPanelHeight=667;
	public final static String PICTURE_PATH = "C:/Users/vivoy/Desktop/e1.zip_expanded/images/";
	
	/**
	 *  a constructor which gets 2 parameters: name and location ,and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name the name of the animal
	 * @param location the location of the animal
	 */
	public Animal(String name, Point location)
	{
		super(location);
		MessageUtility.logConstractor("Animal",name);
		loadImages(this.color);
		this.setName(name);
	}
	
	public Animal(int size,String color,ZooPanel pan,int speedH,int speedV) 
	{
		
		this.thread=new Thread(this);
		this.setHorSpeed(speedH);
		this.setVerSpeed(speedV);
		this.size=size;
		this.color=color;
		this.setWeight(this.weight);
		this.panel=pan;
		thread.start();
	}

	
	
	public void setColor(String color)
	{
		this.color=color;
		
	}
	public void setSize(int size)
	{
		this.size=size;
		
	}
	public String getColor()
	{
		return this.color;
		
	}
	public int getSize()
	{
		return this.size;
		
	}
	
	/**
	 * a default constructor
	 */
	public Animal() 
	{
		loadImages(this.color);

	}
	/**
	 *returns an object which implements the interface Idiet. 
	 * 
	 * @return returns an object which implements the interface Idiet. 
	 */
	public IDiet getDiet() {
		return diet;
	}
	
	/**
	 * abstract function describes the behavior of each animal.
	 */
	public abstract void makeSound();
	
	/**
	 *  returns animal's Food Type.
	 * @return animal's food type from EFoodtype .
	 */
    public EFoodType getFoodtype() {
		
		
		MessageUtility getter=new MessageUtility();
		
		
		getter.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);
		
		
		return EFoodType.MEAT;
	}
		 
	/**
	 
	 * @return the name of  animal.
	 */
	public String getName() {
		
		
		//MessageUtility getter=new MessageUtility();
		
		
		//getter.logGetter(this.name, "getName", this.name);
		
		
		return this.name;
	}
	
	/**
	    changes the object name with the given parameter. 
	 * @param name the name of the animal
	 * @return returns true if the object's name was changed to the given parameter else will return false.
	 */
	public boolean setName(String name) {
		
		
		this.name=name;
		
		
		MessageUtility setter=new MessageUtility();
		
		
		setter.logSetter(this.name, "setName", this.name, true);
		
		
		return true;
	}
	
	/**
	 
	 * @return returns the weight of the animal object we are working on.
	 */
	public double getWeight()
	{
		
		MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
		
		return this.weight;
	}
	
	/**
	 *  returns true if succeeded with changing the animal weight to the given parameter else returns false.
	 * @param weight the weight of the animal.
	 * @return returns true if the animal weight of the object was changed to the given parameter else returns false.
	 */
	public boolean setWeight(double weight) {
		
		if (weight>0)
		{
			this.weight=weight;
		
			return true;
		}
		return false;
	}
	/**
	 * Returns a string that describes animal object
	 */
	public String toString(){
		
		
		return "["+this.getClass().getSimpleName()+"]"+this.getName()+" "+this.getColor()+" "+this.getSize();
	}
	
	
public String toString2(){
		
		
		return "["+this.getClass().getSimpleName()+"]"+" ,"+"Size:"+this.getSize()+","+"Color: "+this.getColor();
	}
	
	/**
	 * function which returns the type of the animal object.
	 * 
	 * @return the type of the object we are working with.
	 */
	public Object getType() {
		
		return this.getClass();
	}
	
	/**
	 * moves the location of the object ,to a different location  
	 * and returns current calculation .
	 * @param point the point of the animal it's a new location 
	 * @return returns the calculation of the distance the object did this time, but not the total distance from all the times.
	 */
	public  double move(Point point)
	{ 
		Point p1=new Point(0,0);
		
		if(p1.checkBoundries(point))
		{
			this.addTotalDistance(this.calcDistance(point)); 
			this.setLocation(point);
			point.setpoint(point);
			
		    this.setWeight(this.getWeight()-(this.calcDistance(point)*this.getWeight()*0.00025));
		   
		    MessageUtility.logBooleanFunction(this.getName(), "move", point, true);
		   
		    return this.calcDistance(point);
		}
		 MessageUtility.logBooleanFunction(this.getName(), "move", point, false);
			return 0;
		
	}
	/**
	 * receives a value from IEdible -a type of food if the object can eat it the function return true else 
	 * returns false.
	 * 
	 * @param var   an IEdible type object 
	 * @return returns true if the object can eat the food type else returns false.
	 * @see IEdible
	 */
	public boolean eat(IEdible var) {
		double weight=diet.eat(this, var);
		if( weight>0) 
		{
			
			this.setWeight(weight+this.getWeight());
			this.makeSound();
			MessageUtility.logBooleanFunction(this.getName(), "eat", var, true);
			this.eatInc();
			return true;
			
		}
		MessageUtility.logBooleanFunction(this.getName(), "eat", var, false);
		return false;
	}
	/**
	 * 
	 * Updates Animal's Diet.
	 * @param diet -Object That Implement IDiet Interface
	 * @return true if succeeded changing the parameter diet of the object to the given parameter
	 * else false..
	 */
	public  boolean setDiet(IDiet diet) {
		this.diet=diet;
		return true;
	}
		
	
	
	public void loadImages(String nm)
	{
		
		final String [] links= {"_b_1.png","_b_2.png","_n_1.png","_n_2.png","_r_1.png","_r_2.png"};
		String animalType=this.getClass().getSimpleName();
		if(Arrays.asList("Red","Natural","Blue").contains(nm) || Arrays.asList("red","natural","blue").contains(nm))
		{
			
			if(animalType.equals("Lion"))
			{
				switch (nm)
				{
					
						case "Red","red":
								{
								
								try {
									this.img1=ImageIO.read(new File(PICTURE_PATH+"lio"+links[4]));
									this.img2=ImageIO.read(new File(PICTURE_PATH+"lio"+links[5]));
								} catch (IOException e) {
									
									System.out.println("Cant Load Image.");;
								}
								
								};break;
						case "Blue","blue":{
							try {
								this.img1=ImageIO.read(new File(PICTURE_PATH+"lio"+links[0]));
								this.img2=ImageIO.read(new File(PICTURE_PATH+"lio"+links[1]));
								
							} catch (IOException e) {
								
								System.out.println("Cant Load Image.");;
							}
							
							};break;
						case "Natural","natural":{
							try {
								this.img1=ImageIO.read(new File(PICTURE_PATH+"lio"+links[2]));
								this.img2=ImageIO.read(new File(PICTURE_PATH+"lio"+links[3]));
								
							} catch (IOException e) {
								
								System.out.println("Cant Load Image.");;
							}
							
							};break;
							
						
				}
			}
			if(animalType.equals("Bear"))
			{
				switch(nm)
				{
				case "Red","red":
				{
				
				try {
					this.img1=ImageIO.read(new File(PICTURE_PATH+"bea"+links[4]));
					this.img2=ImageIO.read(new File(PICTURE_PATH+"bea"+links[5]));
					
				} catch (IOException e) {
					
					System.out.println("Cant Load Image.");;
				}
				
				};break;
				case "Blue","blue":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"bea"+links[0]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"bea"+links[1]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");
					}
					
					};break;
				case "Natural","natural":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"bea"+links[2]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"bea"+links[3]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");
					}
			
			};break;
			
				}
			
			}
			
			if(animalType.equals("Elephant"))
			{
				switch (nm)
				{
				case "Red","red":
				{
				
				try {
					this.img1=ImageIO.read(new File(PICTURE_PATH+"elf"+links[4]));
					this.img2=ImageIO.read(new File(PICTURE_PATH+"elf"+links[5]));
					
				} catch (IOException e) {
					
					System.out.println("Cant Load Image.");;
				}
				
				};break;
				case "Blue","blue":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"elf"+links[0]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"elf"+links[1]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");
					}
					
					};break;
				case "Natural","natural":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"elf"+links[2]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"elf"+links[3]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");;
					}
			
			};break;
			
				}
			}
			
			if(animalType.equals("Turtle"))
			{
				switch (nm)
				{
				case "Red","red":
				{
				
				try {
					this.img1=ImageIO.read(new File(PICTURE_PATH+"trt"+links[4]));
					this.img2=ImageIO.read(new File(PICTURE_PATH+"trt"+links[5]));
					
				} catch (IOException e) {
					
					System.out.println("Cant Load Image.");;
				}
				
				};break;
				case "Blue","blue":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"trt"+links[0]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"trt"+links[1]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");;
					}
					
					};break;
				case "Natural","natural":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"trt"+links[2]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"trt"+links[3]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");;
					}
					
			};break;
			
				}
			}
			
			if(animalType.equals("Giraffe"))
			{
				switch (nm)
				{
				
				case "Red","red":
				{
				
				try {
					this.img1=ImageIO.read(new File(PICTURE_PATH+"grf"+links[4]));
					this.img2=ImageIO.read(new File(PICTURE_PATH+"grf"+links[5]));
					
				} catch (IOException e) {
					
					System.out.println("Cant Load Image.");
				}
				
				};break;
				case "Blue","blue":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"grf"+links[0]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"grf"+links[1]));
						
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");
					}
					
					};break;
				case "Natural","natural":{
					try {
						this.img1=ImageIO.read(new File(PICTURE_PATH+"grf"+links[2]));
						this.img2=ImageIO.read(new File(PICTURE_PATH+"grf"+links[3]));
					} catch (IOException e) {
						
						System.out.println("Cant Load Image.");
					}
				  }		
				}		
			}
		}
	}
	
	public void drawObject (Graphics g)
	{
		if(this.x_dir==1)
		{
			g.drawImage(img1, this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10,this.getSize()/2,this.getSize(),this.panel);
		}
		else
			g.drawImage(img2, this.getLocation().getX(), this.getLocation().getY()-this.getSize()/10,getSize()/2 ,getSize(),this.panel);
	}
	public void setX_dir(int n) {
		this.x_dir=n;
	}
	public int getX_dir() {
		return x_dir;
	}
	public void setY_dir(int n) {
		this.y_dir=n;
	}
	public int getY_dir() {
		return y_dir;
	}
	public String getAnimalName()
	{
		return this.getClass().getSimpleName();
	}
	public void eatInc()
	{	
			this.eatCount+=1;	
	}
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public  boolean getChanges()
	{
		return this.coordChanged;
	}
	public void setChanges(boolean state)
	{	
		this.coordChanged=state;
		
	}
	public boolean getThreadSuspended() {
		return threadSuspended;
	}
	
	public  void setSuspended() {
		threadSuspended=true;
	}
	public  void setResumed() {
		threadSuspended=false;
		synchronized(this.thread) {
	   			this.thread.notifyAll();	
		}
	}

    @Override
    public void run() {
    	
		while (!dead) {
			try {
				this.thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			if(threadSuspended==true) {
			synchronized(this.thread) {
				try {
					System.out.println("wait");
					this.thread.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
			}
    	
    	if(1250<=getLocation().getX()||getLocation().getX()<=0) {
    		x_dir=x_dir*-1;
    		
		}
    	if(450<=getLocation().getY()||getLocation().getY()<=0) {
    		y_dir=y_dir*-1;  		
		}
    	new_x=getLocation().getX()+horSpeed*x_dir;
    	new_y=getLocation().getY()+verSpeed*y_dir;
    	this.setLocation(new Point(new_x, new_y));
        this.panel.repaint();
    }
		
	}
	
	public int getHorSpeed() {
		return horSpeed;
	}

	public void setHorSpeed(int horSpeed) {
		this.horSpeed = horSpeed;
	}

	public int getVerSpeed() {
		return verSpeed;
	}

	public void setVerSpeed(int verSpeed) {
		this.verSpeed = verSpeed;
	}
	public void setThreadDead() {
		thread.stop();
		dead=true;
	}


    
}