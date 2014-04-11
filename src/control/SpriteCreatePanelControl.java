package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.DesignPanel;
import view.SpriteCreatePanel;


public class SpriteCreatePanelControl implements ActionListener,ChangeListener,ItemListener,ListSelectionListener{

	private SpriteCreatePanel spriteCreatePanel;
	
	
	private DesignPanel designPanel;
	public SpriteCreatePanelControl(DesignPanel designPanel){
		this.designPanel=designPanel;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Add Keys"){	
			
			designPanel.getSpriteCreatePanelClass().getListModel().addElement(designPanel.getSpriteCreatePanelClass().getKeyList().getSelectedValue());   
			if(designPanel.getSpriteCreatePanelClass().getAddedKeysList().getModel().getSize()==0)
			JOptionPane.showMessageDialog(null, "Please Choose an event from the list");	
		}
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		JComboBox cb=(JComboBox)e.getSource();
		String text=(String)cb.getSelectedItem();	
		
		if(text.equalsIgnoreCase("Move")){	
			designPanel.getSpriteCreatePanelClass().getVelXSlider().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getVelYSlider().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getVelXLabel().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getVelYLabel().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getKeyList().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getAddKeysButton().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getAddedKeysList().setVisible(false);
		}
		
		if(text.equalsIgnoreCase("Keyboard Events")){
			designPanel.getSpriteCreatePanelClass().getKeyList().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getAddKeysButton().setVisible(true);
			designPanel.getSpriteCreatePanelClass().getVelXLabel().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelYLabel().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelXSlider().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelYSlider().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getAddedKeysList().setVisible(true);
		}
		
		if(text.equalsIgnoreCase("No Action")){
			designPanel.getSpriteCreatePanelClass().getKeyList().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getAddKeysButton().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelXLabel().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelYLabel().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelXSlider().setVisible(false);
			designPanel.getSpriteCreatePanelClass().getVelYSlider().setVisible(false);			
			designPanel.getSpriteCreatePanelClass().getAddedKeysList().setVisible(false);
		}
		
	}

}
