package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <i>"A length-prefixed UTF-8 string. The prefix is an unsigned short (thus 2 bytes)" </i><br><br>
 * Reads and stores one string.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class String extends Tag{
	
	public java.lang.String content = "";
	
	public String(java.lang.String name, FileInputStream r ){
		super(name);
		
		try {
			int length = r.read() << 8 | r.read();
			for(int i = 0; i < length; i ++){
				content += (char) r.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getValue(){
		return content;
	}
	
}
