package gui;

import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePreviewPanel {
	private JPanel gamePreviewPanel;
	private GamePlayPanel gamePlayPanel;
	private JPanel buttonGamePlayPanel;
	
	private GameMaker gameMaker;
	
	private JButton buttonStartGame;
	private JButton buttonPauseGame;
	private JButton buttonChangeBackgrounde;
	
	
	
//	public SpritePanel(GameMaker gameMaker,DesignGamePanel designGamePanel)
	public GamePreviewPanel()
	{
		this.gameMaker=gameMaker;
		this.gamePreviewPanel= new JPanel();
		this.gamePlayPanel= GamePlayPanel.getInstance();
		this.buttonGamePlayPanel = new JPanel();
		
		buttonStartGame = new JButton("Start");
		buttonStartGame.setVisible(true);
		//buttonCreateSprite.addActionListener(this);	// add actionlistners
		buttonPauseGame = new JButton("Pause");
		buttonPauseGame.setVisible(true);
		//buttonModifySprite.addActionListener(this);	// add actionlistners
		buttonChangeBackgrounde = new JButton("Change Background");
		buttonChangeBackgrounde.setVisible(true);
		//buttonRemoveSprite.addActionListener(this);	// add actionlistners
		
        
		buttonGamePlayPanel.setLayout(new BoxLayout(buttonGamePlayPanel,BoxLayout.LINE_AXIS));
		buttonGamePlayPanel.add(buttonStartGame);
		buttonGamePlayPanel.add(buttonPauseGame);
		buttonGamePlayPanel.add(buttonChangeBackgrounde);
        
		gamePreviewPanel.setLayout(new GridLayout(2,1));
		gamePreviewPanel.add(gamePlayPanel);
		gamePreviewPanel.add(buttonGamePlayPanel);
        
        
		gamePreviewPanel.setSize(400, 200);	
		gamePreviewPanel.setBackground(Color.LIGHT_GRAY);
		gamePreviewPanel.setBorder(BorderFactory.createTitledBorder(null,"Game Preview",0,0,null,Color.BLACK));
		//gamePreviewPanel.setLayout(new GridLayout(1,4));
		gamePreviewPanel.validate();
		
		gamePreviewPanel.setVisible(true);
		

	}
	
	
	public JPanel getGamePreviewPanel(){
		return gamePreviewPanel;
	}

	

}
