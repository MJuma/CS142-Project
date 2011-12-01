import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class ArtworkFinder {

	private static int c1 = 0;
	private static int c2 = 0;
	private String searchKeyWord;
	private String searchKeyWord2;

	public ArtworkFinder(String artistName, String albumName){ //takes the user input artist and album name from the GUI
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


		ArrayList<String> b = new ArrayList<String>();
		StringTokenizer bToken = new StringTokenizer(albumName);
		while (bToken.hasMoreTokens()){
			c2++;
			b.add(bToken.nextToken());
		}
		searchKeyWord2 = b.get(0)+"+";
		for (int i = 1; i<=c2-2; i++){
			searchKeyWord2+= b.get(i) + "+";
		}

		searchKeyWord2+= b.get(c2-1);


		//System.out.println(searchKeyWord + "\n" + searchKeyWord2);
		//System.out.println("a: " + a + " " + c1+ "\n b: " + b + " " + c2);
		//System.out.println(a.get(0) + a.get(1)+b.get(0)+b.get(1));
	}



	public void getArtwork(){  // opens google images with the specified search words
		try {
			URI uri = new URI("http://images.google.com/search?tbm=isch&hl=en&source=hp&biw=1366&bih=705&q="+searchKeyWord + "+" + searchKeyWord2 + "&gbv=");
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



		JOptionPane.showMessageDialog(null, "Right click on your image choice and save it to a known location");
		
		

	}

}
