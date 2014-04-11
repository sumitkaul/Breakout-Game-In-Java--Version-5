package game.maker;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


import utility.GameState;
import view.DesignPanel;
import view.GamePanel;


public class GameMaker extends JFrame {	

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private GamePanel gamePanel;	
private DesignPanel designPanel;
private GameState gameState;
private JPanel mainPanel;
private boolean firstTime=true;

public boolean isFirstTime() {
	return firstTime;
}
public void setFirstTime(boolean firstTime) {
	this.firstTime = firstTime;
}
public GameMaker(){
	
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("GameMaker");
	this.setVisible(true);
	this.setSize(1000,1000);
		
	designPanel=new DesignPanel(this);
	gamePanel=new GamePanel(this,designPanel);
	setGameState(new GameState());
	designPanel.getDesignPanel().validate();
	JPanel mainPanel=new JPanel(new GridLayout(1,2));
	mainPanel.add(designPanel.getDesignPanel());
	gamePanel.setVisible(true);
	mainPanel.add(gamePanel);				
	mainPanel.setVisible(true);
	this.setContentPane(mainPanel);
	mainPanel.validate();
	this.validate();
}
public static void main(String args[]){
	new GameMaker();
}


public DesignPanel getDesignPanelClass(){
	return designPanel;
}


/*private final void init(){
	setGamePanel(new GamePanel());
	gamePanel=new GamePanel();
	
	setDesignPanel(new DesignPanel(this));
	setGameState(new GameState());
	setMainPanel(new JPanel(new GridLayout(1,2)));
}*/

public JPanel getMainPanel() {
	return mainPanel;
}

public void setMainPanel(JPanel mainPanel) {
	this.mainPanel = mainPanel;
}

public GameState getGameState() {
	return gameState;
}


public void setGameState(GameState gameState) {
	this.gameState = gameState;
}

public GamePanel getGamePanel() {
	return gamePanel;
}

public void setGamePanel(GamePanel gamePanel) {
	this.gamePanel = gamePanel;
}

public DesignPanel getDesignPanel() {
	return designPanel;
}

public void setDesignPanel(DesignPanel designPanel) {
	this.designPanel = designPanel;
}

}												