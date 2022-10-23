package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;

import java.util.List;
import java.awt.Insets;


/**
 * Opens a window of choosing an animal and instancing it according to the user's selection.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *
 */

public class AddAnimalDialog extends JDialog implements ActionListener{

	
	private static Animal animal;
	private String type;
	private int speedH;
	private int speedV;
	private JTextField txt1=new JTextField();
	private JTextField txtH=new JTextField();
	private JTextField txtV=new JTextField();
	private static final String[] colors= {"Red","Blue","Natural"};
	private  final JCheckBox [] AnimalColor=new JCheckBox[colors.length];
	private static final String[] Animals= {"Lion","Bear","Giraffe","Turtle","Elephant"};
	private  final JCheckBox [] TypeAnimal=new JCheckBox[Animals.length];
	private JButton submit=new JButton("Submit");
	private int siz2;
	String sizeText;
	JLabel msg=new JLabel("Please Select Type Of Animal:");
	JLabel msg1=new JLabel("Please Select Animal's Color:");
	JLabel lblNewLabel = new JLabel("Insert horizontal speed");
	JLabel lblNewLabel1 = new JLabel("Insert horizontal speed");
	private JPanel ColorPanel=new JPanel();
	private JPanel AnimalPanel=new JPanel();
	private JPanel TextPanel=new JPanel();
	private JPanel SpeedPanel=new JPanel();
	private JButton done=new JButton("Add Animal");
	JPanel DoneButton=new JPanel();
	private final ButtonGroup Colors=new ButtonGroup();
	private ZooPanel zooPanel;
	private ZooPanel panel;
	private  List<Animal>animals;
	private ZooFrame zFrame;
	//private JButton moveButton;
	private JTextField textField;
	
	
/**
 * constructor the responsible of openning a new window that display the options of selecting
 * different animals .
 * @param zf- Zoo Frame object in order to use its functionality.
 * @param moveButton- JButton to enable using after adding an animal to the zoo.
 */
	
