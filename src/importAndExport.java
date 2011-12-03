
 
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame; 

public class importAndExport extends JFrame {  
    //private File file; 
	//private File file;
	static String filename;
		static int n = 0;     // Declare a global integer variable. 
		public static void main(String[] args) throws IOException  {
        JFileChooser fileChooser = new JFileChooser();  
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
        
        	File file = fileChooser.getSelectedFile();
         String filename = file.getPath();
        	
        }
     // System.out.println (filename);
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
