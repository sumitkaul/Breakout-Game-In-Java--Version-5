package view;
import game.maker.GameMaker;

import java.awt.Color;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.apache.log4j.PropertyConfigurator;

import control.CollisionController;
import control.GamePanelResizableControl;
import control.KeyMouseController;

import model.SpriteModelObject;
//import model.SpriteUpdate;

import utility.GameState;


public class GamePanel extends JPanel{
	
    private static final org.apache.log4j.Logger LOG =
            org.apache.log4j.Logger.getLogger(GamePanel.class);
	
	private DesignPanel designPanel;
	
	private int velX=0,velY=0;
	
	private boolean isSpriteUpdatable=false;
	
	private boolean isLoadButtonPressed=false;
	
	public boolean isLoadButtonPressed() {
		return isLoadButtonPressed;
	}


	public void setLoadButtonPressed(boolean isLoadButtonPressed) {
		this.isLoadButtonPressed = isLoadButtonPressed;
	}


	public boolean isSpriteUpdatable() {
		return isSpriteUpdatable;
	}


	public void setSpriteUpdatable(boolean isSpriteUpdatable) {
		this.isSpriteUpdatable = isSpriteUpdatable;
	}


	public int getVelX() {
		return velX;
	}


	public void setVelX(int velX) {
		this.velX = velX;
	}


	public int getVelY() {
		return velY;
	}


	public void setVelY(int velY) {
		this.velY = velY;
	}

	private boolean isEnteredFirstTime=false;
	
	public boolean isEnteredFirstTime() {
		return isEnteredFirstTime;
	}


	public void setEnteredFirstTime(boolean isEnteredFirstTime) {
		this.isEnteredFirstTime = isEnteredFirstTime;
	}

	private boolean isSetSpriteButtonPressed=false;
	
	private List<SpriteViewObject> spriteList; 
	
	private KeyboardFocusManager keyboardFocusmanager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

	//private SpriteUpdate spriteUpdate;
	
	private CollisionController checkCollisionClass;
	
	private GameMaker gameMaker;
	
	public List<SpriteViewObject> getSpriteList() {
		return spriteList;
	}


	public void setSpriteList(List<SpriteViewObject> spriteList) {
		this.spriteList = spriteList;
	}

	public GamePanel(GameMaker gameMaker,DesignPanel designPanel) {
		this.designPanel=designPanel;
		this.gameMaker=gameMaker;
		this.setBorder(BorderFactory.createTitledBorder(null,"Game Panel",0,0,null,Color.BLACK));
		this.addComponentListener(new GamePanelResizableControl(this, gameMaker));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		//PropertyConfigurator.configure("resources/log4j.properties");
	}
	
	
	public void draw(List<SpriteViewObject> spriteList){
	
		this.spriteList=spriteList;		
		repaint();
	}
	
	
	
	public void paint(Graphics g){
		super.paint(g);
		
		if(isSetSpriteButtonPressed==true){
			
			
			for(int i=0;i<spriteList.size();i++){
				g.setColor(Color.RED);
				/*if(spriteList.get(i).getShape().equalsIgnoreCase("Circle")){
					
					g.fillOval(spriteList.get(i).getxCoordinate(),spriteList.get(i).getyCoordinate(),spriteList.get(i).getWidth(),spriteList.get(i).getHeight());
				}
				if(spriteList.get(i).getShape().equalsIgnoreCase("Rectangle")){
					g.fillRect(spriteList.get(i).getxCoordinate(),spriteList.get(i).getyCoordinate(),spriteList.get(i).getWidth(),spriteList.get(i).getHeight());
				}*/
				spriteList.get(i).draw(g);
				
			
		//	if(!isSpriteUpdatable){	
				/*if(spriteList.get(i).getSpriteActionType().equalsIgnoreCase("Keyboard Events")){
					
					KeyMouseController spriteKeyMouseListener=new KeyMouseController(this,spriteList.get(i));
					keyboardFocusmanager.addKeyEventDispatcher(spriteKeyMouseListener);
					addMouseListener(spriteKeyMouseListener);
					addMouseMotionListener(spriteKeyMouseListener);
					
				}*/
				
				/*if(spriteList.get(i).getSpriteActionType().equalsIgnoreCase("Move") || spriteList.get(i).getSpriteActionType().equalsIgnoreCase("No Action")      ){
					
					KeyMouseController spriteKeyMouseListener=new KeyMouseController(this,spriteList.get(i));
					addMouseListener(spriteKeyMouseListener);
					addMouseMotionListener(spriteKeyMouseListener);
				}*/
				
	//		}	
				if(isSpriteUpdatable){
				//call the paint object to draw	
				//SpriteUpdate spriteUpdate=new SpriteUpdate(this,spriteList);
				//spriteUpdate.update();
				checkCollisionClass=new CollisionController(/*spriteUpdate,*/gameMaker,designPanel);
				checkCollisionClass.checkCollision();
				}
			}			
		}
		
	}
	
	public void saveButtonPressed(GameState gameState){
		LOG.info("saveButtonPressed");
	}
	
	
	public SpriteModelObject getSpriteElement(String spriteName){
		
	/*	java.util.Iterator<SpriteViewObject> it =  spriteList.iterator();
		while( it.hasNext() ) {
			  SpriteViewObject spriteElement = it.next();
			  if (spriteElement.getName().equals(spriteName)){
				  return spriteElement;
				  
			  }
			}*/
		
		return null;
		
		
	}	
	
	
	public boolean getIsSetSpriteButtonPressed(){
		return isSetSpriteButtonPressed;
	}
	
	public void setIsSetSpriteButtonPressed(boolean isSetSpriteButtonPressed){
		this.isSetSpriteButtonPressed=isSetSpriteButtonPressed;
	}
	
	
	public void refactorSprites(double factorX, double factorY){
	/*	if(spriteList != null){
		
		java.util.Iterator<SpriteViewObject> it =  spriteList.iterator();
		
		
		while( it.hasNext() ) {
			  SpriteModelObject spriteElement = it.next();
			  spriteElement.setHeight((int)java.lang.Math.round(((factorY)*spriteElement.getHeight())));
			  spriteElement.setWidth((int)java.lang.Math.round(((factorX)*spriteElement.getWidth())));
			  spriteElement.setxCoordinate((int)java.lang.Math.round(((factorX)*spriteElement.getxCoordinate())));
			  spriteElement.setyCoordinate((int)java.lang.Math.round(((factorY)*spriteElement.getyCoordinate())));
		}
		
	}*/
	}	
	
	}
