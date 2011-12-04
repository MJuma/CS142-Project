import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;


public class Gui extends JPanel
{
    
    private JFrame frame;
    private JButton test;

    
    public Gui()
    {
      frame = new JFrame();
      frame.setTitle("MP3 Player");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(this);
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{84, 308, 0};
      gridBagLayout.rowHeights = new int[]{276, 0, 75, 0};
      gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
      setLayout(gridBagLayout);
      
      JScrollPane playlistPane = new JScrollPane();
      GridBagConstraints gbc_playlistPane = new GridBagConstraints();
      gbc_playlistPane.gridheight = 2;
      gbc_playlistPane.insets = new Insets(0, 0, 5, 5);
      gbc_playlistPane.fill = GridBagConstraints.BOTH;
      gbc_playlistPane.gridx = 0;
      gbc_playlistPane.gridy = 0;
      add(playlistPane, gbc_playlistPane);
      
      JScrollPane selectedPlaylistPane = new JScrollPane();
      GridBagConstraints gbc_selectedPlaylistPane = new GridBagConstraints();
      gbc_selectedPlaylistPane.gridheight = 2;
      gbc_selectedPlaylistPane.insets = new Insets(0, 0, 5, 0);
      gbc_selectedPlaylistPane.fill = GridBagConstraints.BOTH;
      gbc_selectedPlaylistPane.gridx = 1;
      gbc_selectedPlaylistPane.gridy = 0;
      add(selectedPlaylistPane, gbc_selectedPlaylistPane);
      
      JPanel artworkPane = new JPanel();
      GridBagConstraints gbc_artworkPane = new GridBagConstraints();
      gbc_artworkPane.insets = new Insets(0, 0, 0, 5);
      gbc_artworkPane.fill = GridBagConstraints.BOTH;
      gbc_artworkPane.gridx = 0;
      gbc_artworkPane.gridy = 2;
      add(artworkPane, gbc_artworkPane);
      
      JPanel controlsPane = new JPanel();
      GridBagConstraints gbc_controlsPane = new GridBagConstraints();
      gbc_controlsPane.fill = GridBagConstraints.BOTH;
      gbc_controlsPane.gridx = 1;
      gbc_controlsPane.gridy = 2;
      add(controlsPane, gbc_controlsPane);
      
      Controls startControls = new Controls();
      controlsPane.add(startControls);
      
      frame.setBounds(400, 200, 400, 400);
      
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);
      
      JMenu menuItemFile = new JMenu("File");
      menuBar.add(menuItemFile);
      
      JMenuItem menuItemFile_AddSong = new JMenuItem("Add Song");
      menuItemFile.add(menuItemFile_AddSong);
      
      JMenuItem menuItemFile_AddPlaylist = new JMenuItem("Add Playlist");
      menuItemFile.add(menuItemFile_AddPlaylist);
      
      JMenuItem menuItemFile_Exit = new JMenuItem("Exit");
      menuItemFile.add(menuItemFile_Exit);
      
      JMenu menuItemEdit_FindAlbumArtwork = new JMenu("Edit");
      menuBar.add(menuItemEdit_FindAlbumArtwork);
      
      JMenuItem mntmFindAlbumArtwork = new JMenuItem("Find Album Artwork");
      menuItemEdit_FindAlbumArtwork.add(mntmFindAlbumArtwork);
      
      JMenu menuItemView = new JMenu("View");
      menuBar.add(menuItemView);
      
      JMenuItem menuItemView_AlbumArtwork = new JMenuItem("Album Artwork");
      menuItemView.add(menuItemView_AlbumArtwork);
      
      JMenuItem menuItemView_SongInfo = new JMenuItem("Song Info");
      menuItemView.add(menuItemView_SongInfo);
      
      JMenu menuItemControls = new JMenu("Controls");
      menuBar.add(menuItemControls);
      
      JMenuItem menuItemControls_PlayPause = new JMenuItem("Play / Pause");
      menuItemControls.add(menuItemControls_PlayPause);
      
      JMenuItem menuItemControls_Stop = new JMenuItem("Stop");
      menuItemControls.add(menuItemControls_Stop);
      
      JMenuItem menuItemControls_PreviousTrack = new JMenuItem("Previous Track");
      menuItemControls.add(menuItemControls_PreviousTrack);
      
      JMenuItem menuItemControls_NextTrack = new JMenuItem("Next Track");
      menuItemControls.add(menuItemControls_NextTrack);
      
      JMenu menuItemTools = new JMenu("Tools");
      menuBar.add(menuItemTools);
      
      JMenu menuItemHelp = new JMenu("Help");
      menuBar.add(menuItemHelp);
      
      JMenuItem menuItemHelp_Tutorial = new JMenuItem("Tutorial");
      menuItemHelp.add(menuItemHelp_Tutorial);
      
      JMenuItem menuItemHelp_Credits = new JMenuItem("Credits");
      menuItemHelp.add(menuItemHelp_Credits);
      
      frame.setVisible(true);
      
      populateGUI();
    }
    
    private void populateGUI()
    {


    }
    
    public static void main(String[] args)
    {
        new Gui();
    }

}
