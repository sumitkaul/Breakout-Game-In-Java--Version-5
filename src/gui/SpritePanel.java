package gui;
import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import control.SpritePanelControl;


public class SpritePanel 
{

	private JPanel spritePanel;
	private GameMaker gameMaker;
	 private List<String>listGameSprites = new ArrayList(0);
	private DesignGamePanel designGamePanel;
	private JButton buttonCreateSprite;
	private JButton buttonModifySprite;
	private JButton buttonRemoveSprite;
	private DefaultListModel listGameSpritesModel;
	private JList jListGameSprite;
	private JScrollPane listGameSpritesScrollPane;
	private JPanel buttonSpritePanel;
	
	
//	public SpritePanel(GameMaker gameMaker,DesignGamePanel designGamePanel)
	public SpritePanel()
	{
		this.gameMaker=gameMaker;
		this.designGamePanel=designGamePanel;
		spritePanel=new JPanel();
		buttonSpritePanel = new JPanel();
		buttonCreateSprite = new JButton("Create Sprite");
		buttonCreateSprite.setVisible(true);
		buttonCreateSprite.addActionListener(new AddSpriteLisetner());	// add actionlistners
		buttonModifySprite = new JButton("Modify Sprite");
		buttonModifySprite.setVisible(true);
		//buttonModifySprite.addActionListener(this);	// add actionlistners
		buttonRemoveSprite = new JButton("Remove Sprite");
		buttonRemoveSprite.setVisible(true);
		//buttonRemoveSprite.addActionListener(this);	// add actionlistners
		listGameSprites.add("a");
		listGameSprites.add("b");
		listGameSprites.add("c");
		listGameSpritesModel = new DefaultListModel();
        for (String temp : listGameSprites) 
        {
        	listGameSpritesModel.addElement(temp);
        }
        jListGameSprite = new JList(listGameSpritesModel);
        jListGameSprite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListGameSprite.setSelectedIndex(0);
       // jListGameSprite.addListSelectionListener(this);
        jListGameSprite.setVisibleRowCount(5);
        listGameSpritesScrollPane = new JScrollPane(jListGameSprite);
        listGameSpritesScrollPane.setSize(200, 400);
        
        buttonSpritePanel.setLayout(new BoxLayout(buttonSpritePanel,BoxLayout.PAGE_AXIS ));
        buttonSpritePanel.add(buttonCreateSprite);
        buttonSpritePanel.add(buttonModifySprite);
        buttonSpritePanel.add(buttonRemoveSprite);
        
        spritePanel.add(buttonSpritePanel);
        spritePanel.add(listGameSpritesScrollPane);
        
        
        spritePanel.setSize(400, 200);	
		spritePanel.setBackground(Color.LIGHT_GRAY);
		spritePanel.setBorder(BorderFactory.createTitledBorder(null,"Sprite Stuff",0,0,null,Color.BLACK));
		spritePanel.setLayout(new GridLayout(1,4));
		spritePanel.validate();
		
		spritePanel.setVisible(true);
		

	}
	
	
	public JPanel getSpritePanel(){
		return spritePanel;
	}

	private class AddSpriteLisetner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			new AddSprite();		
			
		}
}

	
	//
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
