package view;
import game.maker.GameMaker;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameStartControl;
import control.PlayPanelControl;


public class GameStartPanel{

	private GameMaker gameMaker;
	private JButton createGame;
	private JButton saveGame;
	private JButton loadGame;
	private JButton setBackground;
	private JPanel gameStartPanel;
	private JButton changeLayout;
	private GameStartControl gameStartControl;
	private DesignPanel designPanel;
	private JButton playGame,pauseGame,rebuildGame;
	private PlayPanelControl playPanelControl;
	
	
	
	public GameStartPanel(GameMaker gameMaker,DesignPanel designPanel){
		this.gameMaker=gameMaker;
		this.designPanel=designPanel;
		gameStartPanel=new JPanel();
		gameStartPanel.setSize(400,200);
	//	gameStartPanel.setBorder(BorderFactory.createTitledBorder(null,"Game Buttons",0,0,null,Color.BLACK));
		gameStartPanel.setBackground(Color.LIGHT_GRAY);
		
		gameStartControl=new GameStartControl(gameMaker,designPanel);
		
		playPanelControl=new PlayPanelControl(gameMaker,designPanel);
		
		createGame=new JButton("Create Game");
		createGame.setToolTipText("Creates a new Game");
		saveGame=new JButton("Save Game");
		saveGame.setToolTipText("Saves the game for use next time");
		saveGame.setEnabled(false);
		loadGame=new JButton("Load Game");
		loadGame.setToolTipText("Loads the game");
		setBackground=new JButton("Set Background");
		setBackground.setToolTipText("Sets the Background for the Game Panel");
		changeLayout=new JButton("Change Layout");
		changeLayout.setEnabled(false);
		
		playGame=new JButton("Play");
		playGame.setEnabled(false);

		pauseGame=new JButton("Pause/Resume");
		pauseGame.setEnabled(false);
		

		rebuildGame=new JButton("Rebuild");
		rebuildGame.setEnabled(false);
		
		
		
		createGame.addActionListener(gameStartControl);
		saveGame.addActionListener(gameStartControl);
		loadGame.addActionListener(gameStartControl);
		setBackground.addActionListener(gameStartControl);
		changeLayout.addActionListener(gameStartControl);
		
		gameStartPanel.add(createGame);
		gameStartPanel.add(saveGame);
		gameStartPanel.add(loadGame);
		gameStartPanel.add(setBackground);
		gameStartPanel.add(changeLayout);
		gameStartPanel.add(playGame);
		gameStartPanel.add(pauseGame);
		gameStartPanel.add(rebuildGame);
		
		
		
		playGame.addActionListener(playPanelControl);
		pauseGame.addActionListener(playPanelControl);
		rebuildGame.addActionListener(playPanelControl);
		
	}
	
	
	public JButton getCreateGame() {
		return createGame;
	}

	
	public void setChangeLayoutButtonEnabled(){
		
		changeLayout.setEnabled(true);
	}
	

	public void setCreateGame(JButton createGame) {
		this.createGame = createGame;
	}


	public JButton getPlayGame() {
		return playGame;
	}


	public void setPlayGame(JButton playGame) {
		this.playGame = playGame;
	}


	public JButton getPauseGame() {
		return pauseGame;
	}


	public void setPauseGame(JButton pauseGame) {
		this.pauseGame = pauseGame;
	}


	public JButton getRebuildGame() {
		return rebuildGame;
	}


	public void setRebuildGame(JButton rebuildGame) {
		this.rebuildGame = rebuildGame;
	}


	public PlayPanelControl getPlayPanelControl() {
		return playPanelControl;
	}


	public void setPlayPanelControl(PlayPanelControl playPanelControl) {
		this.playPanelControl = playPanelControl;
	}


	public JPanel getGameStartPanel(){
		
		return gameStartPanel; 
	}

	
	
	public JButton getSaveGame(){
		return saveGame;
	}
	
	
}
