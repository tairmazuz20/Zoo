package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;
import javax.swing.border.EtchedBorder;

public class Food   {

	private JDialog dialog;
	private JButton lettuce=new JButton("Lettuce");
	private JButton cabbage=new JButton("Cabbage");
	private JButton meat=new JButton("Meat");
	private JPanel displayButtons=new JPanel();
	private JPanel displayLabel =new JPanel();
	private JLabel title=new JLabel("Please Select Food Type:");
	private ZooPanel zooPanel;
	private ZooFrame zooFrame;
	private BufferedImage img;
	private String getType=this.getClass().getSimpleName();


	private static List<Plant> food=new ArrayList<>();

	
	public Food(ZooFrame zf) {
		dialog=new JDialog();
		this.zooFrame=zf;
		this.zooPanel=new ZooPanel(zooFrame);
		
		displayLabel.add(title);
		displayButtons.add(cabbage);
		displayButtons.add(lettuce);
		displayButtons.add(meat);
		
		title.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
		cabbage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Cabbage(zooFrame));
				disableButtons();

			}
		});
		lettuce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Lettuce(zooFrame));
				disableButtons();

			}
		});
		meat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Meat(zooFrame));
				disableButtons();
			}
		});
		designButton(cabbage);
		designButton(lettuce);
		designButton(meat);
		

		
		dialog.pack();
		dialog.getContentPane().add(displayLabel,BorderLayout.NORTH);
		dialog.getContentPane().add(displayButtons,BorderLayout.SOUTH);
		dialog.setBounds(200, 200, 500, 300);
		dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	

	public void designButton(JButton button) {
		button.setSize(250,250);
		button.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(64, 64, 64)));
		
	}
	
	private void disableButtons()
	{
		meat.setEnabled(false);
		lettuce.setEnabled(false);
		cabbage.setEnabled(false);
		zooFrame.resize(new Dimension(2200,781));
		zooFrame.resize(new Dimension(2200,667));

	}
	public static List <Plant> getFood()
	{
		return food;
	}
	public String getFoodName()
	{
		return this.getType;
	}


}
