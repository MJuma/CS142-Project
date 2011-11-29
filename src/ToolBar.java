import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class ToolBar extends JFrame
{
	public ToolBar()
	{

		setTitle("Media Player");
		setSize(400, 150);


		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);


		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu viewMenu = new JMenu("View");
		JMenu controlMenu=new JMenu("Control");
		JMenu toolsMenu=new JMenu("Tools");
		JMenu helpMenu=new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(controlMenu);
		menuBar.add(toolsMenu);
		menuBar.add(helpMenu);


		JMenuItem newAction =   new JMenuItem("Add File");
		JMenuItem playlistAction =  new JMenuItem("New Playlist");
		JMenuItem exitAction =  new JMenuItem("Exit");
		JMenuItem undoAction =   new JMenuItem("Undo");
		JMenuItem copyAction =  new  JMenuItem("Copy");
		JMenuItem pasteAction =  new JMenuItem("Paste");
		JMenuItem albumAction= new JMenuItem("Album of selected song");
		JMenuItem playAction= new JMenuItem("Play");
		JMenuItem playrecAction= new JMenuItem("Play Recent");
		JMenuItem totalAction= new JMenuItem("Total Play time");
		JMenuItem mediainsAction=new JMenuItem("Media Player Help");


		fileMenu.add(newAction);
		fileMenu.add(playlistAction);
		//fileMenu.addSeparator();
		fileMenu.add(exitAction);
		editMenu.add(undoAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		//editMenu.addSeparator();
		viewMenu.add(albumAction);
		controlMenu.add(playAction);
		controlMenu.add(playrecAction);
		toolsMenu.add(totalAction);
		helpMenu.add(mediainsAction);


		newAction.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"Add song tto library");
			} 

		}
				);	
		playlistAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"creat a new playlist");
			} 
		}

				);
		undoAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"undo the last command");
			} 
		}
				);
		copyAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"copy the highlighted");
			} 
		}
				);
		pasteAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"paste what was copied");
			} 
		}
				);
		albumAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"shows the album of selected song");
			} 
		}
				);
		playAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"plays song");
			} 
		}
				);
		playrecAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"plays the last played song");
			} 
		}
				);
		mediainsAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"The hows to the media player and familiar problems that occur");
			} 
		}
				);
		totalAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				JOptionPane.showMessageDialog(null,"adds up the total time of your playlist");
			} 
		}
				);
		exitAction.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent arg0)

			{
				System.exit(0);
			} 
		}
				);
	}

	public static void main(String[] args) 

	{
//		ToolBar mba = new ToolBar();
//		mba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mba.setVisible(true);
	}
}
