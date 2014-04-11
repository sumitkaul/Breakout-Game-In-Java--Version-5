package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import view.SpriteViewObject;
import control.SpriteManager;

public class GamePlayPanel extends JPanel {

	/**
	 * 
	 */
	//private Image image;
	private  Graphics buffer;
	private Logger log = Logger.getLogger(GamePlayPanel.class);
	private static final long serialVersionUID = 1L;
	private static GamePlayPanel gameBoard;
	
	public static GamePlayPanel getInstance()
	{
		if(gameBoard==null){
			gameBoard= new GamePlayPanel();
			}
		return gameBoard;
	}
	
	public GamePlayPanel() {
		super.setSize(700, 700);
		
		this.setVisible(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d= (Graphics2D) g;
		this.drawAllSprites(g2d);
		}
	
	public void draw()
	{
		repaint();
	}
	
	public void  drawAllSprites(Graphics2D g)
	{
		log.info("drawAllSprites");
		ArrayList<SpriteViewObject> spriteViewList=(ArrayList)SpriteManager.getInstance().getSpriteViewList();
		for(int i=0;i<spriteViewList.size();i++)
		{
			spriteViewList.get(i).draw(g);
		}
	}
	
	
}
