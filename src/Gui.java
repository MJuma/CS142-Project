import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener
{
    JLabel answer = new JLabel("");

    JPanel pane = new JPanel();
    JButton pressme = new JButton("Press Me");


    public Gui()
    {
        //JPanel panel = buildPanel();

        super("Media Library");

        setBounds(400,200,400,400);
        //setSize(400, 400);
        //setLocation(400,200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container con = this.getContentPane();
        con.add(pane); 
        
        pressme.setMnemonic('P'); // associate hotkey to button
        
        pressme.addActionListener(this);   // register button listener

        pane.add(pressme); pressme.requestFocus();
        
        pane.add(answer); pane.add(pressme); pressme.requestFocus();

        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      if (source == pressme)
      {
        answer.setText("Button pressed!");

      }
    }   

}
