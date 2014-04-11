package view;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import control.SpriteCreatePanelControl;


public class SpriteCreatePanel {

	
	private JPanel spriteCreatePanel;
	private JLabel spriteLabel;
	private JComboBox spriteBox;
	private JLabel actionLabel;
	private JComboBox actionBox;
	private JSlider velXSlider;
	private DefaultListModel listModel;
	private JSlider velYSlider;
	private JList keyList;
	private JList addedKeysList;
	private JButton addKeys;
	private JLabel setVelXLabel;
	private JLabel setVelYLabel;
	private JScrollPane keyListScroll; 
	private String[] spriteTypes={"Ball","Paddle","Brick"};
	private String[] actionTypes={"No Action","Move","Keyboard Events"};
	private String[] keyTypes={"Left Arrow","Right Arrow","Top Arrow","Bottom Arrow"};
	private GridBagConstraints gridBagConstraints=new GridBagConstraints();
	private DesignPanel designPanel;
	private SpriteCreatePanelControl spriteCreatePanelControl;
	
	public SpriteCreatePanel(DesignPanel designPanel){
		this.designPanel=designPanel;
		spriteCreatePanelControl=new SpriteCreatePanelControl(designPanel);
		spriteCreatePanel=new JPanel();
		spriteCreatePanel.setSize(400,200);
		spriteCreatePanel.setBackground(Color.LIGHT_GRAY);
	//	spriteCreatePanel.setBorder(BorderFactory.createTitledBorder(null,"Creating Sprites",0,0,null,Color.BLACK));
		
		spriteCreatePanel.setLayout(new GridBagLayout());
		
		
		spriteLabel=new JLabel("Select the type of Sprite you want:");
		spriteBox=new JComboBox(spriteTypes);
		spriteBox.setToolTipText("Select Sprites from here");
		
		
		actionLabel=new JLabel("Select the action for Sprite:");
		actionBox=new JComboBox(actionTypes);
		
		//Buttons for Move option
		
		setVelXLabel=new JLabel("Set the Velocity X:");
		setVelXLabel.setVisible(false);
		setVelYLabel=new JLabel("Set The Velocity Y:");
		setVelYLabel.setVisible(false);
		velXSlider=new JSlider(SwingConstants.HORIZONTAL,-5,5,0);
		velXSlider.setMajorTickSpacing(10);
		velXSlider.setVisible(false);
		velYSlider=new JSlider(SwingConstants.HORIZONTAL,-5,5,0);
		velYSlider.setMajorTickSpacing(10);
		velYSlider.setVisible(false);
		
		
		//Buttons for Keyboard Event option
		keyList=new JList(keyTypes);
		keyList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		keyList.setBackground(Color.WHITE);
		keyList.setVisible(false);
		keyListScroll=new JScrollPane(keyList);
		addKeys=new JButton("Add Keys");
		addKeys.setVisible(false);
		
		listModel=new DefaultListModel();
		addedKeysList=new JList(listModel);
		addedKeysList.setBackground(Color.WHITE);
		addedKeysList.setVisible(false);
		
		
		setGrids(1,0,1,1);	
		spriteCreatePanel.add(spriteLabel,this.gridBagConstraints);
		setGrids(2,0,1,1);
		spriteCreatePanel.add(spriteBox,this.gridBagConstraints);
		setGrids(1,1,1,1);
		spriteCreatePanel.add(actionLabel,this.gridBagConstraints);
		setGrids(2,1,1,1);
		spriteCreatePanel.add(actionBox,this.gridBagConstraints);
		setGrids(1,2,1,1);
		spriteCreatePanel.add(setVelXLabel,this.gridBagConstraints);
		setGrids(2,2,1,1);
		spriteCreatePanel.add(setVelYLabel,this.gridBagConstraints);
		setGrids(1,3,1,1);
		spriteCreatePanel.add(velXSlider,this.gridBagConstraints);
		setGrids(2,3,1,1);
		spriteCreatePanel.add(velYSlider,this.gridBagConstraints);
		setGrids(1,3,1,1);
		spriteCreatePanel.add(keyList,this.gridBagConstraints);
		setGrids(2,3,1,1);
		spriteCreatePanel.add(addKeys,this.gridBagConstraints);
		setGrids(3,3,1,1);
		spriteCreatePanel.add(addedKeysList,this.gridBagConstraints);
		
		
	//	velXSlider.addChangeListener(spriteCreatePanelControl);
	//	velYSlider.addChangeListener(spriteCreatePanelControl);
	//	addedKeysList.addListSelectionListener(spriteCreatePanelControl);
	
		//spriteBox.addListener(spriteCreatePanelControl);
		actionBox.addItemListener(spriteCreatePanelControl);
		addKeys.addActionListener(spriteCreatePanelControl);
		spriteCreatePanel.setVisible(false);
	}

	
	
	public void setGrids(int gridX,int gridY,int gridwidth,int gridheight){
		gridBagConstraints.gridx=gridX;
		gridBagConstraints.gridy=gridY;
		gridBagConstraints.gridheight=gridheight;
		gridBagConstraints.gridwidth=gridwidth;
	}
	
	
	public JPanel getSpriteCreatePanel(){
		
		return spriteCreatePanel;
	}
	
	public JSlider getVelXSlider(){
		return velXSlider;
	}
	
	public JSlider getVelYSlider(){
		return velYSlider;
	}
	
	public JComboBox getSpriteBox(){
		return spriteBox;
	}
	
	public JComboBox getActionBox(){
		return actionBox;
	}
	
	public JList getKeyList(){
		return keyList;
	}
	
	public JList getAddedKeysList(){
		return addedKeysList;
	}
	
	public JButton getAddKeysButton(){
		return addKeys;
	}
	
	public JLabel getSpriteLabel(){
		return spriteLabel;
	}
	
	public JLabel getActionLabel(){
		return actionLabel;
	}
	
	public JLabel getVelXLabel(){
		return setVelXLabel;
	}
	
	public JLabel getVelYLabel(){
		return setVelYLabel;
	}
	
	public JScrollPane getKeyListScroll(){
		return keyListScroll;
	}
	
	public DefaultListModel getListModel(){
		return listModel;
	}	
	
}



