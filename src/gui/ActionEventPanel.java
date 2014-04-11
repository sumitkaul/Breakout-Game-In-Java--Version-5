package gui;

import game.maker.GameMaker;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import control.SpritePanelControl;


public class ActionEventPanel 
{

	private JPanel actionEventPanel,eventsPanel,actionsPanel,EventAndActionsPanel,radioButtonsPannel;
	private GameMaker gameMaker;
	private List<String>listGameEvents = new ArrayList(0);
	private List<String>listGameActions = new ArrayList(0);
	private List<String>listGameEventsAndActions = new ArrayList(0);

	private DesignGamePanel designGamePanel;
	private JLabel eventsLable;
	private JLabel actionsLable;
	private JLabel eventsandActionsLable;
	private JScrollPane listGameEventsScrollPane;
	private JScrollPane listGameActionsScrollPane;
	private ButtonGroup buttonGroupEvents;
	private JRadioButton radioButtonEventColliosionWalls;
	private JRadioButton radioButtonEventColliosionObject;
	private JRadioButton radioButtonEventkeyPressed;
	private JRadioButton radioButtonEventMouseClicked;
	private JRadioButton radioButtonEventTimerTicked;
	private JCheckBox checkBoxBounce;
	private JCheckBox checkBoxSound;
	private JCheckBox checkBoxGameOver;
	private JCheckBox checkBoxStop;
	private JCheckBox checkBoxMoveRight;
	private JCheckBox checkBoxMoveLeft;
	private JCheckBox checkBoxMoveUp;
	private JCheckBox checkBoxMoveDown;
	private JCheckBox checkBoxShoot;
	private JPanel checkBoxPannel;
	private DefaultListModel listModelActionAndEvent;
	private JList listActionAndEvent;
	private JScrollPane actionAndEventScrollPane;



	//	public SpritePanel(GameMaker gameMaker,DesignGamePanel designGamePanel)
	public ActionEventPanel()
	{
		this.gameMaker=gameMaker;
		this.designGamePanel=designGamePanel;
		this.actionEventPanel= new JPanel();
		this.eventsPanel =  new JPanel();
		this.actionsPanel =  new JPanel();
		this.EventAndActionsPanel =  new JPanel();
		this.buttonGroupEvents = new ButtonGroup();

		eventsLable = new JLabel("Events List");
		actionsLable = new JLabel("Actions List");
		eventsandActionsLable = new JLabel("Events-Actions List");

		//Events
		radioButtonEventColliosionWalls = new JRadioButton("Wall Collision");
		radioButtonEventColliosionObject = new JRadioButton("Objects Collision");
		radioButtonEventkeyPressed = new JRadioButton("Key Pressed");
		radioButtonEventMouseClicked = new JRadioButton("Mouse Clicked");
		radioButtonEventTimerTicked = new JRadioButton("Timer Ticked");

		buttonGroupEvents.add(radioButtonEventColliosionWalls);
		buttonGroupEvents.add(radioButtonEventColliosionObject);
		buttonGroupEvents.add(radioButtonEventkeyPressed);
		buttonGroupEvents.add(radioButtonEventMouseClicked);
		buttonGroupEvents.add(radioButtonEventTimerTicked);

		radioButtonsPannel = new JPanel();
		radioButtonsPannel.setLayout(new BoxLayout(radioButtonsPannel,BoxLayout.PAGE_AXIS ));
		radioButtonsPannel.add(radioButtonEventColliosionWalls);
		radioButtonsPannel.add(radioButtonEventColliosionObject);
		radioButtonsPannel.add(radioButtonEventkeyPressed);
		radioButtonsPannel.add(radioButtonEventMouseClicked);
		radioButtonsPannel.add(radioButtonEventTimerTicked);
		listGameEventsScrollPane = new JScrollPane(radioButtonsPannel);
		listGameEventsScrollPane.setVisible(true);
		listGameEventsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		eventsPanel.setLayout(new BoxLayout(eventsPanel,BoxLayout.PAGE_AXIS ));
		eventsPanel.add(eventsLable);
		eventsPanel.add(listGameEventsScrollPane);

		//Actions

		checkBoxSound = new JCheckBox("Sound");
		checkBoxBounce = new JCheckBox("Bounce");
		checkBoxGameOver = new JCheckBox("GameOver");
		checkBoxStop = new JCheckBox("Stop");
		checkBoxMoveLeft = new JCheckBox("Move Left");
		checkBoxMoveRight = new JCheckBox("Move Right");
		checkBoxMoveUp = new JCheckBox("Move Up");
		checkBoxMoveDown = new JCheckBox("Move Down");
		checkBoxShoot = new JCheckBox("Shoot");

		checkBoxPannel = new JPanel();
		checkBoxPannel.setLayout(new BoxLayout(checkBoxPannel,BoxLayout.PAGE_AXIS ));

		checkBoxPannel.add(checkBoxSound);
		checkBoxPannel.add(checkBoxBounce);
		checkBoxPannel.add(checkBoxGameOver);
		checkBoxPannel.add(checkBoxStop );
		checkBoxPannel.add(checkBoxMoveLeft );
		checkBoxPannel.add(checkBoxMoveRight );
		checkBoxPannel.add(checkBoxMoveUp );
		checkBoxPannel.add(checkBoxMoveDown );
		checkBoxPannel.add(checkBoxShoot );

		listGameActionsScrollPane = new JScrollPane(checkBoxPannel);
		listGameActionsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		actionsPanel.setLayout(new BoxLayout(actionsPanel,BoxLayout.PAGE_AXIS ));
		actionsPanel.add(actionsLable);
		actionsPanel.add(listGameActionsScrollPane);

		//action-event Panel

		listModelActionAndEvent = new DefaultListModel();
		listGameEventsAndActions.add("a & e");
		for (String temp : listGameEventsAndActions) {
			listModelActionAndEvent.addElement(temp);
		}
		listActionAndEvent = new JList(listModelActionAndEvent);
		listActionAndEvent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listActionAndEvent.setSelectedIndex(0);
		// listActionAndEvent.addListSelectionListener(this);
		listActionAndEvent.setVisibleRowCount(5);
		actionAndEventScrollPane = new JScrollPane(listActionAndEvent);
		actionAndEventScrollPane.setSize(200, 400);
		
		EventAndActionsPanel.setLayout(new BoxLayout(EventAndActionsPanel,BoxLayout.PAGE_AXIS ));
		EventAndActionsPanel.add(eventsandActionsLable);
		EventAndActionsPanel.add(actionAndEventScrollPane);



		actionEventPanel.add(eventsPanel);
		actionEventPanel.add(actionsPanel);
		actionEventPanel.add(EventAndActionsPanel);

		//        
		actionEventPanel.setSize(400, 200);	
		actionEventPanel.setBackground(Color.LIGHT_GRAY);
		actionEventPanel.setBorder(BorderFactory.createTitledBorder(null,"Events-Actions",0,0,null,Color.BLACK));
		actionEventPanel.setLayout(new GridLayout(1,3));
		actionEventPanel.validate();

		actionEventPanel.setVisible(true);


	}


