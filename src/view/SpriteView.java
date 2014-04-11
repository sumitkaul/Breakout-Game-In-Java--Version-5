package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface SpriteView {
	
	public String getName();
	public void setName(String str);	
	public void draw(Graphics g);

}
