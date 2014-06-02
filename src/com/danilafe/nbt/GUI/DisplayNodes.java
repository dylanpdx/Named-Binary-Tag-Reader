package com.danilafe.nbt.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.danilafe.nbt.tags.Byte_Array;
import com.danilafe.nbt.tags.Compound;
import com.danilafe.nbt.tags.List;
import com.danilafe.nbt.tags.ListTag;
import com.danilafe.nbt.tags.Tag;
import com.danilafe.nbt.tags.ValueTag;

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
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				top.add(new DefaultMutableTreeNode(((ValueTag)t).getValue() + " " + t.name));
			} else {
				DefaultMutableTreeNode newtag = new DefaultMutableTreeNode(t.name);
				top.add(newtag);
				if(t instanceof Compound){
					addCompoundContents((Compound)t, newtag);
				} else if(t instanceof List){
					addCompoundContents((List)t, newtag);
				} else if(t instanceof Byte_Array){
					addCompoundContents((Byte_Array)t, newtag);
				}
			}
		}
	}
	private void addCompoundContents(List c, DefaultMutableTreeNode top){
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				top.add(new DefaultMutableTreeNode(((ValueTag)t).getValue() + " " + t.name));
			} else {
				DefaultMutableTreeNode newtag = new DefaultMutableTreeNode(t.name);
				top.add(newtag);
				if(t instanceof Compound){
					addCompoundContents((Compound)t, newtag);
				} else if(t instanceof List){
					addCompoundContents((List)t, newtag);
				} else if(t instanceof Byte_Array){
					addCompoundContents((Byte_Array)t, newtag);
				}
			}
		}
	}
	
	private void addCompoundContents(Byte_Array c, DefaultMutableTreeNode top){
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				top.add(new DefaultMutableTreeNode(((ValueTag)t).getValue() + " " + t.name));
			} else {
				DefaultMutableTreeNode newtag = new DefaultMutableTreeNode(t.name);
				top.add(newtag);
				if(t instanceof Compound){
					addCompoundContents((Compound)t, newtag);
				} else if(t instanceof List){
					addCompoundContents((List)t, newtag);
				} else if(t instanceof Byte_Array){
					addCompoundContents((Byte_Array)t, newtag);
				}
			}
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(node == null) return;
		
		
	}
	
}
