package com.danilafe.nbt.tags;

import java.util.ArrayList;

public class ListTag extends Tag{

	protected ArrayList<Tag> content = new ArrayList<Tag>();
	
	public ListTag(java.lang.String name) {
		super(name);
	}
	
	public ArrayList<Tag> getValue(){
		return content;
	}
	
	public void set(int index, Tag newt){
		content.set(index, newt);
	}

}
