package model;



import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpriteModelObjectTest {
    SpriteModelObject modelObj;
	@Before
	public void setUp() throws Exception {
		
		modelObj = new SpriteModelObject("Object1", "Rectangle",20, 30, 80, 90);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testName() {
        String name = "SpaceInvader";
        modelObj.setName(name);
        assertEquals( modelObj.getName(),name);        
	}
	
	@Test
	public void testCoordinates() {
		
		int x = 10;
		int y = 20;
		modelObj.setxCoordinate(x);
		modelObj.setyCoordinate(y);		
		assertEquals(modelObj.getxCoordinate() ,x);
		assertEquals(modelObj.getyCoordinate() ,y);
	}
	
	@Test
    public void testSize() {
    	
		int height = 50;
		int width = 60;
		modelObj.setWidth(width);
		modelObj.setHeight(height);		
	 	assertEquals(modelObj.getWidth() ,width);
		assertEquals(modelObj.getHeight() ,height);
	}
}
