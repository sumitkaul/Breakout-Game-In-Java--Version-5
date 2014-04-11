package gui;

import game.maker.GameMaker;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EventButtonsPanel {

	private JPanel eventButtonsPanel;
	private GameMaker gameMaker;
	private DesignGamePanel designGamePanel;
	private JButton buttonCreateEvent;
	private JButton buttonModifyEvent;
	private JButton buttonRemoveEvent;
		
//	public SpritePanel(GameMaker gameMaker,DesignGamePanel designGamePanel)
	public EventButtonsPanel()
	{
		//this.gameMaker=gameMaker;
		//this.designGamePanel=designGamePanel;
		eventButtonsPanel=new JPanel();
		buttonCreateEvent = new JButton("Create Event");
		buttonCreateEvent.setVisible(true);
		//buttonCreateEvent.addActionListener( );	// add actionlistners
		buttonModifyEvent = new JButton("Modify Event");
		buttonModifyEvent.setVisible(true);
		//buttonModifySprite.addActionListener(this);	// add actionlistners
		buttonRemoveEvent = new JButton("Remove Event");
		buttonRemoveEvent.setVisible(true);
		//buttonRemoveSprite.addActionListener(this);	// add actionlistners
		
		eventButtonsPanel.add(buttonCreateEvent);
		eventButtonsPanel.add(buttonModifyEvent);
		eventButtonsPanel.add(buttonRemoveEvent);
        
       
		//eventButtonsPanel.setSize(400, 200);	
		eventButtonsPanel.setBackground(Color.LIGHT_GRAY);
		eventButtonsPanel.setBorder(BorderFactory.createTitledBorder(null,"Sprite Stuff",0,0,null,Color.BLACK));
		eventButtonsPanel.setLayout(new FlowLayout());
		eventButtonsPanel.validate();
		
		eventButtonsPanel.setVisible(true);
		

	}
	
	
	public JPanel getEventButtonsPanel(){
		return eventButtonsPanel;
	}



	

//	public JLabel getSpriteShapeLabel() {
//		return spriteShapeLabel;
//	}
//
//
//	public JLabel getSpriteSetWidthLabel() {
//		return spriteSetWidthLabel;
//	}
//
//
//	public JLabel getSpriteSetHeightLabel() {
//		return spriteSetHeightLabel;
//	}
//
//	public JComboBox getSpriteShapeBox() {
//		return spriteShapeBox;
//	}
//
//	public JSlider getSpriteSetWidthSlider() {
//		return spriteSetWidthSlider;
//	}
//
//	public JSlider getSpriteSetHeightSlider() {
//		return spriteSetHeightSlider;
//	}
//
//	public JButton getSetSprite() {
//		return setSprite;
//	}
//
//	public SpritePanelControl getSpritePanelControl() {
//		return spritePanelControl;
//	}	
//	
//	public String[] getSpriteShapesString(){
//		return spriteShapes;
//	}
//	
//	public void setXCoordinate(int xCoordinate){
//		this.xCoordinate=xCoordinate;
//	}
//	
//	public int getXCoordinate(){
//		return xCoordinate;
//	}
//	
//	public void setYCoordinate(int yCoordinate){
//		this.yCoordinate=yCoordinate;
//	}
//	
//	public int getYCoordinate(){
//		return yCoordinate;
//	}
//	
//	public int getSpriteWidthValue(){
//		return spriteSetWidthSlider.getValue();
//	}
//	
//	public int getSpriteHeightValue(){
//		return spriteSetHeightSlider.getValue();
//	}
//	
//	
}

