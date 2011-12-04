import java.awt.EventQueue;

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
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class MainGUI implements ActionListener
{

    private JFrame frame;
    private JTable mainWindowTable;
    private JTable playlistTable;

    JMenuItem menuFile_AddSong,
    menuFile_AddPlaylist,
    menuFile_Exit,
    menuEdit_FindArtwork,
    menuControls,
    menuControls_PlayPause,
    menuControls_Stop,
    menuControls_Next,
    menuControls_Previous,
    menuHelp_Tutorial,
    menuHelp_Credits,
    menuHelp_About;
    
    static File playPath;

    /**
     * Launch the application.
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
     */
    public MainGUI() 
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuFile_AddSong = new JMenuItem("Add Song");
        menuFile.add(menuFile_AddSong);
        menuFile_AddSong.addActionListener(this);

        menuFile_AddPlaylist = new JMenuItem("Add Playlist");
        menuFile.add(menuFile_AddPlaylist);
        menuFile_AddPlaylist.addActionListener(this);

        menuFile_Exit = new JMenuItem("Exit");
        menuFile.add(menuFile_Exit);
        menuFile_Exit.addActionListener(this);

        JMenu menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuEdit_FindArtwork = new JMenuItem("Find Album Artwork");
        menuEdit.add(menuEdit_FindArtwork);
        menuEdit_FindArtwork.addActionListener(this);

        JMenu menuControls = new JMenu("Controls");
        menuBar.add(menuControls);

        menuControls_PlayPause = new JMenuItem("Play / Pause");
        menuControls.add(menuControls_PlayPause);
        menuControls_PlayPause.addActionListener(this);

        menuControls_Stop = new JMenuItem("Stop");
        menuControls.add(menuControls_Stop);
        menuControls_Stop.addActionListener(this);

        menuControls_Next = new JMenuItem("Next Track");
        menuControls.add(menuControls_Next);
        menuControls_Next.addActionListener(this);

        menuControls_Previous = new JMenuItem("Previous Track");
        menuControls.add(menuControls_Previous);
        menuControls_Previous.addActionListener(this);

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

        JPanel playlistPanel = new JPanel();
        playlistPanel.setToolTipText("");

        JPanel controlsPanel = new JPanel();
        controlsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

        JScrollPane mainWindowPanel = new JScrollPane();
        mainWindowPanel.setToolTipText("Information");

        JPanel artworkPanel = new JPanel();
        artworkPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(playlistPanel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addGap(6)
                                        .addComponent(artworkPanel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(mainWindowPanel, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                                .addComponent(controlsPanel, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                                                .addContainerGap())
                );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                        .addComponent(mainWindowPanel, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(controlsPanel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addGap(7))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(playlistPanel, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(artworkPanel, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                .addContainerGap())))
                );

        JLabel artworkPanel_Title = new JLabel("Art Work");
        artworkPanel.add(artworkPanel_Title);

        JLabel controlsPanel_Title = new JLabel("Media Player");
        controlsPanel.add(controlsPanel_Title);
        Controls startControls = new Controls();
        controlsPanel.add(startControls);

        mainWindowTable = new JTable();
        mainWindowTable.setModel(new DefaultTableModel(
                new Object[][] 
                        {
                        {null, "", "", null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        },
                        new String[] 
                                {
                        "Track #", "Name", "Genre", "Size", "Length", "Path"
                                }
                ) {
            Class[] columnTypes = new Class[] 
                    {
                    Integer.class, String.class, String.class, Double.class, Double.class, Object.class
                    };
            public Class getColumnClass(int columnIndex) 
            {
                return columnTypes[columnIndex];
            }
        });
        mainWindowTable.getColumnModel().getColumn(0).setPreferredWidth(39);
        mainWindowTable.getColumnModel().getColumn(1).setPreferredWidth(117);
        mainWindowTable.getColumnModel().getColumn(2).setPreferredWidth(57);
        mainWindowTable.getColumnModel().getColumn(3).setPreferredWidth(37);
        mainWindowPanel.setViewportView(mainWindowTable);

        JPanel buttonsPlayList = new JPanel();
        buttonsPlayList.setLayout(new GridLayout(1, 3, 0, 0));

        JButton playlistButton_New = new JButton("New");
        playlistButton_New.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) 
            {
            }
        });
        buttonsPlayList.add(playlistButton_New);

        JButton playlistButton_Edit = new JButton("Edit");
        buttonsPlayList.add(playlistButton_Edit);

        JButton playlistButton_Delete = new JButton("Delete");
        buttonsPlayList.add(playlistButton_Delete);

        JScrollPane scrollPane_1 = new JScrollPane();

        Object[][] playlists = 
            {
                {"Song 1"},
                {"Song 2"},
                {"Song 3"},
                {"Song 4"},
                {"Song 5"}
            };


        String[] playlistsColumnName = {"Playlists"};

        ArrayList al = new ArrayList();

        al.add("C"); 

        playlistTable = new JTable();
        playlistTable.setModel(new DefaultTableModel(playlists, playlistsColumnName));

        GroupLayout gl_playlistPanel = new GroupLayout(playlistPanel);
        gl_playlistPanel.setHorizontalGroup(
                gl_playlistPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_playlistPanel.createSequentialGroup()
                        .addGroup(gl_playlistPanel.createParallelGroup(Alignment.LEADING)
                                .addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_playlistPanel.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(playlistTable, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        gl_playlistPanel.setVerticalGroup(
                gl_playlistPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_playlistPanel.createSequentialGroup()
                        .addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_playlistPanel.createParallelGroup(Alignment.TRAILING)
                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_playlistPanel.createSequentialGroup()
                                        .addComponent(playlistTable, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                        .addGap(6))))
                );
        playlistPanel.setLayout(gl_playlistPanel);
        frame.getContentPane().setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == menuFile_AddSong) 
        {
            AddSongs as = new AddSongs();
            
            playPath = as.getFile().get(0);
            
//          for(int i = 0; i<=as.getTitle().size() - 1; i++)
//          {
//              System.out.println(as.getTitle().get(i) + "  " + as.getArtist().get(i) + "  " + as.getAlbum().get(i)
//                      + "  " + as.getLength().get(i) + "  " + as.getYear().get(i) + "  " + as.getGenre().get(i) + "  " + as.getPath().get(i));
//          }  
        }
        if (e.getSource() == menuFile_AddPlaylist) 
        {

        }
        if (e.getSource() == menuFile_Exit) 
        {
            System.exit(0);
        }
        if (e.getSource() == menuEdit_FindArtwork) 
        {

        }
        if (e.getSource() == menuControls_PlayPause) 
        {

        }
        if (e.getSource() == menuControls_Stop) 
        {

        }
        if (e.getSource() == menuControls_Next) 
        {

        }
        if (e.getSource() == menuControls_Previous) 
        {

        }
        if (e.getSource() == menuHelp_Tutorial) 
        {

        }
        if (e.getSource() == menuHelp_Credits) 
        {
            JOptionPane.showMessageDialog(null,"Credits Page");
        }
        if (e.getSource() == menuHelp_About) 
        {
            JOptionPane.showMessageDialog(null,"About Page");
        }
    }
    
    public File getPlayPath()
    {
        return playPath;
    }
}
