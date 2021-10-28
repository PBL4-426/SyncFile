package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileTree extends JPanel {
	/**
	 * Create the panel.
	 */
	JTree tree;
	public FileTree(String dir) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root", true);
		getList(root, new File(dir));
		setLayout(new BorderLayout());
		tree = new JTree(root);
		tree.setRootVisible(false);
		tree.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setBackground(Color.WHITE);
		this.setBounds(0, 120, 340, 520);
		add(new JScrollPane((JTree) tree), "Center");
	}

	public Dimension getPreferredSize() {
		return new Dimension(200, 120);
	}

	public void getList(DefaultMutableTreeNode node, File f) {
		if (!f.isDirectory()) {
			String s = f.getName();
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(s);
			node.add(child);

		} else {
			String sub = f.getAbsolutePath().replace("\\", "/");
			String[] avg = sub.split("/"); 
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(avg[avg.length-1]);
			node.add(child);
			File fList[] = f.listFiles();
			for (int i = 0; i < fList.length; i++) {
				System.out.println(fList[i]);
				getList(child, fList[i]);
			}
		}
	}
}
