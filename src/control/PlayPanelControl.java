package control;

import game.maker.GameMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DesignPanel;



public class PlayPanelControl implements ActionListener {


	private GameMaker gameMaker;
	private DesignPanel designPanel;
	
	public PlayPanelControl(GameMaker gameMaker,DesignPanel designPanel){
		this.gameMaker=gameMaker;
		this.designPanel=designPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonText=e.getActionCommand();
		 if(buttonText.equalsIgnoreCase("Play")){
			gameMaker.getGamePanel().setSpriteUpdatable(true);
			designPanel.getGameStartPanelClass().getPauseGame().setEnabled(true);
			designPanel.getGameStartPanelClass().getRebuildGame().setEnabled(true);
	
		 if(gameMaker.getGamePanel().isLoadButtonPressed()){
			 if(!designPanel.getSpritePanelClass().getSpritePanelControl().getTimer().isRunning()){
				 
				 gameMaker.getGamePanel().setIsSetSpriteButtonPressed(true);
				 designPanel.getSpritePanelClass().getSpritePanelControl().getTimer().start();
			 }
		 }
		 
		 }
		
		 if(buttonText.equalsIgnoreCase("Pause/Resume")){
			
			 if(designPanel.getSpritePanelClass().getSpritePanelControl().getTimer().isRunning())
			 designPanel.getSpritePanelClass().getSpritePanelControl().getTimer().stop();
			 
			 else
				 designPanel.getSpritePanelClass().getSpritePanelControl().getTimer().start();	 
			 
			 
				}
				
		 
		 if(buttonText.equalsIgnoreCase("Rebuild")){
			 gameMaker.getDesignPanel().getSpritePanelClass().getSpritePanelControl().getTimer().stop();
			 gameMaker.getGamePanel().getSpriteList().clear();
			 gameMaker.getGamePanel().setIsSetSpriteButtonPressed(false);
		 }
		 
		 
	}

}
