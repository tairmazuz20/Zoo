package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import animals.Animal;
import animals.Lion;

/*Dear Checker Please Dont Forget To Import All The Images I Have Attached. it contains additional images
/*that are not included in the original folder given. otherwise it will not work properly. thanks :).
 * 
 */




/**
 * Display All The Zoo Funcionality On The Screen.
 * 
 * @author  Tair Mazuz-211809181, Reut Avitan-211685037 Ashdod Campus
 *
 */
public class ZooFrame extends JFrame implements ActionListener{
	
	
	private JMenu file=new JMenu("File");
	private JMenu BackGround=new JMenu("Background");
	private JMenu Help=new JMenu("Help");
	private JMenuItem Exit=new JMenuItem("Exit");
	private JMenuItem image=new JMenuItem("Image");
	private JMenuItem green=new JMenuItem("Green");
	private JMenuItem none=new JMenuItem("None");
	private JMenuItem help=new JMenuItem("Help");
	JMenuBar jmenuBar=new JMenuBar();
	private ZooPanel zooPanel=new ZooPanel(this);
	private Image img;
	private static final int screenWidth=2200;
	private static final int screenHeight=667;
	private JPanel drawing=new JPanel();
	private JPanel toolBar=new JPanel();
	private static JPanel p=new JPanel();
	private JPanel p1=new JPanel();
	private JDialog d=new JDialog();
	private static JPanel  p2=new JPanel();
	
	
	/**
	 *  a constructor that opens up a window and displays all the zoo's functionality.
	 *
	 */
	public ZooFrame()
	{
		super("Zoo Frame");
		this.setLayout(new BorderLayout());
	
		
		image.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zooPanel.loadImage("savanna.png");
				zooPanel.repaint();
			}
			
		});
		
		green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zooPanel.loadImage("GreenBackground.PNG");
				zooPanel.repaint();
				
				
			}
			
		});
		this.add(p);
		none.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						
						zooPanel.loadImage("transparent.PNG");
						zooPanel.repaint();
						
						
						
					}
			
				});
		this.add(p1);
		this.add(zooPanel.getP());
		this.add(zooPanel,BorderLayout.CENTER);
		this.setBounds(0, 0, screenWidth, screenHeight);
		this.setSize(screenWidth,screenHeight);
		//this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	/**
	 * Gets Menu Bar Object, set its size and adds it to Zoo Frame.
	 * @param jmb JMenuBar - a component to add to the frame that responsible of the tool bar visuality.
	 */
	private void setToolBar(JMenuBar jmb) {
		this.toolBar.setSize(new Dimension(screenWidth,40));
		this.toolBar.setLayout(new BorderLayout());
		this.toolBar.add(jmb,BorderLayout.NORTH);
		this.toolBar.setVisible(true);
		
		
	}
	
	/**
	 * sets tool the tool bar visuality and adds components to this toolbar.
	 */
	public void menu()
	{
		
		this.setJMenuBar(jmenuBar);
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		file.add(Exit);
		//jmenuBar.setBackground(Color.LIGHT_GRAY);
		BackGround.add(image);
		BackGround.add(green);
		BackGround.add(none);
		Help.add(help);
		//jmenuBar.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.DARK_GRAY));
		BackGround.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
		Help.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
		file.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));

		jmenuBar.add(file);
		jmenuBar.add(BackGround);
		jmenuBar.add(Help);
		this.setToolBar(jmenuBar);
		this.add(toolBar,BorderLayout.NORTH);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Exit)
				
					System.exit(0);
			}
			
		});
		
		help.addActionListener(this);
		
	}
	

	public static void main(String[] args) {
		new ZooFrame().menu();
	}
	

		
@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==help)
	{
		
		
			JOptionPane.showMessageDialog(this, "Home Work 2"+"\nGUI","Message Dialog",JOptionPane.INFORMATION_MESSAGE);	
	}
	
}
	public static JPanel getP2()
	{
		return p2;
	}
	
	public static JPanel getP()
	{
		return p;
	}
	
	
	
}
	
	
	
			  
			
		
		
		
		


	
	

