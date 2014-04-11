package view;
import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DesignPanel{

	private GameMaker gameMaker;
	private JPanel designPanel;
	private GameStartPanel gameStartPanel;
	private SpritePanel spritePanel;
	private ActionEventPanel actionEventPanel;
	private SpriteCreatePanel spriteCreatePanel;
	public DesignPanel(GameMaker gameMaker){
		this.gameMaker=gameMaker;
		designPanel=new JPanel();
		designPanel.setSize(400,800);
		designPanel.setLayout(new GridLayout(4,1));
		designPanel.setBorder(BorderFactory.createTitledBorder(null,"GameMaker",0,0,null,Color.BLACK));
		gameStartPanel=new GameStartPanel(gameMaker,this);
		designPanel.add(gameStartPanel.getGameStartPanel());
		spriteCreatePanel=new SpriteCreatePanel(this);
		designPanel.add(spriteCreatePanel.getSpriteCreatePanel());
		spritePanel=new SpritePanel(gameMaker,this);
		designPanel.add(spritePanel.getSpritePanel());
		actionEventPanel=new ActionEventPanel(gameMaker,this);
		designPanel.add(actionEventPanel.getActionEventPanel());
	
	
	}
	
	public JPanel getDesignPanel(){
		
		return designPanel;
	}
	
	public GameStartPanel getGameStartPanelClass(){
		return  gameStartPanel;
	}

	public SpritePanel getSpritePanelClass(){
		return spritePanel;
	}
	
	public ActionEventPanel getActionEventPanelClass(){
		
		return actionEventPanel;
	}
	
	public SpriteCreatePanel getSpriteCreatePanelClass(){
		return spriteCreatePanel;
	}
	
	
}