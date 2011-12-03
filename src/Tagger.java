import java.io.File;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;


public class Tagger 
{
    File testFile;
    
    String artist;
    
    MP3File f      = (MP3File)AudioFileIO.read(testFile);
    MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
    audioHeader.getTrackLength();
    audioHeader.getSampleRateAsNumber();
//    mp3AudioHeader.getChannels();
//    mp3AudioHeader.isVariableBitRate();
//    
//    mp3AudioHeader.getTrackLengthAsString();
//    mp3AudioHeader.getMpegVersion();
//    mp3AudioHeader.getMpegLayer();
//    mp3AudioHeader.isOriginal();
//    mp3AudioHeader.isCopyrighted();
//    mp3AudioHeader.isPrivate();
//    mp3AudioHeader.isProtected();
//    mp3AudioHeader.getBitRate();
//    mp3AudioHeader.getEncodingType();
    
    Tag tag        = f.getTag();
    ID3v1Tag         v1Tag  = (ID3v1Tag)tag;
    
    (tag.getFirstArtist());
    (tag.getFirstAlbum());
    (tag.getFirstTitle());
    (tag.getFirstComment());
    (tag.getFirstYear());
    (tag.getFirstTrack());  


}
