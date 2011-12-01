import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
 
public class JLayerPlayer {
    
    public JLayerPlayer(String args) {
        AudioInputStream din = null;
        try {
            File file = new File(args);
            //File file = new File("C:\\a.mp3");
            
            // Get the audio input stream for the MP3 to be played.
            AudioInputStream in = AudioSystem.getAudioInputStream(file);
            
            /* Create a javax.sound.sampled.AudioFormat object that will decode the audio
             * This is done by getting the base audio input's format, and using it to produce a decode format compatible 
             * with the base format.
            */
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
                    baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
                    false);
            
            // Get a new input stream that will decode the current inputstream for the new decoded format.
            din = AudioSystem.getAudioInputStream(decodedFormat, in);
            
            // Get a connection to the users audio out. this is done with the DataLine classes.
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            
            /* Once the line is open, a buffering stratagy for tunneling data from the inputstream to the line-out must be implemented.
             * Note this is much like writing a buffering strategy to copy between two files - 
             * the technique is certainly not unique to audio transfer.
             */
            if(line != null) {
                line.open(decodedFormat);
                byte[] data = new byte[4096];
                // Start
                line.start();
                
                int nBytesRead;
                while ((nBytesRead = din.read(data, 0, data.length)) != -1) {   
                    line.write(data, 0, nBytesRead);
                }
                // Stop
                line.drain();
                line.stop();
                line.close();
                din.close();
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(din != null) {
                try { din.close(); } catch(IOException e) { }
            }
        }
    }
 
}