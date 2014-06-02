package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <i>"A single, big endian IEEE-754 single-precision floating point number" </i><br><br>
 * Reads and stores one float.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Float extends Tag{

	public float content = 0;
	
	public Float(java.lang.String name, FileInputStream r){
		super(name);
		try{
			int i1 = r.read();
			int i2 = r.read();
			int i3 = r.read();
			int i4 = r.read();
			
			int total = i1 << 24 | i2 << 16 | i3 << 8| i4 << 0;
			
			content = java.lang.Float.intBitsToFloat(total);
			
		} catch(IOException e){
			
		}

	}
	
}
