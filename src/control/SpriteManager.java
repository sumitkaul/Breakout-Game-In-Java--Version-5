package control;
import game.maker.GameMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import view.SpritePanel;
import view.SpriteViewObject;


import model.SpriteModelObject;



public class SpriteManager {
		
	private List<SpriteModelObject> spriteModelList=new ArrayList<SpriteModelObject>();
	private List<SpriteViewObject> spriteViewList=new ArrayList<SpriteViewObject>();
	
	private SpritePanel spritePanel;
	private static SpriteManager spriteManager = null;
	
	private GameMaker gameMaker;
		
   
	public SpriteManager(){
     //this.gameMaker = gamemaker;
	}
	
   public GameMaker getGameMaker() {
			return gameMaker;
	}

	public void setGameMaker(GameMaker gameMaker) {
			this.gameMaker = gameMaker;
	}

	
	//create both model and view object and using the observer pattern connect sprite and view
	public void Create(String name, String shape, int xCoordinate, int yCoordinate, int width, int height, ImageIcon icon )
	{
		//create sprite model and view and set the observer		
		SpriteModelObject modelObj = new SpriteModelObject(name, shape, xCoordinate, yCoordinate, width ,height );
		spriteModelList.add(modelObj);
		
		//File file = new File("images/frog2.jpg");
		SpriteViewObject  viewObj = new SpriteViewObject(modelObj,icon);
		modelObj.registerforDataChange(viewObj);
		spriteViewList.add(viewObj);
	}
	
	public static SpriteManager getInstance()
	{
		if (spriteManager == null) {
			spriteManager = new SpriteManager();
		}

		return spriteManager;
	}
	
	public SpriteModelObject getSpriteModel(String spriteName){
		java.util.Iterator<SpriteModelObject> it =  spriteModelList.iterator();
		while( it.hasNext() ) {
			  SpriteModelObject spriteElement = it.next();
			  if (spriteElement.getName().equals(spriteName)){
				  return spriteElement;
				  }
			}
		
		return null;	
	}
	
	
	public SpriteViewObject getSpriteView(String spriteName){
		java.util.Iterator<SpriteViewObject> it =  spriteViewList.iterator();
		while( it.hasNext() ) {
			  SpriteViewObject spriteElement = it.next();
			  if (spriteElement.getName().equals(spriteName)){
				  return spriteElement;
				  }
			}
		
		return null;	
	}
	
	public void RemoveSprite(String spriteName)
	{
		SpriteModelObject modObj = getSpriteModel(spriteName);
		int i = spriteModelList.indexOf(modObj);
		if (i >= 0) {
			spriteModelList.remove(i);
		}		
		SpriteViewObject viewObj = getSpriteView(spriteName);
		
		 i = spriteViewList.indexOf(viewObj);
		 if (i >= 0) {
			 spriteViewList.remove(i);
		   }		
	}
	//public void checkCreatedSprite(SpritePanel spritePanel,String spriteName,String spriteActionType,String spriteShape,List<String> unaryEvents,List<String> spriteMoveEvents){
	
		/*this.spritePanel=spritePanel;
		this.name=spriteName;
		this.spriteShape=spriteShape;
		this.spriteActionType=spriteActionType;
		if(unaryEvents.size()>0)
		this.unaryEvents=unaryEvents;
		this.spriteMoveEvents=spriteMoveEvents;
		xCoordinate=spritePanel.getXCoordinate();
		yCoordinate=spritePanel.getYCoordinate();
		width=spritePanel.getSpriteWidthValue();
		height=spritePanel.getSpriteHeightValue();
		
		createSpriteClass=new SpriteModel();
		createSpriteClass.createSprite(spriteName,spriteShape,xCoordinate,yCoordinate,width,height,unaryEvents,spriteActionType,spriteMoveEvents);*/
		
		//spriteList.add(createSpriteClass);
		
		/*if (getSpriteElement("Ball") != null && getSpriteElement("Paddle") != null && getSpriteElement("Brick") != null){
		 
			gameMaker.getDesignPanel().getGameStartPanelClass().setChangeLayoutButtonEnabled();			
		}*/

		//spriteElements=new String[spriteList.size()];
		//for(int k=0;k<spriteList.size();k++)
		//spriteElements[k]=spriteList.get(k).getSpriteName();
		
		//gameMaker.getGamePanel().draw(spriteList);
	//}


	public List<SpriteModelObject> getSpriteModelList() {
		return spriteModelList;
	}
	
	public List<SpriteViewObject> getSpriteViewList() {
		return spriteViewList;
	}

}
	


