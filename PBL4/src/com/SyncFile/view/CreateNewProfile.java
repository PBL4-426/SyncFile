package com.SyncFile.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CreateNewProfile extends JDialog {
	private JTextField tbxProName;
	private JTextField tbxRemoteServer;
	private JTextField tbxEmail;
	private JPasswordField tbxPassword;
	
	/**
	 * Create the dialog.
	 */
	public CreateNewProfile(JFrame parent) {
		super(parent);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("New profile parameters");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 319, 30);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Profile name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 100, 150, 25);
		this.getContentPane().add(lblNewLabel_1);
		
		tbxProName = new JTextField();
		tbxProName.setBounds(200, 97, 250, 30);
		this.getContentPane().add(tbxProName);
		tbxProName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Remote Server:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(38, 139, 150, 25);
		this.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login Email:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(38, 179, 150, 25);
		this.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Login Password:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(38, 218, 150, 25);
		this.getContentPane().add(lblNewLabel_1_3);
		
		tbxRemoteServer = new JTextField();
		tbxRemoteServer.setColumns(10);
		tbxRemoteServer.setBounds(200, 137, 250, 30);
		this.getContentPane().add(tbxRemoteServer);
		
		tbxEmail = new JTextField();
		tbxEmail.setColumns(10);
		tbxEmail.setBounds(200, 177, 250, 30);
		this.getContentPane().add(tbxEmail);
		
		tbxPassword = new JPasswordField();
		tbxPassword.setBounds(200, 217, 250, 30);
		this.getContentPane().add(tbxPassword);
		
		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCreateProfile.setIcon(new ImageIcon("D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\NewProfilex30.png"));
		btnCreateProfile.setBounds(30, 300, 200, 40);
		this.getContentPane().add(btnCreateProfile);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCancel.setIcon(new ImageIcon("D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\Close_x30.png"));
		btnCancel.setBounds(250, 300, 200, 40);
		this.getContentPane().add(btnCancel);
		
		JButton btnTestConnect = new JButton("");
		btnTestConnect.setIcon(new ImageIcon("D:\\OneDriver\\OneDrive\\Desktop\\HKI\\LapTrinhMang\\Code\\PBL4\\Icon\\Start_x24.png"));
		btnTestConnect.setBounds(460, 217, 30, 30);
		this.getContentPane().add(btnTestConnect);
		this.setTitle("Creating a new profile");
		this.setSize(565,410);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}

}
