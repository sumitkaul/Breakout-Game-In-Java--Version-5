package control;

import game.maker.GameMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.PropertyConfigurator;

import view.DesignPanel;

public class ActionEventController implements ActionListener {

	//private GameMaker gameMaker;
	private DesignPanel designPanel;
	//private CollisionClass collisionClass;
    private static final org.apache.log4j.Logger LOG =
            org.apache.log4j.Logger.getLogger(ActionEventController.class);
	
	//private List<CollisionClass> collisionEventList=new ArrayList<CollisionClass>();
	
	
	
	//public List<CollisionClass> getCollisionEventList() {
    //		return collisionEventList;
	//}


	//public void setCollisionEventList(List<CollisionClass> collisionEventList) {
//		this.collisionEventList = collisionEventList;
	//}


	public ActionEventController(GameMaker gameMaker,DesignPanel designPanel){
		this.designPanel=designPanel;
		//this.gameMaker=gameMaker;
		//PropertyConfigurator.configure("resources/log4j.properties");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String text=e.getActionCommand();
		
		if(text.equalsIgnoreCase("Add Event")){
			
			if((designPanel.getActionEventPanelClass().getSpriteEventBox().getSelectedItem()!=null) && (designPanel.getActionEventPanelClass().getSpriteActionBox().getSelectedItem()!=null)){
			
				
			if(designPanel.getActionEventPanelClass().getSpriteEventBox().getSelectedItem().equals(designPanel.getActionEventPanelClass().getSpriteActionBox().getSelectedItem())){
				
				JOptionPane.showMessageDialog(null, "Choose different Values in Both the lists");
			}
			
			else{
				designPanel.getGameStartPanelClass().getPlayGame().setEnabled(true);
				
				if((designPanel.getActionEventPanelClass().getEventBox().getSelectedItem()=="Collision")
					||	(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Bounce")
					||	(designPanel.getActionEventPanelClass().getActionListBox().getSelectedItem()=="Brick Disappear")){
					
		//          CollisionClass collisionClass=new CollisionClass(designPanel.getActionEventPanelClass().getSpriteEventBox(),designPanel.getActionEventPanelClass().getActionListBox(),designPanel.getActionEventPanelClass().getSpriteActionBox());
		//			collisionEventList.add(collisionClass);
					
		//			for(int i=0;i<collisionEventList.size();i++)
		//		LOG.info(collisionEventList.get(i).getActionListBox().getSelectedItem()+"  ");
				}				
				
			}
				
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Choose sprites in Action-Event lists");
			}
			
			
			}
			
			
			
			
			
		}
		
		
		
		
		
	}


