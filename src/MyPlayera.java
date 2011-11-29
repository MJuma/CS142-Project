import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

/**
 * The Class MP3Player.
 * 
 * //TODO description
 * 
 */
public class MyPlayera {

    private Player player;
    private InputStream is;

    /**
     * Instantiates a new my player.
     * 
     * @param file
     *            the file
     */
    public MyPlayera(File file) {
        try {
            // Create an InputStream to the file
            is = new FileInputStream(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new my player.
     * 
     * @param filename
     *            the filename
     */
    public MyPlayera(String filename) {
        try {
            // Create an InputStream to the file
            is = new FileInputStream(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Play the file.
     */
    public void play() {
        try {
            player = new Player(is);
            PlayerThread pt = new PlayerThread();
            pt.start();

            while (!player.isComplete()) {
                int position = player.getPosition();
                System.out.println("Position: " + position);
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop the player
     */
    public void stop() {
        player.close();
    }

    /**
     * The Class PlayerThread.
     * 
     * A thread that plays the file
     * 
     */
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
}
