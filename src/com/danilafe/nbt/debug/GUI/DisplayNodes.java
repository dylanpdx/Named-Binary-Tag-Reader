package com.danilafe.nbt.debug.GUI;

import javax.swing.JFrame;
import javax.swing.JTree;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.danilafe.nbt.tags.Byte_Array;
import com.danilafe.nbt.tags.Compound;
import com.danilafe.nbt.tags.List;
import com.danilafe.nbt.tags.ListTag;
import com.danilafe.nbt.tags.Tag;
import com.danilafe.nbt.tags.ValueTag;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class DisplayNodes implements TreeSelectionListener{

	JFrame mainframe = new JFrame("NBT File Contents");
	JTree tree;
	JEditorPane editorPane;
	
	public DisplayNodes(Compound main){
		mainframe.getContentPane().setLayout(null);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(main.name);
		
		JLabel lblEditContents = new JLabel("View Contents");
		lblEditContents.setBounds(16, 223, 104, 16);
		mainframe.getContentPane().add(lblEditContents);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(132, 223, 312, 16);
		editorPane.setEditable(false);
		mainframe.getContentPane().add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 6, 428, 213);
		mainframe.getContentPane().add(scrollPane);
		
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);
		scrollPane.setViewportView(tree);
		
		
		mainframe.setVisible(true);
		mainframe.setSize(465, 265);
		mainframe.setResizable(false);
		
		addCompoundContents(main, top);
		
	}
	
	void addCompoundContents(Compound c, DefaultMutableTreeNode top){
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(t.name);
				node.setUserObject(((ValueTag)t).getValue());
				top.add(node);
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
	 void addCompoundContents(List c, DefaultMutableTreeNode top){
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(t.name);
				node.setUserObject(((ValueTag)t).getValue());
				top.add(node);
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
	
	 void addCompoundContents(Byte_Array c, DefaultMutableTreeNode top){
		ArrayList<Tag> v = (ArrayList<Tag>)c.getValue();
		for(Tag t: v){
			if(!(t instanceof ListTag)){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(t.name);
				node.setUserObject(((ValueTag)t).getValue());
				top.add(node);
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
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(node == null) return;
		
		if(node.isLeaf()){
			Object o = node.getUserObject();
			editorPane.setText(o.toString());	
		}
		
	}
}
