package com.SyncFile.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class SyncClient {

	private JFrame frmClientSynch;
	private JTextField tbxCurProName;
	private JTextField tbxRemoteServer;
	private JTextField tbxEmail;
	private JPasswordField passWord;
	private JPanel pnlProfile;
	private JComboBox comboBox;
	private JButton btnSynch;
	private JButton btnSave;
	private JPanel pnlFolders;
	private JEditorPane BoxLogs;
	private JButton btnModify;
	private JButton btnDelete;
	private JTree treeDictory;
	private JPanel pnlTreeFolder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SyncClient window = new SyncClient();
					window.frmClientSynch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	FileTree fTree;

	public SyncClient() {
		initialize();
	}

	private void initTree(File sf) {
		// a panel
		if (fTree != null) {
			frmClientSynch.remove(fTree);
		}
		fTree = new FileTree(sf.getAbsolutePath());
		frmClientSynch.getContentPane().add(fTree, "Center");
		frmClientSynch.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientSynch = new JFrame();
		frmClientSynch.getContentPane().setBackground(SystemColor.control);
		frmClientSynch.setTitle("ClientSynch");
		frmClientSynch.setSize(1024, 730);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmClientSynch.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmClientSynch.getHeight()) / 2);
		frmClientSynch.setLocation(x, y);

		frmClientSynch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientSynch.getContentPane().setLayout(null);

		JPanel pnlProfile = new JPanel();
		pnlProfile.setBackground(new Color(255, 250, 240));
		pnlProfile.setBounds(0, 0, 1010, 70);
		frmClientSynch.getContentPane().add(pnlProfile);
		pnlProfile.setLayout(null);

		JLabel lblAvProfiles = new JLabel("Available Profiles:");
		lblAvProfiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvProfiles.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAvProfiles.setBounds(50, 20, 120, 25);
		pnlProfile.add(lblAvProfiles);

		comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setBounds(180, 20, 200, 30);
		pnlProfile.add(comboBox);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("File");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//
				// disable the "All files" option.
				//
				chooser.setAcceptAllFileFilterUsed(false);
				//
				if (chooser.showOpenDialog(frmClientSynch) == JFileChooser.APPROVE_OPTION) {
					File sf = new File(chooser.getSelectedFile().getAbsolutePath());
					System.out.println(sf.getAbsolutePath());
					initTree(sf);
				} else {
					System.out.println("No Selection ");
				}
			}
		});
		btnSave.setIcon(
				new ImageIcon("D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\Save.png"));
		btnSave.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSave.setBackground(new Color(240, 255, 255));
		btnSave.setBounds(600, 15, 150, 40);
		pnlProfile.add(btnSave);

		btnSynch = new JButton("Sync");
		btnSynch.setIcon(
				new ImageIcon("D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\Backup.png"));
		btnSynch.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSynch.setBackground(new Color(240, 255, 255));
		btnSynch.setBounds(800, 15, 150, 40);
		pnlProfile.add(btnSynch);

		pnlFolders = new JPanel();
		pnlFolders.setBackground(SystemColor.WHITE);
		pnlFolders.setBounds(0, 120, 340, 520);
		frmClientSynch.getContentPane().add(pnlFolders);
		pnlFolders.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(350, 70, 660, 570);
		frmClientSynch.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(0, 0, 660, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblOptions = new JLabel(" Information");
		lblOptions.setFont(new Font("Arial", Font.PLAIN, 17));
		lblOptions.setBackground(new Color(153, 204, 204));
		lblOptions.setBounds(0, 0, 660, 50);
		panel_1.add(lblOptions);

		JPanel pnlOption = new JPanel();
		pnlOption.setBackground(new Color(255, 255, 240));
		pnlOption.setBounds(0, 50, 660, 200);
		panel.add(pnlOption);
		pnlOption.setLayout(null);

		JLabel lblAvProfiles_1 = new JLabel("Current Profile Name:");
		lblAvProfiles_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAvProfiles_1.setBounds(25, 30, 150, 25);
		pnlOption.add(lblAvProfiles_1);

		JLabel lblAvProfiles_2 = new JLabel("Remote Server:");
		lblAvProfiles_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAvProfiles_2.setBounds(25, 68, 120, 25);
		pnlOption.add(lblAvProfiles_2);

		JLabel lblAvProfiles_3 = new JLabel("Login Email:");
		lblAvProfiles_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAvProfiles_3.setBounds(25, 105, 120, 25);
		pnlOption.add(lblAvProfiles_3);

		JLabel lblAvProfiles_3_1 = new JLabel("Login Password:");
		lblAvProfiles_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAvProfiles_3_1.setBounds(25, 142, 120, 25);
		pnlOption.add(lblAvProfiles_3_1);

		tbxCurProName = new JTextField();
		tbxCurProName.setEditable(false);
		tbxCurProName.setBounds(200, 28, 250, 30);
		pnlOption.add(tbxCurProName);
		tbxCurProName.setColumns(10);

		tbxRemoteServer = new JTextField();
		tbxRemoteServer.setColumns(10);
		tbxRemoteServer.setBounds(200, 65, 250, 30);
		pnlOption.add(tbxRemoteServer);

		tbxEmail = new JTextField();
		tbxEmail.setColumns(10);
		tbxEmail.setBounds(200, 102, 250, 30);
		pnlOption.add(tbxEmail);

		passWord = new JPasswordField();
		passWord.setBounds(200, 139, 250, 30);
		pnlOption.add(passWord);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(153, 204, 204));
		panel_1_1.setBounds(0, 250, 660, 50);
		panel.add(panel_1_1);

		JLabel lblScheduler = new JLabel(" Scheduler");
		lblScheduler.setFont(new Font("Arial", Font.PLAIN, 17));
		lblScheduler.setBackground(new Color(153, 204, 204));
		lblScheduler.setBounds(0, 0, 660, 50);
		panel_1_1.add(lblScheduler);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 240));
		panel_2.setBounds(0, 300, 660, 270);
		panel.add(panel_2);
		panel_2.setLayout(null);

		BoxLogs = new JEditorPane();
		BoxLogs.setFont(new Font("Arial", Font.PLAIN, 17));
		BoxLogs.setText("No schedule");
		BoxLogs.setEditable(false);
		BoxLogs.setBackground(new Color(255, 255, 240));
		BoxLogs.setBounds(10, 10, 450, 250);
		panel_2.add(BoxLogs);

		btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(240, 255, 255));
		btnModify.setFont(new Font("Arial", Font.PLAIN, 17));
		btnModify.setIcon(new ImageIcon(
				"D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\AddSchedule.png"));
		btnModify.setBounds(470, 10, 180, 55);
		panel_2.add(btnModify);

		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(240, 248, 255));
		btnDelete.setIcon(new ImageIcon(
				"D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\DelSchedule.png"));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDelete.setBounds(470, 73, 180, 55);
		panel_2.add(btnDelete);

		JLabel lblFileFolder = new JLabel(" Files/Folders");
		lblFileFolder.setBounds(0, 70, 340, 50);
		frmClientSynch.getContentPane().add(lblFileFolder);
		lblFileFolder.setLabelFor(frmClientSynch);
		lblFileFolder.setFont(new Font("Arial", Font.PLAIN, 17));
		lblFileFolder.setBackground(new Color(153, 204, 204));

		JPanel pnl = new JPanel();
		pnl.setBounds(0, 70, 340, 50);
		frmClientSynch.getContentPane().add(pnl);
		pnl.setBackground(new Color(153, 204, 204));
		pnl.setLayout(null);
	}
}
