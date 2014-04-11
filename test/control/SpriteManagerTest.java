package control;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import model.SpriteModelObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpriteManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreation() {
		
		SpriteManager spritemgr = SpriteManager.getInstance();
		int xCoordinate = 10;
		int yCoordinate = 20;
		int  width = 300;
		int height = 200;
		ImageIcon icon = new ImageIcon("images/frog2.jpg");
		spritemgr.Create("Space aliens", "Rect", xCoordinate, yCoordinate, width, height, icon);
		SpriteModelObject modelobj = spritemgr.getSpriteModel("Space aliens");
		assertEquals(modelobj.getxCoordinate(),xCoordinate); 
		assertEquals(modelobj.getyCoordinate(),yCoordinate);
		//assertEquals(modelobj.getWidth(),width);
		//assertEquals(modelobj.getHeight(),height);
   }

}
