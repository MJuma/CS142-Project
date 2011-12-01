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
    
    int position;
    boolean stat = false;

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
//    private void play() 
//    {
//        try 
//        {
//            player = new Player(is);
//            player.play();
//
//            while (!player.isComplete()) 
//            {
//                int position = player.getPosition();
//                System.out.println("Position: " + position);
//                try 
//                {
//                    Thread.sleep(1000);
//                } catch (Exception ee) 
//                {
//                    ee.printStackTrace();
//                }
//            }
//        } catch (JavaLayerException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
    
    public String getPosition()
    {
        String retVal = "" + (position / 1000);
        return retVal;
    }
//    
//    public boolean finished()
//    {
//        //return player.isComplete();
//        return stat;
//    }
    
    public void play() {
        try {
            player = new Player(is);
            PlayerThread pt = new PlayerThread();
            pt.start();

            while (!player.isComplete()) 
            {
                stat = false;
                position = player.getPosition();
                //System.out.println("Position: " + position);
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
            stat = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        player.close();
    }
    
    class PlayerThread extends Thread {

        /* (non-Javadoc)
         * 
         * @see java.lang.Thread#run() */
        @Override
        public void run() {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() 
    {
        play();
    }

}
