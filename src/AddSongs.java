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
    
    public AddSongs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);    // Allows file chooser to select multiple files
        int returnVal = chooser.showOpenDialog(null);
        
        File[] selectedFile = chooser.getSelectedFiles();
        
        for(int i = 0; i<=selectedFile.length - 1; i++)
        {
            file.add(i, selectedFile[i]);
            filepath = selectedFile[i];
            Tagger tags = new Tagger(filepath);
            
            title.add(i, tags.title());
            artist.add(i, tags.artist());
            album.add(i, tags.album());
            length.add(i, tags.length());
            //track.add(i, tags.Track());
            year.add(i, tags.year());
            genre.add(i, tags.genre());
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
     
    
//    public static void main(String[] args)
//    {
//        new AddSongs();
//    }



}
