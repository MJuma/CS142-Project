import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class AddPlaylist 
{
    File filepath;

    public AddPlaylist()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);    //allows file chooser to select multiple files
        int returnVal = chooser.showOpenDialog(null);

        ArrayList<File> list = new ArrayList<File>();


        File[] selectedFile = chooser.getSelectedFiles();



        for(int i = 0; i<=selectedFile.length - 1; i++){

            filepath = selectedFile[i];
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
    }

    public static void main(String[] args)
    {
        new AddPlaylist();
    }



}
