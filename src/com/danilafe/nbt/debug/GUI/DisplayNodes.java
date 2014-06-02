package com.danilafe.nbt.debug.GUI;

import javax.swing.JFrame;
import javax.swing.JTree;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.danilafe.nbt.tags.Byte_Array;
import com.danilafe.nbt.tags.Compound;
import com.danilafe.nbt.tags.List;
import com.danilafe.nbt.tags.ListTag;
import com.danilafe.nbt.tags.Tag;
import com.danilafe.nbt.tags.ValueTag;

import javax.swing.JScrollPane;

public class DisplayNodes {

	JFrame mainframe = new JFrame("NBT File Contents");
	

	public DisplayNodes(Compound main){
		mainframe.getContentPane().setLayout(null);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(main.name);
		
		JLabel lblEditContents = new JLabel("Edit Contents");
		lblEditContents.setBounds(16, 223, 85, 16);
		mainframe.getContentPane().add(lblEditContents);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(113, 223, 331, 16);
		mainframe.getContentPane().add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 6, 428, 213);
		mainframe.getContentPane().add(scrollPane);
		
		JTree tree = new JTree(top);
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
	 void addCompoundContents(List c, DefaultMutableTreeNode top){
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
	
	 void addCompoundContents(Byte_Array c, DefaultMutableTreeNode top){
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
}
