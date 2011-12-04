import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

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

/* HOW TO USE TAGGER.java
 * 
 *  First you need to use JFileChooser to get the select file from the user like this:
 *      File filepath;
 *      JFileChooser chooser = new JFileChooser();
 *      int returnVal = chooser.showOpenDialog(null);
 *      filepath = chooser.getSelectedFile();
 *  Then you need to instantiate tagger.java like this:
 *      Tagger tags = new Tagger(filepath);
 *  Finally you set the string you want filled to the method in tagger you need.
 *  For example if you wanted the artists name you would do this:
 *      String artist;
 *      artist = tags.Artist();
 */

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
    
    /** Returns the song title
     * @return
     */
    public String title()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_TITLE));
    }
    
    /** Returns the song artist
     * @return
     */
    public String artist()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_ARTIST));
    }
    
    /** Returns the song album
     * @return
     */
    public String album()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_ALBUM));
    }


    /** Returns the song length as an int
     * @return
     */
    public int length()
    {
        return audioHeader.getTrackLength();
    }
    
    /** Returns the songs length as a string
     * @return
     */
    public String lengthString()
    {
        return audioHeader.getTrackLengthAsString();
    }
    
    /** Returns the songs year
     * @return
     */
    public String year()
    {
        return (v2tag.getFirst(ID3v24Frames.FRAME_ID_YEAR));
    }
    
    /** Returns the songs genre
     * @return
     */
    public String genre()
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