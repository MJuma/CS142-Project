import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Mp3Player implements Runnable 
{
    private static Player player;
    private InputStream stream;
    
    /** Constructor used to call this object.
     *  Takes in a file and sends it to the inputstream for the player to read.
     *  
     * @param filename
     */
    public Mp3Player(File filename) 
    {
        try 
        {
            // Create an InputStream to the file
            stream = new FileInputStream(filename);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /** Method used to play the song.
     * 
     */
    private void play() 
    {
        try 
        {
            player = new Player(stream);
            player.play();
            
            Controls a = new Controls();
            System.out.println('a');

            while (!player.isComplete()) 
            {
                a.time(player.getPosition());
                int position = player.getPosition();
                System.out.println("Position: " + position);
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (Exception ee) 
                {
                    ee.printStackTrace();
                }
            }
        }
        catch (JavaLayerException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int getPosition()
    {
        return player.getPosition();
    }
    
    public static boolean isComplete()
    {
        return player.isComplete();
    }
    
    /* Method used to implement Runnable and run this object in its own thread.
     * 
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        play();
    }
}
