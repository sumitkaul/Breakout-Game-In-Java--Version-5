package control;

import java.applet.Applet;
import java.applet.AudioClip;

//import model.SpriteUpdate;

import org.apache.log4j.PropertyConfigurator;

import view.DesignPanel;


import game.maker.GameMaker;

public class CollisionController {

    private static final org.apache.log4j.Logger LOG =
            org.apache.log4j.Logger.getLogger(CollisionController.class);
    
	private GameMaker gameMaker;
	
	private DesignPanel designPanel;
	
//	private SpriteUpdate spriteUpdate;
	
	private int spriteEventBoxVariable=0;
	
	private int spriteActionBoxVariable=0;
	
	public CollisionController(/*SpriteUpdate spriteUpdate,*/GameMaker gameMaker,DesignPanel designPanel){
		//this.spriteUpdate=spriteUpdate;
		this.gameMaker=gameMaker;
		this.designPanel=designPanel;
		//PropertyConfigurator.configure("resources/log4j.properties");
	
	}
	
    private void playSound(String fileName) {
        AudioClip clip = Applet.newAudioClip(getClass().getClassLoader().getResource(fileName));
        clip.play();
    }
	
	
	
	public void checkCollision()
	{/*
	
		for(int i=0;i<gameMaker.getGamePanel().getSpriteList().size();i++){
			
			if(gameMaker.getGamePanel().getSpriteList().get(i).getSpriteActionType().equalsIgnoreCase("Move")){
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(i).getxCoordinate()<=0) 
				|| ((gameMaker.getGamePanel().getSpriteList().get(i).getxCoordinate()+gameMaker.getGamePanel().getSpriteList().get(i).getWidth()))>= gameMaker.getGamePanel().getWidth()){
				
				gameMaker.getGamePanel().setVelX((gameMaker.getGamePanel().getVelX()*-1));
				playSound("resources/bounce.au");
				
				}
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(i).getyCoordinate()<=0) 
						|| ((gameMaker.getGamePanel().getSpriteList().get(i).getyCoordinate()+gameMaker.getGamePanel().getSpriteList().get(i).getHeight()))>= gameMaker.getGamePanel().getHeight()){
							
					gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
					playSound("resources/bounce.au");
				}
				
			}
		}
		
	
		for(int i=0;i<designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().size();i++)
		{
				
			//LOG.info(designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().size());
			
			spriteEventBoxVariable=designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteEventBox().getSelectedIndex();
		
			
			for(int j=0;j<gameMaker.getGamePanel().getSpriteList().size();j++)	
			{
				
				if(gameMaker.getGamePanel().getSpriteList().get(j).getName()==designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteActionBox().getSelectedItem()){	
				
					 spriteActionBoxVariable = j;
				}	
			}
			
			
			if(((designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteEventBox().getSelectedItem()=="Ball") && (designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteActionBox().getSelectedItem()=="Paddle")))
			{
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate())
						
				&&  (gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate()+gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getWidth())))
				{
				
				
					if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate()+
					gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getHeight()))	
					&&	
					(gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()+	gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getHeight())>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate())		
					{
						
						gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
					    playSound("resources/bounce.au");

					}
					
				
				}			
			}//if condition for designpanel
		
			
			
			if(((designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteEventBox().getSelectedItem()=="Paddle") && (designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteActionBox().getSelectedItem()=="Ball")))
			{
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate())
						
				&&  (gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate()+gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getWidth())))
				{
				
				
					if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate()+
					gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getHeight()))	
					&&	
					(gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()+	gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getHeight())>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate())		
					{
						
						gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
						playSound("resources/bounce.au");
					}
					
				
				}			
			}//if condition for designpanel
			
			

			if(((designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteEventBox().getSelectedItem()=="Ball") && (designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteActionBox().getSelectedItem()=="Brick")))
			{
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate())
						
				&&  (gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate()+gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getWidth())))
				{
				
				
					if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate()+
					gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getHeight()))	
					&&	
					(gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()+	gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getHeight())>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate())		
					{
						
				//		if(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Brick Disappear"){
						gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
						
						gameMaker.getGamePanel().getSpriteList().remove(spriteActionBoxVariable);
						
						designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().remove(i);
						
						designPanel.getActionEventPanelClass().getSpriteEventBox().removeItemAt(spriteActionBoxVariable);
						
						designPanel.getActionEventPanelClass().getSpriteActionBox().removeItemAt(spriteActionBoxVariable);
				//		}
						
				//		if(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Bounce")
				//			gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
						
						
					}
					
				
				}			
			}//if condition for designpanel
			
			
			

			if(((designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteEventBox().getSelectedItem()=="Brick") && (designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().get(i).getSpriteActionBox().getSelectedItem()=="Ball")))
			{
				
				
				if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate())
						
				&&  (gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getxCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getxCoordinate()+gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getWidth())))
				{
				
				
					if((gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()<=(gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate()+
					gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getHeight()))	
					&&	
					(gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getyCoordinate()+	gameMaker.getGamePanel().getSpriteList().get(spriteEventBoxVariable).getHeight())>=gameMaker.getGamePanel().getSpriteList().get(spriteActionBoxVariable).getyCoordinate())		
					{
						
				//		if(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Brick Disappear"){
						gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
						
						gameMaker.getGamePanel().getSpriteList().remove(spriteActionBoxVariable);
						
						designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList().remove(i);
						
						designPanel.getActionEventPanelClass().getSpriteEventBox().removeItemAt(spriteActionBoxVariable);
						
						designPanel.getActionEventPanelClass().getSpriteActionBox().removeItemAt(spriteActionBoxVariable);
						//playSound("resources/Brick.au");
				//		}
						
				//		if(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Bounce")
				//		gameMaker.getGamePanel().setVelY((gameMaker.getGamePanel().getVelY()*-1));
						
						
					}
					
				
				}			
			}//if condition for designpanel
			
		}
		
	}
*/
}
	
}
