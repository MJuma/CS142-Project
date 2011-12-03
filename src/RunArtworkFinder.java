import java.io.FileNotFoundException;


public class RunArtworkFinder {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String artist = "The Beatles";
		String album = "The White Album";

		ArtworkFinder a = new ArtworkFinder(artist, album);
		String fileName = a.getArtwork();
		
		GUI_Image b = new GUI_Image(fileName, artist, album);
		b.displayImage();
	}

}
