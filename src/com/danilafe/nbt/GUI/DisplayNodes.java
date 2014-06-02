package com.danilafe.nbt.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.danilafe.nbt.tags.Compound;
import com.danilafe.nbt.tags.Tag;

public class DisplayNodes implements TreeSelectionListener{

	JTree tree;
	
	public DisplayNodes(Compound main){
		JFrame display = new JFrame("Contents of main node.");
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(main.name);
		tree = new JTree(top);
		tree.addTreeSelectionListener(this);
		JScrollPane p = new JScrollPane(tree);
		
		addCompoundContents(main, top);
		
		display.setSize(500,500);
		display.setVisible(true);
		display.add(p);
		
	}
	
	private void addCompoundContents(Compound c, DefaultMutableTreeNode top){
		for(Tag t: c.contents){
			if(!(t instanceof Compound)){
				top.add(new DefaultMutableTreeNode(t.name));
			} else {
				DefaultMutableTreeNode newtag = new DefaultMutableTreeNode(t.name);
				top.add(newtag);
				addCompoundContents((Compound)t, newtag);
			}
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(node == null) return;
		
		
	}
	
}
