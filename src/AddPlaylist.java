import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class AddPlaylist 
{
    File filepath;
    //File[] listOfFiles;
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> artist = new ArrayList<String>();
    ArrayList<String> album = new ArrayList<String>();
    //ArrayList<String> track = new ArrayList<String>();
    ArrayList<String> year = new ArrayList<String>();
    ArrayList<String> genre = new ArrayList<String>();
    ArrayList<String> path = new ArrayList<String>();
    ArrayList<Integer> length = new ArrayList<Integer>();
    ArrayList<File> file = new ArrayList<File>();

    public AddPlaylist() throws IOException
    {
        JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showSaveDialog(null);

        FileReader reader = new FileReader(chooser.getSelectedFile());
        BufferedReader buffer = new BufferedReader(reader);
        FileReader reader2 = new FileReader(chooser.getSelectedFile());
        BufferedReader buffer2 = new BufferedReader(reader2);
        int lines = 0;

        // Text file is read and the number of lines in it are passed to the int variable lines.
        while (true) 
        {
            String aLine = buffer.readLine();
            if (aLine == null) break;
            lines++;
        }
        lines--;

        // Text file is read and the lines are read into the ArrayList path of type String
        for (int i = 0; i<=lines; i++)
        {
            String bLine = buffer2.readLine();
            path.add(i, bLine);                     
        }
        
        // Prints the contents of path
        for (int i = 0; i<=lines; i++)
        {
            System.out.println(path.get(i));
        }
        
        File[] listOfFiles = new File[lines];

        for (int i = 0; i<=lines -1; i++)
        {
            listOfFiles[i] = new File(path.get(i));
        }


        for(int i = 0; i<=lines; i++)
        {
            file.add(i, listOfFiles[i]);
            filepath = listOfFiles[i];
            Tagger tags = new Tagger(filepath);

            title.add(i, tags.title());
            artist.add(i, tags.artist());
            album.add(i, tags.album());
            length.add(i, tags.length());
            //track.add(i, tags.Track());
            year.add(i, tags.year());
            genre.add(i, tags.genre());
        }

        for(int i = 0; i<=lines; i++)
        {
            System.out.println(title.get(i) + "  " + artist.get(i) + "  " + album.get(i) + "  " + length.get(i) + "  " + year.get(i) + "  " + genre.get(i));
        }
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


    public static void main(String[] args) throws IOException
    {
        new AddPlaylist();
    }



}
