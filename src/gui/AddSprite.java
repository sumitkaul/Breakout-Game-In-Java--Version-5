package gui;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.SpriteManager;

import utility.GameState;


public class AddSprite implements ActionListener
{	

	private static final long serialVersionUID = 1L;
	private JFrame addSpriteFrame;	

	private JPanel spritePanel;	
	private JPanel spritePropertiesPanel;
	private JPanel buttonPanel;

	private GameState gameState;
	private ActionEventPanel actionEventPanel;
	private EventButtonsPanel eventButtonsPanel;
	private JLabel labelSpriteName;
	private JTextField textSpriteName;
	private JLabel labelXCordinate;
	private JLabel labelYCordinate;
	private JSlider SliderXCordinate;
	private JSlider SliderYCordinate;
	private JLabel labelYVelocity;
	private JLabel labelXVelocity;
	private JSlider SliderXVelocity;
	private JSlider SliderYVelocity;
	private JLabel labelWidth;
	private JLabel labelHeight;
	private JSlider SliderWidth;
	private JSlider SliderHeight;
	private JPanel imagePanel;
	private Graphics graphics;
	private JScrollPane imageScrollPane;
	private JPanel imagePreviewPanel;
	private JLabel imagelabel;
	private JButton btnAddSprite;
	private JButton btnCreateSprite;
	private ArrayList <JButton> imageArrayList = new ArrayList<JButton>();
	private JLabel imagePreviewlabel;
	private ImageIcon selectedIcon;
	
	public AddSprite()
	{
		this.addSpriteFrame = new JFrame();
		this.spritePanel = new JPanel(new GridLayout(1,2));
		this.spritePropertiesPanel = new  JPanel(new GridLayout(2,3));
		this.buttonPanel = new JPanel();
		this.imagePanel= new JPanel(new GridLayout(3,1));
		this.imagePreviewPanel = new JPanel();

		addSpriteFrame.getContentPane().add(spritePanel);
		addSpriteFrame.getContentPane().add(spritePropertiesPanel);

		labelSpriteName = new JLabel("Sprite Name");
		textSpriteName = new JTextField();

		spritePanel.add(labelSpriteName);
		spritePanel.add(textSpriteName);

		labelXCordinate =new JLabel(" X : ");
		labelYCordinate =new JLabel(" Y : ");
		SliderXCordinate =new JSlider(SwingConstants.HORIZONTAL,0,100,0);
		SliderYCordinate =new JSlider(SwingConstants.HORIZONTAL,0,100,0);

		labelWidth =new JLabel("Width");
		labelHeight =new JLabel("Height");
		SliderWidth =new JSlider(SwingConstants.HORIZONTAL,0,100,0);
		SliderHeight =new JSlider(SwingConstants.HORIZONTAL,0,100,0);

		labelXVelocity =new JLabel(" X Velocity ");
		labelYVelocity =new JLabel(" Y Velocity ");
		SliderXVelocity =new JSlider(SwingConstants.HORIZONTAL,0,100,0);
		SliderYVelocity =new JSlider(SwingConstants.HORIZONTAL,0,100,0);

		spritePropertiesPanel.setLayout(new GridLayout(6,2));
		spritePropertiesPanel.add(labelXCordinate);
		spritePropertiesPanel.add(labelYCordinate);
		spritePropertiesPanel.add(SliderXCordinate);
		spritePropertiesPanel.add(SliderYCordinate);

		spritePropertiesPanel.add(labelWidth);
		spritePropertiesPanel.add(labelHeight);
		spritePropertiesPanel.add(SliderWidth);
		spritePropertiesPanel.add(SliderHeight);

		spritePropertiesPanel.add(labelXVelocity);
		spritePropertiesPanel.add(labelYVelocity);
		spritePropertiesPanel.add(SliderXVelocity);
		spritePropertiesPanel.add(SliderYVelocity);

		imagelabel = new JLabel("Select image");
		imagePreviewlabel = new JLabel();
		
		File folder = new File("images");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				//imagePreviewPanel.add(new LoadImageApp(listOfFiles[i].getPath()));
				ImageIcon imageICon = new ImageIcon();
				try{
					BufferedImage bufferedImage =  ImageIO.read(new File(listOfFiles[i].getPath()));
					Image scaledImage = bufferedImage.getScaledInstance(50,50, Image.SCALE_DEFAULT);
					imageICon.setImage(scaledImage);
					JButton imagebutton =  new JButton(imageICon);
					imagebutton.setMaximumSize(new Dimension(50, 50));
					imagebutton.addActionListener(this);
					imagePreviewPanel.add(imagebutton);					
					//imagebutton.setSize(50, 50);
					}
				catch(IOException e)

				{

				}


			} 
		}
		imageScrollPane = new JScrollPane(imagePreviewPanel);
		imageScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		btnCreateSprite = new JButton("Create Sprite");
		btnCreateSprite.addActionListener(this);

		imagePanel.add(imagelabel);
		imagePanel.add(imagePreviewlabel);
		imagePanel.add(imageScrollPane);
		imagePanel.add(btnCreateSprite);

		addSpriteFrame.getContentPane().setLayout(new BoxLayout(addSpriteFrame.getContentPane(),BoxLayout.PAGE_AXIS ));
		addSpriteFrame.getContentPane().add(spritePanel);
		addSpriteFrame.getContentPane().add(spritePropertiesPanel);
		addSpriteFrame.getContentPane().add(imagePanel);

		addSpriteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addSpriteFrame.setTitle("GameMaker " );
		addSpriteFrame.setVisible(true);
		addSpriteFrame.setSize(400,400);
		addSpriteFrame.validate();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnCreateSprite))
		{
			String name = textSpriteName.getText();
			int xCoordinate = SliderXCordinate.getValue();
			int yCoordinate = SliderYCordinate.getValue();
			int width = SliderWidth.getValue();
			int height = SliderHeight.getValue();
			
			SpriteManager.getInstance().Create(name, "", xCoordinate, yCoordinate, width, height, this.selectedIcon);
			addSpriteFrame.setVisible(false);
			GamePlayPanel.getInstance().draw();
				
			
		} 
		else
		{	
		   JButton btn = (JButton) e.getSource();
		   this.selectedIcon =(ImageIcon) btn.getIcon();
		    imagePreviewlabel.setIcon(btn.getIcon());
		}
	}

	}												
