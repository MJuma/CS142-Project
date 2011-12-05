/*
 * 
 */
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;


// TODO: Auto-generated Javadoc
/**
 * The Class MainGUI.
 */
public class MainGUI implements ActionListener
{

    /** The frame. */
    private JFrame frame;

    /** The playlist table. */
    private JTable mainWindowTable;

    /** The menu help_ about. */
    JMenuItem menuFile_AddSong, menuFile_AddPlaylist, menuFile_Exit, menuEdit_FindArtwork, menuControls, menuControls_PlayPause, menuControls_Stop,
    menuControls_Next, menuControls_Previous, menuHelp_Tutorial, menuHelp_Credits, menuHelp_About;

    /** The start controls. */
    Controls startControls;

    /** The play path. */
    static File playPath;

    // Main Windows Arrays
    ArrayList<String> mwtitle = new ArrayList<String>();
    ArrayList<String> mwartist = new ArrayList<String>();
    ArrayList<String> mwalbum = new ArrayList<String>();
    //ArrayList<String> mwtrack = new ArrayList<String>();
    ArrayList<String> mwyear = new ArrayList<String>();
    ArrayList<String> mwgenre = new ArrayList<String>();
    ArrayList<String> mwpath = new ArrayList<String>();
    ArrayList<Integer> mwlength = new ArrayList<Integer>();
    ArrayList<File> mwfile = new ArrayList<File>();
    int songsSelected;

