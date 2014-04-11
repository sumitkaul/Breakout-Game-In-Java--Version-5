package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import observer.ConcreteObservable;
import observer.Observer;


public class SpriteModelObject implements SpriteModel {
	
	private int id;
	private	String name;	
	private String shape;
	private int xCoordinate;
	private int yCoordinate;
	private int width;
    private int height;
    private int xVelocity = 0;

	private int yVelocity = 0;
	
	private List<String> unaryEvents=new ArrayList<String>();
	private String spriteActionType;
	private List<String> spriteMoveEvents;	
	private ConcreteObservable  dataChangeobservable;

	
	public SpriteModelObject(String name,String shape,int xCoordinate,int yCoordinate,int width,int height){
		this.name = name;
		this.shape = shape;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.width =width; 
		this.height = height;		
		dataChangeobservable = new ConcreteObservable();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getShape() {
		return shape;
	}

	public void setShape(String spriteShape) {
		this.shape = spriteShape;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		if(this.yCoordinate != yCoordinate)
		{
		    this.yCoordinate = yCoordinate;
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int spriteWidth) {
		if(this.width != spriteWidth)
		{
		    this.width = spriteWidth;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int spriteHeight) {
		
		if(this.height != spriteHeight)
		{
		    this.height = spriteHeight;
		}
	}

	public List<String> getUnaryEvents() {
		return unaryEvents;
	}

	/*public void setUnaryEvents(List<String> unaryEvents) {
		this.unaryEvents = unaryEvents;
	}*/

	public String getSpriteActionType() {
		return spriteActionType;
	}

	public void setSpriteActionType(String spriteActionType) {
		this.spriteActionType = spriteActionType;
	}

	public void registerforDataChange(Observer observer)
	{
		dataChangeobservable.register(observer);
	}
	
	public void removefromDataChange(Observer observer)
	{
		dataChangeobservable.remove(observer);
	}
	
    public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	
	//public void createSprite(String spriteName,String spriteShape,int xCoordinate,int yCoordinate,int spriteWidth,int spriteHeight,List<String> unaryEvents,String spriteActionType,List<String> spriteMoveEvents)
	{	
		/*setSpriteName(spriteName);
		setSpriteShape(spriteShape);
		setSpriteActionType(spriteActionType);
		setxCoordinate(xCoordinate);
		setyCoordinate(yCoordinate);
		setSpriteWidth(spriteWidth);
		setSpriteHeight(spriteHeight);*/
		/*if(unaryEvents.size()>0)
		setUnaryEvents(unaryEvents);
		setSpriteMoveEvents(spriteMoveEvents);*/
		
	}

	//public List<String> getSpriteMoveEvents() {
//		return spriteMoveEvents;
	//}

	//public void setSpriteMoveEvents(List<String> spriteMoveEvents) {
		//this.spriteMoveEvents = spriteMoveEvents;
	//}
	
}
