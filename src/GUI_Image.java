import javax.swing.*;

public class GUI_Image {
	
	private String fileLocation;
	private String artistName;
	private String albumName;
	
	public GUI_Image(String fileName, String artist, String album){
		fileLocation = fileName;
		artistName = artist;
		albumName = album;
		
	}

	public void displayImage(){
		JFrame frame = new JFrame(artistName + " : " + albumName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(230, 250);
		frame.setResizable(false);
		
		ImageIcon artwork = new ImageIcon(fileLocation);
		JLabel label = new JLabel(null, artwork, JLabel.CENTER);
		frame.getContentPane().add(label);
		frame.validate();
		frame.setVisible(true);
		frame.setLocation(25,50);
	}
}