    /**
     * Launch the application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try {
                    MainGUI window = new MainGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @throws FileNotFoundException 
     */
    public MainGUI() throws FileNotFoundException 
    {
        frame = new JFrame();
        frame.setBounds(100, 10, 1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuFile_AddSong = new JMenuItem("Add Song");
        menuFile.add(menuFile_AddSong);
        menuFile_AddSong.addActionListener(this);

//        menuFile_AddPlaylist = new JMenuItem("Add Playlist");
//        menuFile.add(menuFile_AddPlaylist);
//        menuFile_AddPlaylist.addActionListener(this);

        menuFile_Exit = new JMenuItem("Exit");
        menuFile.add(menuFile_Exit);
        menuFile_Exit.addActionListener(this);

//        JMenu menuEdit = new JMenu("Edit");
//        menuBar.add(menuEdit);
//
//        menuEdit_FindArtwork = new JMenuItem("Find Album Artwork");
//        menuEdit.add(menuEdit_FindArtwork);
//        menuEdit_FindArtwork.addActionListener(this);

        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        menuHelp_Tutorial = new JMenuItem("Tutorial");
        menuHelp.add(menuHelp_Tutorial);
        menuHelp_Tutorial.addActionListener(this);

        menuHelp_Credits = new JMenuItem("Credits");
        menuHelp.add(menuHelp_Credits);
        menuHelp_Credits.addActionListener(this);

        menuHelp_About = new JMenuItem("About");
        menuHelp.add(menuHelp_About);
        menuHelp_About.addActionListener(this);

        JPanel controlsPanel = new JPanel();
        controlsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

        JScrollPane mainWindowPanel = new JScrollPane();
        mainWindowPanel.setToolTipText("Information");
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(mainWindowPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
                        .addComponent(controlsPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainWindowPanel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(controlsPanel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                    .addGap(7))
        );

        //        JLabel artworkPanel_Title = new JLabel("Art Work"); //artwork panel displays the selected artwork file
        //        ArtworkFinder a = new ArtworkFinder();  // calls a new artworkfinder class
        //        
        //        ImageIcon art = new ImageIcon(a.getArtwork());  //
        //        artworkPanel.add(artworkPanel_Title);

        JLabel controlsPanel_Title = new JLabel("");
        controlsPanel.add(controlsPanel_Title);
        startControls = new Controls();
        controlsPanel.add(startControls);

        String[][] str = new String[35][6];

        for (int i=0; i<35; i++)
        {
            for (int j=0; j<6; j++)
            {
                str[i][j] = "";
            }
        }

        String[] names = new String[] {"Name", "Artist", "Album", "Genre", "Length", "Year"};

        mainWindowTable = new JTable();
        mainWindowTable.setEnabled(false);
        mainWindowTable.setModel(new DefaultTableModel(str,names )
        {
            Class[] columnTypes = new Class[] 
                    {
                    String.class, String.class, String.class, String.class, String.class, String.class
                    };
            public Class getColumnClass(int columnIndex) 
            {
                return columnTypes[columnIndex];
            }
        });
        mainWindowTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        mainWindowTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        mainWindowTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        mainWindowTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        mainWindowTable.getColumnModel().getColumn(4).setPreferredWidth(37);
        mainWindowTable.getColumnModel().getColumn(5).setPreferredWidth(37);
        mainWindowPanel.setViewportView(mainWindowTable);

        String[][] playlists = {};


        String[] playlistsColumnName = {"Playlists"};
        frame.getContentPane().setLayout(groupLayout);
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == menuFile_AddSong) 
        {
            AddSongs as = new AddSongs();

            playPath = as.getFile().get(0);

            startControls.setPlayPath(as.getFile());

            mwtitle = as.getTitle();
            mwalbum = as.getAlbum();
            mwartist = as.getArtist();
            mwgenre = as.getGenre();
            mwyear = as.getYear();
            mwlength = as.getLength();
            mwpath = as.getPath();
            songsSelected = as.songsSelected();

            String[][] str2 = new String[35][6];

            for (int i=0; i<songsSelected; i++)
            {
                for (int j=0; j<6; j++)
                {
                    str2[i][0] = mwtitle.get(i);
                    str2[i][1] = mwartist.get(i);
                    str2[i][2] = mwalbum.get(i);
                    str2[i][3] = mwgenre.get(i);
                    str2[i][4] = (mwlength.get(i)/60) + ":" + (mwlength.get(i)%60);
                    str2[i][5] = mwyear.get(i);
                }
            }
            
            String[] names2 = new String[] {"Name", "Artist", "Album", "Genre", "Length", "Year"};

            mainWindowTable.setModel(new DefaultTableModel(str2,names2)
            {
                Class[] columnTypes = new Class[] 
                        {
                        String.class, String.class, String.class, String.class, String.class, String.class
                        };
                public Class getColumnClass(int columnIndex) 
                {
                    return columnTypes[columnIndex];
                }
            });
            mainWindowTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            mainWindowTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            mainWindowTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            mainWindowTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            mainWindowTable.getColumnModel().getColumn(4).setPreferredWidth(37);
            mainWindowTable.getColumnModel().getColumn(5).setPreferredWidth(37);

        }
//        if (e.getSource() == menuFile_AddPlaylist) 
//        {
//
//        }
        if (e.getSource() == menuFile_Exit) 
        {
            System.exit(0);
        }
//        if (e.getSource() == menuEdit_FindArtwork) 
//        {
//            ArtworkFinder art = new ArtworkFinder(mwartist.get(0), mwalbum.get(0));
//            try {
//                art.getArtwork();
//            } catch (FileNotFoundException e1) {
//                e1.printStackTrace();
//            }
//        }
        if (e.getSource() == menuHelp_Tutorial) 
        {
            JOptionPane.showMessageDialog(null,
                    "Adding music:\n\n"+
                            "To add music you first go to file and click at ‘Add New’ song this will open\n"+ 
                            "a file chooser menu.  From this menu you can browse through the files in your\n"+ 
                            "computer and click the song.  The song must be an .mp3 file.\n"+ 
                            "To add a playlist you go to file and click ‘Add Playlist’ and a file chooser menu\n"+
                            "will open up.  From this menu you can browse through files and add a playlist. The\n"+
                            "playlist folder must be an .m3u folder.\n\n"+

                            "Adding Album Art:\n\n"+
                            "To add file artwork you will need to click the edit button on the tool bar and scroll\n"+
                            "down to ‘Find Album Artwork’. This will transfer you to Google image which will allow\n"+
                            "you to save an image to your computer.  Then a file chooser will open and allow you to\n"+ 
                            "choose the image you just saved. The artwork you save will show up every time you click\n"+ 
                            "on the song.\n\n"+

                            "Playing Music:\n\n"+
                            "To play music you press the ‘Play’ button or click on the control button on the tool bar\n"+
                            "and there is an option to play music from there. There also is a button to ‘Pause’ and the\n"+ "" +
                            "temporally pause the track and you can resume the track by pressing the 'Resume'button."
                    );
        }
        if (e.getSource() == menuHelp_Credits) 
        {
            JOptionPane.showMessageDialog(null,"Credits:\nMohammad Juma:"+"    "+"Media Player\nNhat Tran:"+"    "+"    Main Gui\nKhoa Nguyen:"+"    "+"Import Files\n" +
                    "Luke Dewhirst:"+"    "+"Song Organization\nJulian Jones:"+"    "+"ToolBar, Documentation" + "\n\nTools Used:\nJAudio Tagger\nJLayer\nGoogle Window Builder Pro");        }
        if (e.getSource() == menuHelp_About) 
        {
            JOptionPane.showMessageDialog(null,"About:\n\nVersion 1.0\nCopyright: 2011");
        }
    }

    /**
     * Gets the play path.
     *
     * @return the play path
     */
    public File getPlayPath()
    {
        return playPath;
    }
}