	public JPanel getActionEventPanel(){
		return actionEventPanel;
	}

	//
	//	public JLabel getSpriteShapeLabel() {
	//		return spriteShapeLabel;
	//	}
	//
	//
	//	public JLabel getSpriteSetWidthLabel() {
	//		return spriteSetWidthLabel;
	//	}
	//
	//
	//	public JLabel getSpriteSetHeightLabel() {
	//		return spriteSetHeightLabel;
	//	}
	//
	//	public JComboBox getSpriteShapeBox() {
	//		return spriteShapeBox;
	//	}
	//
	//	public JSlider getSpriteSetWidthSlider() {
	//		return spriteSetWidthSlider;
	//	}
	//
	//	public JSlider getSpriteSetHeightSlider() {
	//		return spriteSetHeightSlider;
	//	}
	//
	//	public JButton getSetSprite() {
	//		return setSprite;
	//	}
	//
	//	public SpritePanelControl getSpritePanelControl() {
	//		return spritePanelControl;
	//	}	
	//	
	//	public String[] getSpriteShapesString(){
	//		return spriteShapes;
	//	}
	//	
	//	public void setXCoordinate(int xCoordinate){
	//		this.xCoordinate=xCoordinate;
	//	}
	//	
	//	public int getXCoordinate(){
	//		return xCoordinate;
	//	}
	//	
	//	public void setYCoordinate(int yCoordinate){
	//		this.yCoordinate=yCoordinate;
	//	}
	//	
	//	public int getYCoordinate(){
	//		return yCoordinate;
	//	}
	//	
	//	public int getSpriteWidthValue(){
	//		return spriteSetWidthSlider.getValue();
	//	}
	//	
	//	public int getSpriteHeightValue(){
	//		return spriteSetHeightSlider.getValue();
	//	}
	//	
	//	
}
