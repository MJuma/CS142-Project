
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class ArtistInfo {

	private static int c1 = 0;
	private String searchKeyWord;
	

	public ArtistInfo(String artistName){ //takes the user input artist and album name from the GUI
		ArrayList<String> a = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(artistName);  //the StringTokenizer class splits a string into individual words
		while (token.hasMoreTokens()){  
			c1++;
			a.add(token.nextToken());  //this puts each individual word in the array list
		}
		searchKeyWord = a.get(0)+"+";
		for (int i = 1; i <= c1-1; i++){
			searchKeyWord+= a.get(i) + "+";
		}

		

	}



	public void getArtistInfo() throws FileNotFoundException{  // opens google images with the specified search words
		try {
			URI uri = new URI("http://www.google.com/search?hl=en&safe=off&site=&q="+ searchKeyWord);
			Desktop desktop = null;					//lines 53 - 64 borrowed from http://www.java2s.com/Code/Java/JDK-6/UsingtheDesktopclasstolaunchaURLwithdefaultbrowser.htm
			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
			}

			if (desktop != null)
				desktop.browse(uri);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException use) {
			use.printStackTrace();
		}

		
	}

}
