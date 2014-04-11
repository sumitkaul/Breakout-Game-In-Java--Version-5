package control;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.GamePanel;



import model.SpriteModelObject;

public class KeyMouseController implements KeyEventDispatcher,MouseListener,MouseMotionListener{

	private GamePanel gamePanel;
	private boolean isInsideSprite;
	
	public boolean isInsideSprite() {
		return isInsideSprite;
	}

	public void setInsideSprite(boolean isInsideSprite) {
		this.isInsideSprite = isInsideSprite;
	}

	private SpriteModelObject createSpriteClass;
	
	private int countleft=0,countright=0;
	public KeyMouseController(GamePanel gamePanel,SpriteModelObject createSpriteClass){
		this.createSpriteClass=createSpriteClass;
		this.gamePanel=gamePanel;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		
		if((e.getID()==KeyEvent.KEY_PRESSED)  && (createSpriteClass.getSpriteActionType().equalsIgnoreCase("Keyboard Events"))){
			
				if(e.getKeyCode()==KeyEvent.VK_LEFT && createSpriteClass.getUnaryEvents().contains("Left Arrow") ){
					countleft++;
					createSpriteClass.setxCoordinate(createSpriteClass.getxCoordinate()-(1/countleft));
					if(createSpriteClass.getxCoordinate()<=0)
						createSpriteClass.setxCoordinate(0);
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT && createSpriteClass.getUnaryEvents().contains("Right Arrow") ){
					countright++;
					createSpriteClass.setxCoordinate(createSpriteClass.getxCoordinate()+(1/countright));	
					if(createSpriteClass.getxCoordinate()>=500-(createSpriteClass.getWidth()))
						createSpriteClass.setxCoordinate(500-(createSpriteClass.getWidth()));
				
				}
				if(e.getKeyCode()==KeyEvent.VK_UP && createSpriteClass.getUnaryEvents().contains("Top Arrow") ){
					createSpriteClass.setyCoordinate(createSpriteClass.getyCoordinate()-1);	
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN && createSpriteClass.getUnaryEvents().contains("Bottom Arrow") ){
					createSpriteClass.setyCoordinate(createSpriteClass.getyCoordinate()+1);	
				}		
		}
		return false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(!gamePanel.isSpriteUpdatable())
		{
		if(isInsideSprite){
			createSpriteClass.setxCoordinate(e.getX());
			createSpriteClass.setyCoordinate(e.getY());
		}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0){
		
	try{
			
			
		}catch(Exception e){}
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0){}

	@Override
	public void mouseEntered(MouseEvent arg0){
		
		try{
			
			
		}catch(Exception e){}
	
	}

	@Override
	public void mouseExited(MouseEvent arg0){
		
	try{
			
			
		}catch(Exception e){}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(!gamePanel.isSpriteUpdatable())
		{
		
		if((e.getX()>=createSpriteClass.getxCoordinate()) && (e.getX()<=(createSpriteClass.getxCoordinate()+createSpriteClass.getWidth()))){
			if((e.getY()>=createSpriteClass.getyCoordinate() && e.getY()<=(createSpriteClass.getyCoordinate()+createSpriteClass.getHeight()  )  )){
			isInsideSprite=true;
		}
		}
		
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		if(!gamePanel.isSpriteUpdatable())
		{
		isInsideSprite=false;
	}
	}
}