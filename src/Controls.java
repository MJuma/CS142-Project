import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Controls extends JPanel implements ActionListener
{
    private JButton playButton, stopButton, pause, resume;
    private JLabel position;
    private Thread myThread;
    private Mp3Player player;
    private ArrayList<File> filePath;
    private JLabel timeLabel;
    private Thread timeUpdater;
    int selected = 0;
    int state = 0;
    private JButton backButton;
    private JButton nextButton;

    public Controls() 
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{53, 55, 61, 71, 29, 0};
        gridBagLayout.rowHeights = new int[]{23, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        pause = new JButton("Pause");
        pause.addActionListener(this);

        stopButton = new JButton("End Song");
        stopButton.addActionListener(this);
        playButton = new JButton("Play");
        playButton.addActionListener(this);
        GridBagConstraints gbc_playButton = new GridBagConstraints();
        gbc_playButton.anchor = GridBagConstraints.WEST;
        gbc_playButton.insets = new Insets(0, 0, 5, 5);
        gbc_playButton.gridx = 0;
        gbc_playButton.gridy = 0;
        add(playButton, gbc_playButton);
        GridBagConstraints gbc_stopButton = new GridBagConstraints();
        gbc_stopButton.anchor = GridBagConstraints.WEST;
        gbc_stopButton.insets = new Insets(0, 0, 5, 5);
        gbc_stopButton.gridx = 1;
        gbc_stopButton.gridy = 0;
        add(stopButton, gbc_stopButton);
        GridBagConstraints gbc_pause = new GridBagConstraints();
        gbc_pause.anchor = GridBagConstraints.WEST;
        gbc_pause.insets = new Insets(0, 0, 5, 5);
        gbc_pause.gridx = 2;
        gbc_pause.gridy = 0;
        add(pause, gbc_pause);

        resume = new JButton("Resume");
        resume.addActionListener(this);
        GridBagConstraints gbc_resume = new GridBagConstraints();
        gbc_resume.anchor = GridBagConstraints.WEST;
        gbc_resume.insets = new Insets(0, 0, 5, 5);
        gbc_resume.gridx = 3;
        gbc_resume.gridy = 0;
        add(resume, gbc_resume);

        position = new JLabel("");
        GridBagConstraints gbc_position = new GridBagConstraints();
        gbc_position.insets = new Insets(0, 0, 5, 0);
        gbc_position.anchor = GridBagConstraints.WEST;
        gbc_position.gridx = 4;
        gbc_position.gridy = 0;
        add(position, gbc_position);

        timeLabel = new JLabel("Time: ");
        GridBagConstraints gbc_timeLabel = new GridBagConstraints();
        gbc_timeLabel.insets = new Insets(0, 0, 5, 0);
        gbc_timeLabel.anchor = GridBagConstraints.WEST;
        gbc_timeLabel.gridx = 4;
        gbc_timeLabel.gridy = 0;
        add(timeLabel, gbc_timeLabel);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.insets = new Insets(0, 0, 0, 5);
        gbc_backButton.gridx = 1;
        gbc_backButton.gridy = 1;
        add(backButton, gbc_backButton);

        nextButton = new JButton("Forward");
        nextButton.addActionListener(this);
        GridBagConstraints gbc_nextButton = new GridBagConstraints();
        gbc_nextButton.insets = new Insets(0, 0, 0, 5);
        gbc_nextButton.gridx = 2;
        gbc_nextButton.gridy = 1;
        add(nextButton, gbc_nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == playButton) 
        {
            player = new Mp3Player(filePath.get(selected));
            myThread = new Thread(player);
            myThread.start();
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
        if (e.getSource() == backButton) 
        {
            if (myThread.isAlive()) 
            {
                myThread.stop();
            }
            player = new Mp3Player(filePath.get(--selected));

            myThread = new Thread(player);
            myThread.start();
            timeUpdater = new TimeUpdater();
            timeUpdater.start();
        }
        if (e.getSource() == nextButton) 
        {
            if (myThread.isAlive()) 
            {
                myThread.stop();
            }
            player = new Mp3Player(filePath.get(++selected));

            myThread = new Thread(player);
            myThread.start();
            timeUpdater = new TimeUpdater();
            timeUpdater.start();
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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (player.isPlaying())
            {
                if (toSeconds(player.getPosition()) < 60)
                {
                    timeLabel.setText("Time: " + 0 + ":" + (int)toSeconds(player.getPosition())%60);
                }
                else if (toSeconds(player.getPosition()) > 60 && toSeconds(player.getPosition()) < 120)
                {
                    timeLabel.setText("Time: " + 1 + ":" + (int)toSeconds(player.getPosition())%60);
                }
                else if (toSeconds(player.getPosition()) > 120 && toSeconds(player.getPosition()) < 180)
                {
                    timeLabel.setText("Time: " + 2 + ":" + (int)toSeconds(player.getPosition())%60);
                }
                else if (toSeconds(player.getPosition()) > 180 && toSeconds(player.getPosition()) < 240)
                {
                    timeLabel.setText("Time: " + 3 + ":" + (int)toSeconds(player.getPosition())%60);
                }
                else if (toSeconds(player.getPosition()) > 300 && toSeconds(player.getPosition()) < 360)
                {
                    timeLabel.setText("Time: " + 4 + ":" + (int)toSeconds(player.getPosition())%60);
                }
                else
                {
                    timeLabel.setText("Time: " + toSeconds(player.getPosition())%60 + ":" + (int)toSeconds(player.getPosition())%60);
                }
            }
        }

        private double toSeconds(int time)
        {
            Double d = (double) (time / 1000);
            return d;
        }
    }

    public void setPlayPath(ArrayList<File> playPath)
    {
        filePath = playPath;
    }



    //    public static void main(String[] args)
    //    {
    //        new Controls();
    //    }

}