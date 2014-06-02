package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <i>"A single, big endian 16 bit integer" </i><br><br>
 * Reads and stores one short.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Short extends Tag{

	public short content = 0;
	
	public Short(java.lang.String name, FileInputStream r){
		super(name);
		try {
			int f = r.read();
			int s = r.read();
			content = (short) (f << 8 | s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Object getValue(){
		return content;
	}
	
}
