package gui;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {
           
    BufferedImage img;
    String imageString;
	private Image scaledImage;
    
     public void paint(Graphics g) {
        g.drawImage(scaledImage, 0, 0, null);
    }
 
    public LoadImageApp(String imageString) 
    {
    	this.imageString = imageString;
       try 
       {
    	   img = ImageIO.read(new File(imageString));
    	   scaledImage = img.getScaledInstance(50,50, Image.SCALE_DEFAULT);
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(50,50);
       }
    }
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("Load Image Sample");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.getContentPane().setLayout(new FlowLayout());
        
        File folder = new File("images");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) 
		    {
		      if (listOfFiles[i].isFile()) 
		      {
		        System.out.println("File " + listOfFiles[i].getName()+" "+ listOfFiles[i].getPath());
		        f.add(new LoadImageApp(listOfFiles[i].getPath()));
		      } 
		    }
    
        f.pack();
        f.setVisible(true );
    }
}