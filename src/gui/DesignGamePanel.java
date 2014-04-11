package gui;

import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class DesignGamePanel 
{
	private GameMaker gameMaker;
	
	private JPanel designGamePanel ;
	private ActionEventPanel actionEventPanel;
	private SpritePanel spritePanel;
	
	public DesignGamePanel(GameMaker gameMaker)
	{
		this.gameMaker=gameMaker;
		designGamePanel =new JPanel();
		designGamePanel.setSize(400,800);
		designGamePanel.setLayout(new GridLayout(4,1));
		designGamePanel.setBorder(BorderFactory.createTitledBorder(null,"GameMaker",0,0,null,Color.BLACK));
		
		//spritePanel = new SpritePanel(gameMaker,this);
		designGamePanel.add(spritePanel.getSpritePanel());
		//actionEventPanel=new ActionEventPanel(gameMaker,this);
		designGamePanel.add(actionEventPanel.getActionEventPanel());
	
	}
	
	
	
	public SpritePanel getSpritePanelClass()
	{
		return spritePanel;
	}
	
	public ActionEventPanel getActionEventPanelClass()
	{
		
		return actionEventPanel;
	}
	
	
}
