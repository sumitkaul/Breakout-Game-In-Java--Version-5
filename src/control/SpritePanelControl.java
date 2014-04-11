package control;
import game.maker.GameMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.DesignPanel;
import view.SpritePanel;


import model.SpriteModelObject;
import model.TimerDisplayThread;



public class SpritePanelControl implements ActionListener,ChangeListener {

	private DesignPanel designPanel;
	
	private boolean isSpriteNameSame;
	
	private Timer timer;
	
	private int spriteCount=0;
	
	private String spriteName;
	
	private SpriteManager spriteModelClass;
	
	private String spriteXVelocity;
	
	private String spriteYVelocity;
	
	private String[] spriteElements=new String[10];
	
	private String[] keyBoardList;
	
	private GameMaker gameMaker;
	
	private String spriteShape;
	
	private List<String> unaryEvents=new ArrayList<String>();
	
	private List<String> spriteMoveEvents=new ArrayList<String>();
	
	private String spriteActionType;
	
	private boolean isInGamePanelBounds=false;
	
	private SpritePanel spritePanel;
	
	private Random random;
	
	private JComboBox spriteActionEventBox;
	
	public JComboBox getSpriteActionEventBox() {
		return spriteActionEventBox;
	}

	public void setSpriteActionEventBox(JComboBox spriteActionEventBox) {
		this.spriteActionEventBox = spriteActionEventBox;
	}

	public SpritePanelControl(GameMaker gameMaker,DesignPanel designPanel,SpritePanel spritePanel){
	this.spritePanel=spritePanel;
	this.designPanel=designPanel;
	this.gameMaker=gameMaker;
	spriteModelClass=SpriteManager.getInstance();
	spriteModelClass.setGameMaker(gameMaker);	
	keyBoardList=new String[2];
	TimerDisplayThread timerDisplayThread=new TimerDisplayThread(gameMaker);
	timer=new Timer(10,timerDisplayThread);	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x=0,y=0,size=0;
		//spriteName=designPanel.getSpriteCreatePanelClass().getSpriteBox().getSelectedItem().toString();
		//spriteShape=designPanel.getSpritePanelClass().getSpriteShapeBox().getSelectedItem().toString();
		//spriteActionType=designPanel.getSpriteCreatePanelClass().getActionBox().getSelectedItem().toString();
		//spriteXVelocity=String.valueOf(designPanel.getSpriteCreatePanelClass().getVelXSlider().getValue());
		//spriteYVelocity=String.valueOf(designPanel.getSpriteCreatePanelClass().getVelYSlider().getValue());
		//size=designPanel.getSpriteCreatePanelClass().getAddedKeysList().getModel().getSize();
		
		
		
		random=new Random();
	
		while(!isInGamePanelBounds){
			x=random.nextInt(500);
			y=random.nextInt(500);
			if((x+(designPanel.getSpritePanelClass().getSpriteWidthValue()))<500 && (y+designPanel.getSpritePanelClass().getSpriteHeightValue())<500){
				break;
			}
		}
		
		designPanel.getSpritePanelClass().setXCoordinate(x);
		designPanel.getSpritePanelClass().setYCoordinate(y);
		gameMaker.getGamePanel().setFocusable(true);
		
		timer.start();
		gameMaker.getGamePanel().requestFocus(true);
		
		if(spriteActionType.equalsIgnoreCase("Keyboard Events")){
			unaryEvents.clear();
	
			for(int i=0;i<size;i++){
				keyBoardList[i]=designPanel.getSpriteCreatePanelClass().getAddedKeysList().getModel().getElementAt(i).toString();
				unaryEvents.add(keyBoardList[i]);
			}	
			if(size==0)
				JOptionPane.showMessageDialog(null, "Please Add Key Events");
			
			
		
		}
		
		if(spriteActionType.equalsIgnoreCase("No Action")){
			unaryEvents.clear();
		}
		
		if(spriteActionType.equalsIgnoreCase("Move")){
			unaryEvents.clear();
			spriteMoveEvents.clear();
			unaryEvents.add(spriteXVelocity);
			unaryEvents.add(spriteYVelocity);
			spriteMoveEvents.add(spriteXVelocity);
			spriteMoveEvents.add(spriteYVelocity);
		}
			
		
		if(spriteShape.equalsIgnoreCase("Circle")){
			designPanel.getSpritePanelClass().getSpriteSetHeightLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetHeightSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSetSprite().setVisible(true);
		}
		

		if(spriteShape.equalsIgnoreCase("Rectangle")){
			designPanel.getSpritePanelClass().getSpriteSetHeightLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetHeightSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSetSprite().setVisible(true);
		}
		

		if(spriteShape.equalsIgnoreCase("Image")){
			designPanel.getSpritePanelClass().getSpriteSetHeightLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthLabel().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetHeightSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSpriteSetWidthSlider().setVisible(true);
			designPanel.getSpritePanelClass().getSetSprite().setVisible(true);
		}
		
		String setSpriteButtonText=e.getActionCommand();
		if(setSpriteButtonText.equalsIgnoreCase("Set Sprite")){
			
			isSpriteNameSame=false;
			
			
			
			for(int i=0;i<(spriteModelClass.getSpriteModelList().size());i++){
				spriteElements[i]=spriteModelClass.getSpriteModelList().get(i).getName();
			}

			
			
			
			if(spriteModelClass.getSpriteModelList().size()>=1){
			for(int i=0;i<(spriteModelClass.getSpriteModelList().size());i++){
			if(spriteElements[i].equalsIgnoreCase(spriteName)){	
				isSpriteNameSame=true;
			
			}
			}
			}
			
			if(!isSpriteNameSame){
			designPanel.getSpriteCreatePanelClass().getListModel().clear();
			gameMaker.getGamePanel().setIsSetSpriteButtonPressed(true);
			//spriteModelClass.checkCreatedSprite(spritePanel,spriteName,spriteActionType,spriteShape,unaryEvents,spriteMoveEvents);
			designPanel.getActionEventPanelClass().getSpriteEventBox().insertItemAt(spriteName,spriteCount);
			designPanel.getActionEventPanelClass().getSpriteActionBox().insertItemAt(spriteName,spriteCount);
			designPanel.getActionEventPanelClass().getSpriteEventBox().setVisible(true);
			designPanel.getActionEventPanelClass().getSpriteActionBox().setVisible(true);
			spriteCount++;
			}
			
			else 
				JOptionPane.showMessageDialog(null, "The Sprite Name is already chosen.Choose a different name!");
			
			
			
		}
	}


	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
	}

	public List<String> getUnaryEventsList(){
		return unaryEvents;
	}
	
	
	public String[] getKeyboardEventsList(){
		return keyBoardList;
	}
	
}
