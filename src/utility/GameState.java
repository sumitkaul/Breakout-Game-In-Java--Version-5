package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import control.CollisionClass;

//import sun.security.krb5.internal.crypto.Des;

import model.SpriteModelObject;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.StaxDriver;

//import drawable.Ball;


public class GameState {
	private List<SpriteModelObject> spriteList;
	
//	private Ball ball;

	//private List<CollisionClass> collisionEventList;
	
	/*public List<CollisionClass> getCollisionEventList() {
		return collisionEventList;
	}*/

	/*public void setCollisionEventList(List<CollisionClass> collisionEventList) {
		this.collisionEventList = collisionEventList;
	}*/

	public GameState() {
	
		this.spriteList = new ArrayList<SpriteModelObject>();
		//this.collisionEventList=new ArrayList<CollisionClass>();
		}
	
	public void saveXML(List<SpriteModelObject> spriteList) throws IOException{
		/*	setSpriteList(spriteList);
			setCollisionEventList(collisionEventList);
			//XStream writer = new XStream(new StaxDriver());
			//String xml = writer.toXML(this);
			String xml = writer.toXML(spriteList);
			FileWriter fstream = new FileWriter("saveGameSpriteList.xml");
			BufferedWriter out = new BufferedWriter(fstream);
			
			String xml1=writer.toXML(collisionEventList);
			FileWriter fstream1 = new FileWriter("saveGameCollisionEventList.xml");
			BufferedWriter out1 = new BufferedWriter(fstream1);
			
			
			out.write(xml);
			out.close();
			
			out1.write(xml1);
			out1.close();*/
		}
	
    public GameState loadXML() throws FileNotFoundException {
     /*   FileReader freader = new FileReader("saveGameSpriteList.xml");
        BufferedReader in = new BufferedReader(freader);
        XStream reader = new XStream(new StaxDriver());
        this.spriteList = (List<CreateSpriteClass>) reader.fromXML(in);
        
        
        FileReader freader1 = new FileReader("saveGameCollisionEventList.xml");
        BufferedReader in1 = new BufferedReader(freader1);
        XStream reader1 = new XStream(new StaxDriver());
        this.collisionEventList = (List<CollisionClass>) reader1.fromXML(in1);*/
        
          
        return this;
        
    }
    
	public void setSpriteList(List<SpriteModelObject> spriteList){
		this.spriteList = spriteList;
	}
	
	public List<SpriteModelObject> getSpriteList(){
		return spriteList;
	}
    
    /*  public int getBallX(){
    	return ball.getX();
    }
    
    public int getBallWidth(){
    	return ball.getWidth();
    }
    
    public void setObjects(Ball ball){
    	//have a list of objects that define the state of the gamemaker, for now just the ball
    	this.ball = ball;
    }
    
    public Ball getObjects(){
    	return ball;
    }
   */ 
    
    }