	public AddAnimalDialog(ZooFrame zf,ZooPanel pan)
	{
		this.zFrame=zf;
		//this.moveButton=moveButton;
		zooPanel=new ZooPanel(zFrame);
		this.setBounds(400, 100, 467, 321);
		getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		done.setEnabled(false);
		txt1.setPreferredSize(new Dimension(250,40));
		txt1.setFont(new Font("Consolas",Font.BOLD,18));
		//textField.setPreferredSize(new Dimension(250,40));
		//textField.setFont(new Font("Consolas",Font.BOLD,18));
		this.getFieldText(textField);
		this.panel=pan;
		this.getFieldText(txt1);
		getContentPane().add(ColorPanel,BorderLayout.PAGE_END);
		ColorPanel.add(msg1,BorderLayout.NORTH);
		//getContentPane().add(lblNewLabel,BorderLayout.CENTER);
		msg1.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		msg1.setForeground(Color.DARK_GRAY);
	    SpeedPanel.setBackground(Color.LIGHT_GRAY);
	    getContentPane().add(SpeedPanel,BorderLayout.CENTER);
	    GridBagLayout gbl_SpeedPanel = new GridBagLayout();
	    gbl_SpeedPanel.columnWidths = new int[]{114, 250, 114, 250, 0};
	    gbl_SpeedPanel.rowHeights = new int[]{40, 0};
	    gbl_SpeedPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_SpeedPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	    SpeedPanel.setLayout(gbl_SpeedPanel);
	    GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	    gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel.gridx = 0;
	    gbc_lblNewLabel.gridy = 0;
	    SpeedPanel.add(lblNewLabel, gbc_lblNewLabel);
	    GridBagConstraints gbc_txtH = new GridBagConstraints();
	    gbc_txtH.insets = new Insets(0, 0, 0, 5);
	    gbc_txtH.gridx = 1;
	    gbc_txtH.gridy = 0;
	    SpeedPanel.add(txtH, gbc_txtH);
	    txtH.setPreferredSize(new Dimension(250,40));
	    
	    txtH.addFocusListener(new FocusAdapter() {
	    	public void focusLost(FocusEvent e) {

	    		speedH = Integer.parseInt( txtH.getText());
	    		 if (speedH>10||speedH<1)
	    		 	  {
	    	    	   JOptionPane.showMessageDialog(null, " ERORR \n Enter number between 1-10\n");
	    	   	      }
	    		
	    		
	    	}
	    });
	    txtH.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyTyped(KeyEvent e) {
	    		char c = e.getKeyChar();
	    		if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	    			e.consume();  // if it's not a number, ignore the event
	    		}
	       }
	    });
	    GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
	    gbc_lblNewLabel1.anchor = GridBagConstraints.WEST;
	    gbc_lblNewLabel1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel1.gridx = 2;
	    gbc_lblNewLabel1.gridy = 0;
	    SpeedPanel.add(lblNewLabel1, gbc_lblNewLabel1);
	    txtV.setPreferredSize(new Dimension(250,40));
	    GridBagConstraints gbc_txtV = new GridBagConstraints();
	    gbc_txtV.anchor = GridBagConstraints.NORTHWEST;
	    gbc_txtV.gridx = 3;
	    gbc_txtV.gridy = 0;
	    SpeedPanel.add( txtV, gbc_txtV);
	    txtV.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {

					speedV = Integer.parseInt( txtV.getText());
					 if (speedV>10||speedV<1)
					 	  {
				    	   JOptionPane.showMessageDialog(null, " ERORR \n Enter number between 1-10\n");
				   	      }
					
					
				}
			});
	    txtV.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume();  // if it's not a number, ignore the event
					}
	       }
			});
		
		// Adding CheckBoxes to The ColorPanel.
		for(int i=0;i<colors.length;++i)
		{	
			
			AnimalColor[i]=new JCheckBox(colors[i]);
			AnimalColor[i].setFocusable(false);
			AnimalColor[i].setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
			AnimalColor[i].setBackground(Color.LIGHT_GRAY);
			AnimalColor[i].setForeground(Color.DARK_GRAY);
			this.AnimalColor[i].addActionListener(this);

			this.ColorPanel.setLayout(new BoxLayout(ColorPanel,BoxLayout.PAGE_AXIS));
			this.ColorPanel.add(AnimalColor[i]);
		}
		ColorPanel.setBackground(Color.LIGHT_GRAY);
		// Adding Label Above CheckBoxes
		//this.add(msg,BorderLayout.NORTH);

		this.AnimalPanel.add(msg,BorderLayout.WEST);
		msg.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		msg.setForeground(Color.DARK_GRAY);
		
		
		//Adding Animal Types As CheckBoxes.
		for (int i=0;i<Animals.length;++i)
		{
			
			
			TypeAnimal[i]=new JCheckBox(Animals[i]);
			TypeAnimal[i].setFocusable(false);
			TypeAnimal[i].setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
			TypeAnimal[i].setForeground(Color.DARK_GRAY);
			TypeAnimal[i].setBackground(Color.LIGHT_GRAY);
			TypeAnimal[i].addActionListener(this);
			
			this.AnimalPanel.setLayout(new BoxLayout(AnimalPanel,BoxLayout.PAGE_AXIS));
			this.AnimalPanel.add(TypeAnimal[i]);
			AnimalPanel.setBackground(Color.LIGHT_GRAY);
			getContentPane().add(AnimalPanel);
		}
		

	

		 
		TextPanel.add(txt1,BorderLayout.AFTER_LAST_LINE);
		TextPanel.add(submit,BorderLayout.AFTER_LAST_LINE);
		TextPanel.setBackground(Color.LIGHT_GRAY);
		
		getContentPane().add(TextPanel,BoxLayout.LINE_AXIS);
		//DoneButton.setBackground(Color.LIGHT_GRAY);
		this.DoneButton.add(done);
		getContentPane().add(DoneButton);
		this.doneButton();
		done.addActionListener(this);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.pack();
		this.setVisible(true);

	
	}
	private String getFieldText(JTextField text)
	{

	
		this.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizeText=txt1.getText();
				
				try {
					siz2=Integer.parseInt(sizeText);
					done.setEnabled(true);
					if(siz2<50 || siz2>300)
					{
						JOptionPane.showMessageDialog(text, "Invalid Size,Please Select A Number Between 50-300.","Size Error",JOptionPane.ERROR_MESSAGE);
						
						
					}
				}catch(Exception x) {JOptionPane.showMessageDialog(text, "Please Enter Integer Number.","Input Error",JOptionPane.ERROR_MESSAGE);
				;};
				
			}
			
		});
		return sizeText;
	}
	
	/**
	 * set the state of the icons.
	 */
	private void setCheckIcons()
	{
		TypeAnimal[0].setEnabled(true);
		TypeAnimal[1].setEnabled(true);
		TypeAnimal[2].setEnabled(true);
		TypeAnimal[3].setEnabled(true);
		TypeAnimal[4].setEnabled(true);
		
		AnimalColor[0].setEnabled(true);
		AnimalColor[1].setEnabled(true);
		AnimalColor[2].setEnabled(true);
		
		AnimalColor[0].setSelected(false);
		AnimalColor[1].setSelected(false);
		AnimalColor[2].setSelected(false);
		
		TypeAnimal[0].setSelected(false);
		TypeAnimal[1].setSelected(false);
		TypeAnimal[2].setSelected(false);
		TypeAnimal[3].setSelected(false);
		TypeAnimal[4].setSelected(false);
		
		//this.moveButton.setEnabled(true);
		txt1.setText(null);
		done.setEnabled(false);
		
	}
	/**
	 * getting the necsery information after user's selection.
	 */
	private void doneButton()
	{
		//this.done.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.DARK_GRAY));
		this.done.setPreferredSize(new Dimension(250,70));
		this.done.setForeground(Color.black);
		//this.done.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
	
	}
	/**
	 * overriding ActionLisener method in order to add events to the buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		String color = null;
		/*
		if(AnimalColor[0].isSelected()==false && AnimalColor[1].isSelected()==false && AnimalColor[2].isSelected()==false)
		{
			JOptionPane.showMessageDialog(this, "Must Select 1 Color!","No Color Choosen",JOptionPane.ERROR_MESSAGE);
		}
		
		
		if(TypeAnimal[0].isSelected()==false && TypeAnimal[1].isSelected()==false && TypeAnimal[2].isSelected()==false && TypeAnimal[3].isSelected()==false && TypeAnimal[4].isSelected()==false )
		{
			JOptionPane.showMessageDialog(this, "Must Select 1 Animal Type!","No Animal Was Choosen",JOptionPane.ERROR_MESSAGE);
		}
		*/
		if(this.zooPanel.getAnimalList().size()>10)
		{
			JOptionPane.showMessageDialog(this, "Cannot Add More Than 10 this.zooPanel.getAnimalList().","OverFlow",JOptionPane.ERROR_MESSAGE);
			this.zooPanel.getAnimalList().remove(10);
		}
		
		
		for (int i=0; i<this.AnimalColor.length;++i)
		{
			if(AnimalColor[i].isSelected())
			{
				if(AnimalColor[i].isEnabled());
				{
					
					AnimalColor[0].setEnabled(false);
					AnimalColor[1].setEnabled(false);
					AnimalColor[2].setEnabled(false);
					

				}
				
				switch(AnimalColor[i].getText())
				{	
					

				case "Red":
					{
						color="red";
						
						break;
					}
				case "Blue":color="blue";break;
				case "Natural":color="natural";break;
				}
			}
			
		}
		
		
			for(int i=0;i<TypeAnimal.length;++i)
			{
				if(e.getSource()==TypeAnimal[i] && TypeAnimal[i].isSelected() && TypeAnimal[i].isEnabled())
					
				{
					TypeAnimal[0].setEnabled(false);
					TypeAnimal[1].setEnabled(false);
					TypeAnimal[2].setEnabled(false);
					TypeAnimal[3].setEnabled(false);
					TypeAnimal[4].setEnabled(false);
					type=TypeAnimal[i].getText();
					if(e.getSource()==done)
					TypeAnimal[0].setEnabled(false);
					TypeAnimal[1].setEnabled(false);
					TypeAnimal[2].setEnabled(false);
					TypeAnimal[3].setEnabled(false);
					TypeAnimal[4].setEnabled(false);
				}
				
					
			}
			
			
		if(e.getSource()==done)
			{
			if(type!=null)
			{
				
			
				switch(type)
				{
				case "Lion":
				{
					
					System.out.println("Case Lion ");
					animal=new Lion(siz2,color,panel,speedH,speedV);
					this.zooPanel.setAnimalList(animal);
					this.setCheckIcons();
					zFrame.resize(new Dimension(2200,760));
					zFrame.resize(new Dimension(2200,667));
					break;
				}
				
				case "Bear":
				{
					System.out.println("Case Bear ");
					animal=new Bear(siz2,color,panel,speedH,speedV);
					this.zooPanel.setAnimalList(animal);
					zFrame.resize(new Dimension(2201,771));
					zFrame.resize(new Dimension(2200,667));
					this.setCheckIcons();

					


					break;
				}
				
				case "Giraffe":
				{
					animal=new Giraffe(siz2,color,panel,speedH,speedV);
					this.zooPanel.setAnimalList(animal);
					zFrame.resize(new Dimension(2198,772));
					zFrame.resize(new Dimension(2200,667));
					this.setCheckIcons();



					
					break;
				}
				
				case "Elephant":
				{
					animal=new Elephant(siz2,color,panel,speedH,speedV);
					this.zooPanel.setAnimalList(animal);
					zFrame.resize(new Dimension(2203,773));
					zFrame.resize(new Dimension(2200,667));
					this.setCheckIcons();


					
					break;
				}
				
				case "Turtle":
				{
					animal=new Turtle(siz2,color,panel,speedH,speedV);
					this.zooPanel.setAnimalList(animal);
					zFrame.resize(new Dimension(2204,774));
					zFrame.resize(new Dimension(2200,667));
					this.setCheckIcons();

					
					break;
					
				}
				
				}

				
			}
				}
				

		}
	
	public static Animal getAnimal()
	{
		return animal;
	}
	
	
	
}
