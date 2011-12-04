import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;


public class MainGUI {

	private JFrame frame;
	private JTable infoTable;
	private String fileLocation;//need to set path of art work here
	private JTable playListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewPlaylist = new JMenuItem("New Playlist");
		mnFile.add(mntmNewPlaylist);
		
		JMenuItem mntmOpen = new JMenuItem("Open ");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditPlaylist = new JMenuItem("Edit Playlist");
		mnEdit.add(mntmEditPlaylist);
		
		JMenu mnControls = new JMenu("Controls");
		menuBar.add(mnControls);
		
		JMenuItem mntmPlay = new JMenuItem("Play");
		mnControls.add(mntmPlay);
		
		JMenuItem mntmPause = new JMenuItem("Pause");
		mnControls.add(mntmPause);
		
		JMenuItem mntmNext = new JMenuItem("Next");
		mnControls.add(mntmNext);
		
		JMenuItem mntmPrevious = new JMenuItem("Previous");
		mnControls.add(mntmPrevious);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmGuideUser = new JMenuItem("Guide user");
		mnHelp.add(mntmGuideUser);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JPanel playListPane = new JPanel();
		playListPane.setToolTipText("");
		
		JPanel mediaPlayerPanel = new JPanel();
		mediaPlayerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane infoScrollPanel = new JScrollPane();
		infoScrollPanel.setToolTipText("Information");
		
		/*
		 * panel for media player
		 */
		JLabel lblMediaPlayer = new JLabel("Media Player");
		mediaPlayerPanel.add(lblMediaPlayer);
		
		/*
		 * art work panel
		 */
		JPanel artWorkPanel = new JPanel();
		ImageIcon artwork = new ImageIcon(fileLocation);
		JLabel lblArtworklabel = new JLabel(artwork);
		artWorkPanel.add(lblArtworklabel);
		artWorkPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		/*
		 * table for information of songs
		 * it has 5 column: "Track #", "Name", "Gender", "Size", "Length", "Path"
		 * and maximum 50 rows/playlist
		 */
		
		infoTable = new JTable();
		infoTable.setModel(new DefaultTableModel(
			new Object[][] {
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Track #", "Name", "Gender", "Size", "Length", "Path"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, Double.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		infoTable.getColumnModel().getColumn(0).setPreferredWidth(39);
		infoTable.getColumnModel().getColumn(1).setPreferredWidth(117);
		infoTable.getColumnModel().getColumn(2).setPreferredWidth(57);
		infoTable.getColumnModel().getColumn(3).setPreferredWidth(37);
		infoScrollPanel.setRowHeaderView(infoTable);
		
		/*
		 * buttons of playlist panel
		 */
		JPanel buttonsPlayList = new JPanel();
		buttonsPlayList.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonsPlayList.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		buttonsPlayList.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		buttonsPlayList.add(btnNewButton_2);
		
		/*
		 * play list panel in a scroll panel
		 * play list panel is a table has 1 column and 20 rows
		 */
		JScrollPane playListScrollPanel = new JScrollPane();
		GroupLayout gl_playListPane = new GroupLayout(playListPane);
		gl_playListPane.setHorizontalGroup(
			gl_playListPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playListPane.createSequentialGroup()
					.addGroup(gl_playListPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_playListPane.createSequentialGroup()
							.addGap(6)
							.addComponent(playListScrollPanel, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_playListPane.setVerticalGroup(
			gl_playListPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playListPane.createSequentialGroup()
					.addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playListScrollPanel, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
		);
		
		playListTable = new JTable();
		playListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				""
			}
		));
		playListScrollPanel.setColumnHeaderView(playListTable);
		playListPane.setLayout(gl_playListPane);
		
		/*
		 * Group Layout contents all panels
		 */
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(playListPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(artWorkPanel, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(infoScrollPanel, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(mediaPlayerPanel, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(infoScrollPanel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mediaPlayerPanel, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playListPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(artWorkPanel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
					.addGap(7))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}
