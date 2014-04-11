package view;

import action.Action;
import event.Event;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import model.SpriteModel;
import model.SpriteModelObject;
import observer.Observer;

import event.Event;
import gui.GamePlayPanel;

public class SpriteViewObject implements SpriteView, Observer {
	// same as in the model object
	private String name;
	private Image image;
	private File file;
	private ImageIcon icon;
   
	private Map<Event, List<Action>> eventActionMap;
	private SpriteModelObject modelObj;
	private Logger log = Logger.getLogger(SpriteViewObject.class);
	public SpriteViewObject(SpriteModelObject modelObj, ImageIcon icon) {
		name = modelObj.getName();
		eventActionMap = new HashMap<Event, List<Action>>();
		this.modelObj = modelObj;
		
		this.icon = icon;
		//this.icon.
		this.image = icon.getImage().getScaledInstance(this.modelObj.getWidth(), this.modelObj.getHeight(),  java.awt.Image.SCALE_SMOOTH);
		
		  
		
		//this.image= this.icon.getImage();
		/*if (file != null) {
			try {
				BufferedImage img = ImageIO.read(file);
				modelObj.setWidth(img.getWidth());
				modelObj.setHeight(img.getHeight());
				this.image = img;
			} catch (IOException e) {

			}*/
		//}
	}

	@Override
	public void draw(Graphics g) {
		log.info("sprite view object draw");
		 
		g.drawOval( modelObj.getxCoordinate(),  modelObj.getyCoordinate(), 10, 30);	
		 g.drawImage(this.image, modelObj.getxCoordinate(), modelObj.getyCoordinate(), modelObj.getHeight(), modelObj.getWidth(), null);
         // g.drawImage(this.icon.getImage(), modelObj.getxCoordinate(), modelObj.getyCoordinate(), this.icon.getIconHeight(), this.icon.getIconWidth(), null);
	}

	@Override
	public String getName() {
		return name;

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update() {

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void add(Event gameEvent, Action action) {

//		logger.debug("Game Event Name inside SpriteObject: ");

		if (eventActionMap.get(gameEvent) == null)
			eventActionMap.put(gameEvent, new ArrayList<Action>());
		eventActionMap.get(gameEvent).add(action);
	}
	
	public void removeActionEvent(Event event, Action action)
	{
		//TO DO
	}
	
	public Map<Event, List<Action>> getActionEventMap()
	{
		return eventActionMap;
	}
}
