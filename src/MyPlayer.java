import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * The Class MyPlayer.
 * 
 * //TODO description
 * 
 */
public class MyPlayer implements Runnable 
{

    private Player player;
    private InputStream is;

    /**
     * Instantiates a new my player.
     * 
     * @param file
     *            the file
     */
    public MyPlayer(File file) 
    {
        try 
        {
            // Create an InputStream to the file
            is = new FileInputStream(file.getAbsolutePath());
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new my player.
     * 
     * @param filename
     *            the filename
     */
    public MyPlayer(String filename) 
    {
        try {
            // Create an InputStream to the file
            is = new FileInputStream(filename);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Play the file.
     */
    private void play() 
    {
        try 
        {
            player = new Player(is);
            player.play();

            while (!player.isComplete()) 
            {
                int position = player.getPosition();
                System.out.println("Position: " + position);
                try 
                {
                    Thread.sleep(1000);
                } catch (Exception ee) 
                {
                    ee.printStackTrace();
                }
            }
        } catch (JavaLayerException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() 
    {
        play();
    }

}
