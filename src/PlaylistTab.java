import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
 
public class PlaylistTab extends JPanel {
 
    public PlaylistTab() {
        //super(new GridLayout(1,0));
        this.setLayout(new FlowLayout());

 
        String[] columnNames = {"Playlists"
                                };
 
        Object[][] data = {
        {"Kathy"},
        {"John"},
        {"Sue"},
        {"Jane"},
        {"Joe"}
        };
 
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(100, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        
        add(scrollPane);
    }
 
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlaylistTab newContentPane = new PlaylistTab();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
 
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) 
    {
        createAndShowGUI();
    }
}