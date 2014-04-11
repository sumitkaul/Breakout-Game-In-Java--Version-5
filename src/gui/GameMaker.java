package gui;

import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utility.GameState;


public class GameMaker {	

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private JFrame gameMaker;	

private JPanel previewPanel;	
private DesignGamePanel designGamePanel;

private JPanel gameMakerPanel;
private GamePreviewPanel gamePreviewPanel;
private GameState gameState;
private SpritePanel spritePanel;
private ActionEventPanel actionEventPanel;
private EventButtonsPanel eventButtonsPanel;


public GameMaker()
{
	this.gameMaker = new JFrame();
	this.gameMakerPanel = new JPanel(new GridLayout(1,2));
	this.previewPanel = new  JPanel();
	this.previewPanel.setSize(200, 400);
	this.previewPanel.setVisible(true);
	this.gamePreviewPanel = new GamePreviewPanel();
	this.spritePanel = new SpritePanel();
	this.actionEventPanel = new ActionEventPanel();
	this.eventButtonsPanel = new EventButtonsPanel();
	
	gameMaker.setLayout((new GridLayout(1,2)));
	
	gameMaker.getContentPane().add(gamePreviewPanel.getGamePreviewPanel());
	gameMaker.getContentPane().add(gameMakerPanel);
	
	MenuBar menuBar = new MenuBar();
	Menu game = new Menu("Game");
	MenuItem newGame = new MenuItem("New ");
	MenuItem saveGame = new MenuItem("Save ");
	MenuItem loadGame = new MenuItem("Load ");
	menuBar.add(game);
	game.add(newGame);
	game.add(loadGame);
	game.add(saveGame);
	
	gameMakerPanel.setLayout((new GridLayout(3,1)));
	gameMakerPanel.add(spritePanel.getSpritePanel());
	gameMakerPanel.add(actionEventPanel.getActionEventPanel());
	gameMakerPanel.add(eventButtonsPanel.getEventButtonsPanel());
	
	//previewPanel.add();
	
	gameMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gameMaker.setTitle("GameMaker");
	gameMaker.setVisible(true);
	gameMaker.setSize(1000,1000);
	gameMaker.setMenuBar(menuBar);
	gameMaker.validate();
		
}
public static void main(String args[]){
	new GameMaker();
}

public GameState getGameState() {
	return gameState;
}


public void setGameState(GameState gameState) {
	this.gameState = gameState;
}

}												