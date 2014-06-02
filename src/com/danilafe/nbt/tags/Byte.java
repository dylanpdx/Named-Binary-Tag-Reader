package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * <i>"A single signed byte" </i><br><br>
 * Reads and stores one byte.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Byte extends Tag {

	public byte content;
	
	public Byte(java.lang.String name, FileInputStream r) {
		super(name);
		
		//Read our payload!
		try {
			content = (byte) r.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
