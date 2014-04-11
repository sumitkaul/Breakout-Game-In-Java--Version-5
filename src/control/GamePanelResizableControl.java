package control;

import game.maker.GameMaker;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import org.apache.log4j.PropertyConfigurator;

import view.GamePanel;



public class GamePanelResizableControl implements ComponentListener {
	private int lastWidth=1;
	private int lastHeight=1;
	private GameMaker gameMaker;
	private GamePanel gamePanel; 
	private double resizeFactorX;
	private double resizeFactorY;
    private static final org.apache.log4j.Logger LOG =
            org.apache.log4j.Logger.getLogger(GameStartControl.class);

	public GamePanelResizableControl(GamePanel gamePanel, GameMaker gameMaker) {
		this.gamePanel = gamePanel;
		this.gameMaker = gameMaker;
		//PropertyConfigurator.configure("resources/log4j.properties");
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {

			if(lastWidth==1 && lastHeight==1){
				resizeFactorX=1;
				resizeFactorY=1;
			}
			else{
		 resizeFactorX = (double)(gamePanel.getWidth())/(double)(lastWidth);
		 resizeFactorY = (double)(gamePanel.getHeight())/(double)(lastHeight);
			}
		
		lastWidth = gamePanel.getWidth();
		lastHeight = gamePanel.getHeight();
		
		gamePanel.refactorSprites(resizeFactorX,resizeFactorY);
	
		//LOG.info(resizeFactor);
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

}