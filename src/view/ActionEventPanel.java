package view;

import game.maker.GameMaker;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

import control.ActionEventController;


public class ActionEventPanel {

	private DesignPanel designPanel;
	private JPanel actionEventPanel;
	public void setActionEventPanel(JPanel actionEventPanel) {
		this.actionEventPanel = actionEventPanel;
	}

	private JList spriteList;
	private JButton addEventButton;
	private JComboBox eventBox; 
	private JList eventList;
	private GameMaker gameMaker;
	private JComboBox spriteEventBox;
	private JComboBox spriteActionBox;
	private String[] spriteEventTypes=new String[10];
	private JComboBox actionListBox;
	private String[] actionTypes={"Bounce","No Bounce","Brick Disappear"};
	
	public JButton getAddEventButton() {
		return addEventButton;
	}

	public void setAddEventButton(JButton addEventButton) {
		this.addEventButton = addEventButton;
	}

	public JComboBox getEventBox() {
		return eventBox;
	}

	
	public void setEventBox(JComboBox eventBox) {
		this.eventBox = eventBox;
	}

	public ActionEventController getActionEventPanelControl() {
		return actionEventPanelControl;
	}

	public void setActionEventPanelControl(
			ActionEventController actionEventPanelControl) {
		this.actionEventPanelControl = actionEventPanelControl;
	}

	private String eventTypes[]={"Collision","No Collision"};
	private ActionEventController actionEventPanelControl;
	
	public ActionEventPanel(GameMaker gameMaker,DesignPanel designPanel){
		actionEventPanelControl=new ActionEventController(gameMaker,designPanel);
		this.gameMaker=gameMaker;
		this.designPanel=designPanel;
		actionEventPanel=new JPanel();
		actionEventPanel.setSize(400,200);
		actionEventPanel.setBackground(Color.LIGHT_GRAY);
		//actionEventPanel.setBorder(BorderFactory.createTitledBorder(null,"Action-Events",0,0,null,Color.BLACK));
	
		
		
		eventBox=new JComboBox(eventTypes);
		eventBox.setVisible(true);
		addEventButton=new JButton("Add Event");
		addEventButton.setVisible(true);
		addEventButton.addActionListener(actionEventPanelControl);

		spriteEventBox=new JComboBox(spriteEventTypes);
		spriteEventBox.setVisible(false);
		
		actionListBox=new JComboBox(actionTypes);
		actionEventPanel.add(spriteEventBox);
		actionEventPanel.add(eventBox);
		actionEventPanel.add(actionListBox);
		actionEventPanel.add(addEventButton);
		
		spriteActionBox=new JComboBox(spriteEventTypes);
		spriteActionBox.setVisible(false);
		actionEventPanel.add(spriteActionBox);
		actionEventPanel.setVisible(false);
		
		
	}
	
	public JComboBox getActionListBox() {
		return actionListBox;
	}

	public void setActionListBox(JComboBox actionListBox) {
		this.actionListBox = actionListBox;
	}

	public JComboBox getSpriteActionBox() {
		return spriteActionBox;
	}

	public void setSpriteActionBox(JComboBox spriteActionBox) {
		this.spriteActionBox = spriteActionBox;
	}

	public String[] getSpriteEventTypes() {
		return spriteEventTypes;
	}

	public void setSpriteEventTypes(String[] spriteEventTypes) {
		this.spriteEventTypes = spriteEventTypes;
	}

	public JComboBox getSpriteEventBox() {
		return spriteEventBox;
	}

	public void setSpriteEventBox(JComboBox spriteEventBox) {
		this.spriteEventBox = spriteEventBox;
	}

	public JPanel getActionEventPanel(){
		return actionEventPanel;
	}

/*	public DefaultComboBoxModel getModel() {
		return model;
	}	*/
}
