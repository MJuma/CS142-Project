import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;


public class Temp  
{

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException
    {
        JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showSaveDialog(null);
        
      //Create reading and writing objects
        FileReader reader = new FileReader(chooser.getSelectedFile());
        BufferedReader buffer = new BufferedReader(reader);
        int charsInFile = 0;
        String outputText = "";
        
        while (true) 
        {
            String aLine = buffer.readLine();
            if (aLine == null) break;
            //System.out.println(aLine); //Depreciated
            outputText = outputText + "\n" + aLine;
            charsInFile = charsInFile + aLine.length();
        }
        System.out.println(outputText);
    }

}
