package com.danilafe.nbt.tags;

public class ValueTag extends Tag{

	protected Object content;
	
	public ValueTag(java.lang.String name) {
		super(name);
	}
	
	public Object getValue(){
		return content;
	}
	
	public void setValue(Object newvalue){
		content = newvalue;
	}
	

}
