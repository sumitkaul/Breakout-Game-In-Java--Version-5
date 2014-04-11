package view;
import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import control.SpritePanelControl;


public class SpritePanel {

	private JPanel spritePanel;
	private JLabel spriteShapeLabel;
	private JLabel spriteSetWidthLabel;
	private JLabel spriteSetHeightLabel;
	private JComboBox spriteShapeBox;
	private JSlider spriteSetWidthSlider;
	private JSlider spriteSetHeightSlider;
	private JButton setSprite;
	private GameMaker gameMaker;
	private String spriteShapes;
	
	private int xCoordinate,yCoordinate;
	//private String spriteShapes[]={"Circle","Rectangle","Image"};
	
	private GridBagConstraints gridBagConstraints=new GridBagConstraints();
	
	private SpritePanelControl spritePanelControl;
	
	private DesignPanel designPanel;
	
	public SpritePanel(GameMaker gameMaker,DesignPanel designPanel){
		this.gameMaker=gameMaker;
		this.designPanel=designPanel;
		spritePanelControl=new SpritePanelControl(gameMaker,designPanel,this);
		spritePanel=new JPanel();
		spritePanel.setSize(400, 200);	
		spritePanel.setBackground(Color.LIGHT_GRAY);
	//	spritePanel.setBorder(BorderFactory.createTitledBorder(null,"Sprite Stuff",0,0,null,Color.BLACK));
		spritePanel.setLayout(new GridBagLayout());
		
		
		spriteShapeLabel=new JLabel("Sprite Shape:");
		spriteShapeLabel.setVisible(true);
		spriteSetHeightLabel=new JLabel("Select Height:");
		spriteSetHeightLabel.setVisible(true);
		spriteSetWidthLabel=new JLabel("Select Width");
		spriteSetWidthLabel.setVisible(true);
		spriteSetWidthSlider=new JSlider(SwingConstants.HORIZONTAL,0,100,0);
		spriteSetWidthSlider.setVisible(true);
		spriteSetHeightSlider=new JSlider(SwingConstants.HORIZONTAL,0,100,0);
		spriteSetHeightSlider.setVisible(true);
		spriteShapeBox=new JComboBox();
		spriteShapeBox.setVisible(true);
		setSprite=new JButton("Set Sprite");
		setSprite.setVisible(true);
		
		setGridsSpritePanel(1,0,1,1);
		spritePanel.add(spriteShapeLabel,this.gridBagConstraints);
		setGridsSpritePanel(2,0,1,1);
		spritePanel.add(spriteShapeBox,this.gridBagConstraints);
		setGridsSpritePanel(1,2,1,1);
		spritePanel.add(spriteSetWidthLabel,this.gridBagConstraints);
		setGridsSpritePanel(2,2,1,1);
		spritePanel.add(spriteSetWidthSlider,this.gridBagConstraints);
		setGridsSpritePanel(1,3,1,1);
		spritePanel.add(spriteSetHeightLabel,this.gridBagConstraints);
		setGridsSpritePanel(2,3,1,1);
		spritePanel.add(spriteSetHeightSlider,this.gridBagConstraints);
		setGridsSpritePanel(2,4,1,1);
		spritePanel.add(setSprite,this.gridBagConstraints);
		setSprite.addActionListener(spritePanelControl);
		spriteSetWidthSlider.addChangeListener(spritePanelControl);
		spriteSetHeightSlider.addChangeListener(spritePanelControl);
		spriteShapeBox.addActionListener(spritePanelControl);
		spritePanel.setVisible(false);
		
	}
	
	
	public void setGridsSpritePanel(int gridx,int gridy,int gridwidth,int gridheight ){
		gridBagConstraints.gridx=gridx;
		gridBagConstraints.gridy=gridy;
		gridBagConstraints.gridwidth=gridwidth;
		gridBagConstraints.gridheight=gridheight;
	}
	
	
	public JPanel getSpritePanel(){
		return spritePanel;
	}


	public JLabel getSpriteShapeLabel() {
		return spriteShapeLabel;
	}


	public JLabel getSpriteSetWidthLabel() {
		return spriteSetWidthLabel;
	}


	public JLabel getSpriteSetHeightLabel() {
		return spriteSetHeightLabel;
	}

	public JComboBox getSpriteShapeBox() {
		return spriteShapeBox;
	}

	public JSlider getSpriteSetWidthSlider() {
		return spriteSetWidthSlider;
	}

	public JSlider getSpriteSetHeightSlider() {
		return spriteSetHeightSlider;
	}

	public JButton getSetSprite() {
		return setSprite;
	}

	public SpritePanelControl getSpritePanelControl() {
		return spritePanelControl;
	}	
	
	/*public String[] getSpriteShapesString(){
		return spriteShapes;
	}*/
	
	public void setXCoordinate(int xCoordinate){
		this.xCoordinate=xCoordinate;
	}
	
	public int getXCoordinate(){
		return xCoordinate;
	}
	
	public void setYCoordinate(int yCoordinate){
		this.yCoordinate=yCoordinate;
	}
	
	public int getYCoordinate(){
		return yCoordinate;
	}
	
	public int getSpriteWidthValue(){
		return spriteSetWidthSlider.getValue();
	}
	
	public int getSpriteHeightValue(){
		return spriteSetHeightSlider.getValue();
	}
	
	
}
