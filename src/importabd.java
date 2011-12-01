import java.awt.BorderLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;  
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
import javax.swing.JButton; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane;



public class importabd extends JFrame {  
    private File file; 

    public importabd() { 
        super("Demonstrating the Java Media Player"); 

        JButton openFile = new JButton("Open file to play"); 
        openFile.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                openFile(); 
            } 
        }); 
        getContentPane().add(openFile, BorderLayout.NORTH); 

        setSize(300, 300); 
    } 

    private void openFile() { 
        JFileChooser fileChooser = new JFileChooser(); 
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        int result = fileChooser.showOpenDialog(this); 

        // user clicked Cancel button on dialog 
        if (result == JFileChooser.CANCEL_OPTION) 
            file = null; 
        else
        {
        	file = fileChooser.getSelectedFile(); 
        	
        }
//            file = fileChooser.getSelectedFile(); 
    }
    
    private List<String> getFilesFromFileList(File file)
    {
    	File check;
    	List<String> files = new ArrayList<String>();
    	
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// 1 line for 1 path
			String buffer = new String();
			while ((buffer = reader.readLine()) != null)
			{
				check = new File(buffer);
				if (check.exists()) // check file existed before adding into list
					files.add(buffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return files;
    }
}
