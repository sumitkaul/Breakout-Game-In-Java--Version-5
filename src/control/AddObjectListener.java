package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JFileChooser;

import org.apache.log4j.Logger;

public class AddObjectListener implements ActionListener {
	private JFileChooser fileChooser;
	private Logger log = Logger.getLogger(AddObjectListener.class);
	public void actionPerformed(ActionEvent e) {
		//listPanel.getClass();
		fileChooser= new JFileChooser();
		log.info("inside button listner");
		File currentDirectory = null;
		currentDirectory = new File("images");
		File file;
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(currentDirectory);
		fileChooser.showOpenDialog(null);
		File[] files = fileChooser.getSelectedFiles();
		for(File selectedFile : files) {
			file= selectedFile;
			String filename = selectedFile.getName().substring(0, selectedFile.getName().indexOf("."));
			String name = "";
			for (int i = 0; i < filename.length(); i++){
	            String next = filename.substring(i, i + 1);
	            if (i == 0){
	            	name += next.toUpperCase();
	            } else {
	            	name += next.toLowerCase();
	            }
	        }
			log.info("Its a "+name);
			
			//SpriteManager.getInstance().Create(name, "rectangle", 2, 5, 5, 5, file);
			
		
		}
		
	}
}
