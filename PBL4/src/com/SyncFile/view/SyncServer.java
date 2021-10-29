package com.SyncFile.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SyncServer {

	private JFrame frmSyncserver;

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
					SyncServer window = new SyncServer();
					window.frmSyncserver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SyncServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSyncserver = new JFrame();
		frmSyncserver.setBackground(new Color(255, 255, 240));
		frmSyncserver.setTitle("SyncServer");
		frmSyncserver.setSize(1200, 712);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frmSyncserver.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frmSyncserver.getHeight()) / 2);
		frmSyncserver.setLocation(x, y);
		frmSyncserver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSyncserver.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.info);
		tabbedPane.setBorder(UIManager.getBorder("Table.cellNoFocusBorder"));
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 17));
		tabbedPane.setBounds(0, 0, 1182, 665);
		frmSyncserver.getContentPane().add(tabbedPane);
		
		JPanel tabHome = new JPanel();
		tabbedPane.addTab("Home", null, tabHome, null);
		tabHome.setLayout(null);
		
		JPanel pnlInfoServer = new JPanel();
		pnlInfoServer.setBackground(new Color(245, 255, 250));
		pnlInfoServer.setBounds(0, 0, 1172, 300);
		tabHome.add(pnlInfoServer);
		pnlInfoServer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 1172, 40);
		pnlInfoServer.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Information Server");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(496, 0, 180, 40);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name Server:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(100, 70, 180, 25);
		pnlInfoServer.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IP Server:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(100, 153, 180, 25);
		pnlInfoServer.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Time running:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(100, 237, 180, 25);
		pnlInfoServer.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Total users:");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(650, 70, 180, 25);
		pnlInfoServer.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Total Profiles:");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(650, 153, 180, 25);
		pnlInfoServer.add(lblNewLabel_1_1_3);
		
		JLabel lblNameServer = new JLabel("SyncFile");
		lblNameServer.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNameServer.setBounds(252, 70, 180, 25);
		pnlInfoServer.add(lblNameServer);
		
		JLabel lblIPServer = new JLabel("192.168.1.1");
		lblIPServer.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIPServer.setBounds(252, 153, 180, 25);
		pnlInfoServer.add(lblIPServer);
		
		JLabel lblTimeRunning = new JLabel("30/10/2021 10:50 AM");
		lblTimeRunning.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeRunning.setBounds(252, 242, 180, 25);
		pnlInfoServer.add(lblTimeRunning);
		
		JLabel lblTotalUsers = new JLabel("5");
		lblTotalUsers.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotalUsers.setBounds(826, 75, 180, 25);
		pnlInfoServer.add(lblTotalUsers);
		
		JLabel lblTotalProfiles = new JLabel("10");
		lblTotalProfiles.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotalProfiles.setBounds(826, 158, 180, 25);
		pnlInfoServer.add(lblTotalProfiles);
		
		JPanel pnlInfoFile = new JPanel();
		pnlInfoFile.setBackground(new Color(245, 255, 250));
		pnlInfoFile.setBounds(0, 312, 1172, 300);
		tabHome.add(pnlInfoFile);
		pnlInfoFile.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 0, 1172, 40);
		pnlInfoFile.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFileAndMemmory = new JLabel("File and Memory");
		lblFileAndMemmory.setBounds(496, 0, 180, 40);
		lblFileAndMemmory.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileAndMemmory.setFont(new Font("Arial", Font.BOLD, 17));
		panel_1.add(lblFileAndMemmory);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total files:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(97, 79, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total Memory:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(652, 220, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_4);
		
		JLabel lblTotalFiles = new JLabel("100");
		lblTotalFiles.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotalFiles.setBounds(262, 79, 180, 25);
		pnlInfoFile.add(lblTotalFiles);
		
		JLabel lblNewLabel_1_7 = new JLabel("466 MB");
		lblNewLabel_1_7.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_7.setBounds(833, 220, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Used Memory:");
		lblNewLabel_1_8.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_8.setBounds(652, 79, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Allocated Memory:");
		lblNewLabel_1_9.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_9.setBounds(652, 148, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_9);
		
		JLabel lblUsedMem = new JLabel("175 MB");
		lblUsedMem.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsedMem.setBounds(833, 79, 180, 25);
		pnlInfoFile.add(lblUsedMem);
		
		JLabel lblNewLabel_1_11 = new JLabel("277 MB");
		lblNewLabel_1_11.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_11.setBounds(833, 153, 180, 25);
		pnlInfoFile.add(lblNewLabel_1_11);
		
		JPanel tabUsers = new JPanel();
		tabbedPane.addTab("Users", null, tabUsers, null);
		
		JPanel tabProfiles = new JPanel();
		tabbedPane.addTab("Profiles", null, tabProfiles, null);
	}
}
