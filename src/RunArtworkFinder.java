
public class RunArtworkFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String artist = "Wayne";
		String album = "random";

		ArtworkFinder a = new ArtworkFinder(artist, album);
		a.getArtwork();
		
	}

}
