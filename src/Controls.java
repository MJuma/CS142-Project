import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controls extends JPanel implements ActionListener
{
    private JFrame frame;
    private JButton selectFile, playButton, stopButton, pause, resume;
    private JLabel position;
    private Thread myThread;
    private Mp3Player player;
    private File filepath;
    private JLabel timeLabel;
    private Thread timeUpdater;

    public Controls() 
    {
//        frame = new JFrame();
//        frame.setTitle("Controls");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(this);
//        frame.setBounds(400, 200, 400, 400);
//        // frame.setSize(300, 400);
//        frame.setVisible(true);

        populateGUI();
    }

    private void populateGUI()
    {
        this.setLayout(new FlowLayout());

        selectFile = new JButton("Select Song");
        selectFile.addActionListener(this);
        add(selectFile);

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        add(stopButton);

        pause = new JButton("Pause");
        pause.addActionListener(this);
        add(pause);

        resume = new JButton("Resume");
        resume.addActionListener(this);
        add(resume);

        position = new JLabel("");
        add(position);

        timeLabel = new JLabel("Time: ");
        add(timeLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == selectFile) 
        {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);
            filepath = chooser.getSelectedFile();
            System.out.println(filepath.getAbsolutePath());
        }
        if (e.getSource() == playButton) 
        {
            // instantiate the mp3player
            player = new Mp3Player(filepath);
            // now start the mp3player thread to play music
            myThread = new Thread(player);
            myThread.start();
            // start the thread that updates the gui based on time
            timeUpdater = new TimeUpdater();
            timeUpdater.start();

        }
        if (e.getSource() == stopButton)
        {
            if (myThread.isAlive()) 
            {
                myThread.stop();
            }
        }
        if (e.getSource() == pause) 
        {
            if (myThread.isAlive()) 
            {
                myThread.suspend();
            }
        }
        if (e.getSource() == resume) 
        {
            if (myThread.isAlive()) 
            {
                myThread.resume();
            }
        }
    }

    // a thread which reads the position from Mp3Player and updates the gui
    class TimeUpdater extends Thread
    {
        // This method is called when the thread runs
        @Override
        public void run() 
        {
            // wait for 2 seconds to allow the song to load before starting to change the gui
            // this is dirty and should be fixed using wait and notify or something of the sort
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (player.isPlaying())
            {
                timeLabel.setText("Current Time: " + toSeconds(player.getPosition()));
            }
        }

        private double toSeconds(int time)
        {
            Double d = (double) (time / 1000);
            return d;
        }
    }



    public static void main(String[] args)
    {
        new Controls();
    }

}