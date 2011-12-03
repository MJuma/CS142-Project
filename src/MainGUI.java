import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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


public class MainGUI {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

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
		mntmNewPlaylist.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			} 

		}
				);

		JMenuItem mntmOpen = new JMenuItem("Open ");
		mnFile.add(mntmOpen);
		mntmOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			} 

		}
				);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		}
				);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditPlaylist = new JMenuItem("Edit Playlist");
		mnEdit.add(mntmEditPlaylist);
		mntmEditPlaylist.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			} 

		}
				);

		JMenu mnControls = new JMenu("Controls");
		menuBar.add(mnControls);
		

		JMenuItem mntmPlay = new JMenuItem("Play");
		mnControls.add(mntmPlay);
		mntmPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"Add song tto library");
			} 

		}
				);

		JMenuItem mntmPause = new JMenuItem("Pause");
		mnControls.add(mntmPause);
		mntmPause.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"Add song tto library");
			} 

		}
				);

		JMenuItem mntmNext = new JMenuItem("Next");
		mnControls.add(mntmNext);
		mntmNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			} 

		}
				);

		JMenuItem mntmPrevious = new JMenuItem("Previous");
		mnControls.add(mntmPrevious);
		mntmPrevious.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			} 

		}
				);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		

		JMenuItem mntmGuideUser = new JMenuItem("Guide user");
		mnHelp.add(mntmGuideUser);
		mntmGuideUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"");
			} 

		}
				);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"MP3 Player and Song Organizer n/By ");
			} 

		}
				);

		JPanel playListPane = new JPanel();
		playListPane.setToolTipText("");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Information");

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playListPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(6)
										.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
												.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
												.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addGap(7))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(playListPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
												.addContainerGap())))
				);

		JLabel lblArtWork = new JLabel("Art Work");
		panel_3.add(lblArtWork);

		JLabel lblMediaPlayer = new JLabel("Media Player");
		panel_1.add(lblMediaPlayer);
		Controls begin = new Controls();
		panel_1.add(begin);

		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(3).setPreferredWidth(37);
		scrollPane.setViewportView(table);

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

		JScrollPane scrollPane_1 = new JScrollPane();

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
				},
				new String[] {
						"New column"
				}
				));
		GroupLayout gl_playListPane = new GroupLayout(playListPane);
		gl_playListPane.setHorizontalGroup(
				gl_playListPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playListPane.createSequentialGroup()
						.addGroup(gl_playListPane.createParallelGroup(Alignment.LEADING)
								.addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_playListPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_playListPane.setVerticalGroup(
				gl_playListPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playListPane.createSequentialGroup()
						.addComponent(buttonsPlayList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_playListPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_playListPane.createSequentialGroup()
										.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
										.addGap(6))))
				);
		playListPane.setLayout(gl_playListPane);
		frame.getContentPane().setLayout(groupLayout);
	}
}
