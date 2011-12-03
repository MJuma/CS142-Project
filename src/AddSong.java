import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;


public class AddSong 
{
    File filepath;
    
    public AddSong()
    {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        filepath = chooser.getSelectedFile();
        
        String title,
               artist,
               album,
               track,
               year,
               genre,
               path = null;
        int length;
        
        Tagger tags = new Tagger(filepath);
        
        title = tags.Title();
        
        artist = tags.Artist();
        
        album = tags.Album();
        
        length = tags.Length();
        
        //track = tags.Track();
        
        year = tags.Year();
        
        genre = tags.Genre();
        
        try {
            path = filepath.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(title + "  " + artist + "  " + album + "  " + length + "  " + year + "  " + genre + "  " + path);
    }
     
    
    public static void main(String[] args)
    {
        new AddSong();
    }



}
