package control;
import game.maker.GameMaker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JColorChooser;

import org.apache.log4j.PropertyConfigurator;

import view.DesignPanel;


import model.SpriteModelObject;



public class GameStartControl implements ActionListener {
	
    private static final org.apache.log4j.Logger LOG =
            org.apache.log4j.Logger.getLogger(GameStartControl.class);

	private Color color=Color.WHITE;
	
	private DesignPanel designPanel;
	
	private GameMaker gameMaker;

	public GameStartControl(GameMaker frameClass,DesignPanel designPanel){
		this.designPanel=designPanel;
		this.gameMaker=frameClass;
		//PropertyConfigurator.configure("resources/log4j.properties");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText=e.getActionCommand();
		if(buttonText.equalsIgnoreCase("Create Game")){
			designPanel.getGameStartPanelClass().getSaveGame().setEnabled(true);
			designPanel.getSpritePanelClass().getSpritePanel().setVisible(true);
			designPanel.getActionEventPanelClass().getActionEventPanel().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getSpriteCreatePanel().setVisible(true);
		}
			
		else if(buttonText.equalsIgnoreCase("Save Game")){
			
		/*	try {
				//gameMaker.getGameState().saveXML(gameMaker.getGamePanel().getSpriteList(),designPanel.getActionEventPanelClass().getActionEventPanelControl().getCollisionEventList());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		
		}
		else if(buttonText.equalsIgnoreCase("Load Game")){
						
				//LOG.info(gameMaker.getGamePanel().getSpriteElement("Ball").getxCoordinate());
				
				//try {
					//gameMaker.getGamePanel().setSpriteList(gameMaker.getGameState().loadXML().getSpriteList());
				
					//gameMaker.getDesignPanel().getActionEventPanelClass().getActionEventPanelControl().setCollisionEventList(gameMaker.getGameState().loadXML().getCollisionEventList());
					
					gameMaker.getGamePanel().setIsSetSpriteButtonPressed(true);
					//gameMaker.getGamePanel().draw(gameMaker.getGameState().getSpriteList());
					gameMaker.getDesignPanel().getGameStartPanelClass().setChangeLayoutButtonEnabled();
					
					designPanel.getSpritePanelClass().getSpritePanel().setVisible(true);
					designPanel.getActionEventPanelClass().getActionEventPanel().setVisible(true);
					designPanel.getSpriteCreatePanelClass().getSpriteCreatePanel().setVisible(true);
					
					
					for(int i=0;i<gameMaker.getGameState().getSpriteList().size();i++){
					
						designPanel.getActionEventPanelClass().getSpriteEventBox().setVisible(true);
						designPanel.getActionEventPanelClass().getSpriteActionBox().setVisible(true);
					designPanel.getActionEventPanelClass().getSpriteEventBox().insertItemAt(gameMaker.getGameState().getSpriteList().get(i).getName(),i);
					designPanel.getActionEventPanelClass().getSpriteActionBox().insertItemAt(gameMaker.getGameState().getSpriteList().get(i).getName(),i);
					}
					
					
					gameMaker.getGamePanel().setIsSetSpriteButtonPressed(true);
					gameMaker.getGamePanel().setLoadButtonPressed(true);
					
			//	} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();			
			//	
				
				designPanel.getGameStartPanelClass().getPlayGame().setEnabled(true);
		}
		
		
		else if(buttonText.equalsIgnoreCase("Set Background")){
			Color color = null;
			color=JColorChooser.showDialog(null, "Pick Your Color", color);
			if(color==null)
				color=color.WHITE;
			gameMaker.getGamePanel().setBackground(color);
		}	
		
		
		else if(buttonText.equalsIgnoreCase("Change Layout")){
			//LOG.info("yo, in change layout");
			SpriteModelObject spriteBallElement = gameMaker.getGamePanel().getSpriteElement("Ball");
			SpriteModelObject spritePaddleElement = gameMaker.getGamePanel().getSpriteElement("Paddle");
			SpriteModelObject spriteBrickElement = gameMaker.getGamePanel().getSpriteElement("Brick");
			
			if (spritePaddleElement.getWidth() > spritePaddleElement.getHeight()){
				LOG.info("In horizontal layout state");
				
				spriteBallElement.setxCoordinate((int)(0+0.1*gameMaker.getGamePanel().getWidth()));
				//spriteBallElement.setyCoordinate(yCoordinate);
				//spriteBallElement.setSpriteWidth(spriteWidth);
				//spriteBallElement.setSpriteHeight(spriteHeight);
				
				//spritePaddleElement.setxCoordinate(xCoordinate);
				spritePaddleElement.setyCoordinate((int)(0.5*gameMaker.getGamePanel().getHeight()));
				spritePaddleElement.setxCoordinate((int)(0.5*gameMaker.getGamePanel().getWidth()));
				int savedWidth = spritePaddleElement.getWidth();
				int savedHeight = spritePaddleElement.getHeight();
				spritePaddleElement.setWidth(savedHeight);
				spritePaddleElement.setHeight(savedWidth);
//				
				spriteBrickElement.setxCoordinate((int)(gameMaker.getGamePanel().getWidth()-0.1*gameMaker.getGamePanel().getWidth()));
				spriteBrickElement.setyCoordinate((int)(0.5*gameMaker.getGamePanel().getHeight()));
//				spriteBrickElement.setSpriteWidth(spriteWidth);
//				spriteBrickElement.setSpriteHeight(spriteHeight);
				//gameMaker.getGamePanel().draw(gameMaker.getGameState().getSpriteList());
				
				
			}
			else{
				LOG.info("In vertical layout state");
				
				spriteBallElement.setxCoordinate((int)(gameMaker.getGamePanel().getWidth() - 0.1*gameMaker.getGamePanel().getWidth()));
				spriteBallElement.setyCoordinate((int)(0+0.1*gameMaker.getGamePanel().getHeight()));
				//spriteBallElement.setSpriteWidth(spriteWidth);
				//spriteBallElement.setSpriteHeight(spriteHeight);
				
				//spritePaddleElement.setxCoordinate(xCoordinate);
				spritePaddleElement.setyCoordinate((int)(0.5*gameMaker.getGamePanel().getHeight()));
				spritePaddleElement.setxCoordinate((int)(0.5*gameMaker.getGamePanel().getWidth()));
				int savedWidth = spritePaddleElement.getWidth();
				int savedHeight = spritePaddleElement.getHeight();
				spritePaddleElement.setWidth(savedHeight);
				spritePaddleElement.setHeight(savedWidth);
				spriteBrickElement.setyCoordinate((int)(gameMaker.getGamePanel().getHeight()-0.1*gameMaker.getGamePanel().getHeight()));
				spriteBrickElement.setxCoordinate((int)(0.5*gameMaker.getGamePanel().getWidth()));
				//gameMaker.getGamePanel().draw(gameMaker.getGameState().getSpriteList());				
			}

		}			
		
	}

}
