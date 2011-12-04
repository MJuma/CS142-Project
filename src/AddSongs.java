import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class AddSongs 
{
    File filepath;
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> artist = new ArrayList<String>();
    ArrayList<String> album = new ArrayList<String>();
    //ArrayList<String> track = new ArrayList<String>();
    ArrayList<String> year = new ArrayList<String>();
    ArrayList<String> genre = new ArrayList<String>();
    ArrayList<String> path = new ArrayList<String>();
    ArrayList<Integer> length = new ArrayList<Integer>();
    
    public AddSongs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);    // Allows file chooser to select multiple files
        int returnVal = chooser.showOpenDialog(null);
        
        ArrayList<File> list = new ArrayList<File>();
        File[] selectedFile = chooser.getSelectedFiles();
        
        for(int i = 0; i<=selectedFile.length - 1; i++)
        {
            filepath = selectedFile[i];
            Tagger tags = new Tagger(filepath);
            
            title.add(i, tags.Title());
            artist.add(i, tags.Artist());
            album.add(i, tags.Album());
            length.add(i, tags.Length());
            //track.add(i, tags.Track());
            year.add(i, tags.Year());
            genre.add(i, tags.Genre());
            try {
                path.add(i, filepath.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        for(int i = 0; i<=selectedFile.length - 1; i++)
        {
            System.out.println(title.get(i) + "  " + artist.get(i) + "  " + album.get(i) + "  " + length.get(i) + "  " + year.get(i) + "  " + genre.get(i) + "  " + path.get(i));
        }
 
    }
     
    
//    public static void main(String[] args)
//    {
//        new AddSongs();
//    }



}
