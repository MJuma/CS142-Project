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
    ArrayList<File> file = new ArrayList<File>();
    File[] selectedFile;
    
    public AddSongs()
    {
        // Use chooser to get the selected files by the user.
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);    // Allows file chooser to select multiple files
        int returnVal = chooser.showOpenDialog(null);
        
        // Send the selected files to the selectedFile File array
        selectedFile = chooser.getSelectedFiles();
        
        // Using a for loop send each selectFile to tagger and then put it in its appropriate array.
        for(int i = 0; i<=selectedFile.length - 1; i++)
        {
            file.add(i, selectedFile[i]); // Used to give the Controls class the current song.
            filepath = selectedFile[i]; // Puts the current song in a filepath variable of type File
            Tagger tags = new Tagger(filepath); // Passes the filepath variable to tagger and instantiates tagger
            
            title.add(i, tags.title()); // Uses tagger to find the title of the song and puts it in its array.
            artist.add(i, tags.artist());
            album.add(i, tags.album());
            length.add(i, tags.length());
            //track.add(i, tags.Track());
            year.add(i, tags.year());
            genre.add(i, tags.genre());
            // Puts the selectedSongs path in a string.
            try {
                path.add(i, filepath.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        
//        for(int i = 0; i<=selectedFile.length - 1; i++)
//        {
//            System.out.println(title.get(i) + "  " + artist.get(i) + "  " + album.get(i) + "  " + length.get(i) + "  " + year.get(i) + "  " + genre.get(i) + "  " + path.get(i));
//        }
 
    }
    
    public ArrayList<String> getTitle()
    {
        return title;
    }
    public ArrayList<String> getArtist()
    {
        return artist;
    }
    public ArrayList<String> getAlbum()
    {
        return album;
    }
    public ArrayList<Integer> getLength()
    {
        return length;
    }
//    public ArrayList<String> getTrack()
//    {
//        return track;
//    }
    public ArrayList<String> getYear()
    {
        return year;
    }
    public ArrayList<String> getGenre()
    {
        return genre;
    }
    public ArrayList<String> getPath()
    {
        return path;
    }
    public ArrayList<File> getFile()
    {
        return file;
    }
    public int songsSelected()
    {
        return selectedFile.length;
    }
     
    
//    public static void main(String[] args)
//    {
//        new AddSongs();
//    }



}
