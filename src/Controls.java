import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controls extends JPanel implements ActionListener 
{
    private JFrame frame;
    private JButton selectFile, playButton, stopButton, time;
    private JLabel position;
    private MyPlayer myPlayer;
    private Thread myThread;
    
    File filepath;
    String fileString;

    public Controls() 
    {
        frame = new JFrame();
        frame.setTitle("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);        
        frame.setBounds(400,200,400,400);
        //frame.setSize(300, 400);
        frame.setVisible(true);

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
        
        time = new JButton("Time");
        time.addActionListener(this);
        add(time);
        
        position = new JLabel("");
        add(position);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == selectFile) 
        {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);
            filepath = chooser.getSelectedFile();   
            try {
                fileString = filepath.getCanonicalPath();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == playButton) 
        {
            Mp3Player a = new Mp3Player(filepath);
            myThread = new Thread(a);
            myThread.start();
//            while (Mp3Player.getPosition() < 122000)
//            {
//                String elapsed;
//                elapsed = "" + Mp3Player.getPosition();
//                position.setText(elapsed);
//            }
        }
        if (e.getSource() == stopButton) 
        {
            if (myThread.isAlive())
            {
                myThread.stop();
            }
        }
        if (e.getSource() == time) 
        {
            //if (myThread.isAlive())
            while (Mp3Player.getPosition() < 122000)
            {
                String elapsed;
                elapsed = "" + Mp3Player.getPosition();
                
                position.setText(elapsed);
            }
        }
    }
    
    public void time(int are)
    {
        String elapsed;
        elapsed = "" + are;
        
        position.setText(elapsed);
    }

    public static void main(String[] args) 
    {
        new Controls();
    }

}