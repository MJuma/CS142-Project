import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.FlowLayout;
 
public class PlaylistTab extends JPanel {
 
    public PlaylistTab() {
        //super(new GridLayout(1,0));
        this.setLayout(new FlowLayout());

 
        String[] columnNames = {"Playlists"};
 
        Object[][] data = 
            {
                {"Song 1"},
                {"Song 2"},
                {"Song 3"},
                {"Song 4"},
                {"Song 5"}
            };
 
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(209, 360));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        
        add(scrollPane);
    }

   
//    public static void main(String[] args) 
//    {
//        createAndShowGUI();
//    }
}