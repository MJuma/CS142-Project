import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v24Frames;

public class Tagger 
{
    MP3AudioHeader audioHeader;
    Tag tag;
    AbstractID3v2Tag v2tag;

    public Tagger(File filepath)
    {
        
        MP3File f = null;
        try
        {
            f =  (MP3File) AudioFileIO.read(filepath);
        }
        catch (InvalidAudioFrameException e)
        {
            e.printStackTrace();
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        }

        audioHeader = (MP3AudioHeader) f.getAudioHeader();
        tag = f.getID3v2Tag();
        v2tag  = f.getID3v2Tag();
    }
    
    public String Title()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_TITLE));
    }
    
    public String Artist()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_ARTIST));
    }
    
    public String Album()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_ALBUM));
    }


    public int Length()
    {
        return audioHeader.getTrackLength();
    }
    
    public String LengthString()
    {
        return audioHeader.getTrackLengthAsString();
    }
    
    public String Year()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_YEAR));
    }
    
    public String Genre()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_GENRE));
    }

//    public static void main(String[] args)
//    {
//        File filepath;
//
//        JFileChooser chooser = new JFileChooser();
//        int returnVal = chooser.showOpenDialog(null);
//        filepath = chooser.getSelectedFile();
//
//        new Tagger(filepath);
//    }

}