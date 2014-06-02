package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * <i>"A single, big endian IEEE-754 double-precision floating point number" </i><br><br>
 * Reads and stores one double.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Double extends ValueTag{

	
	public Double(java.lang.String name, FileInputStream r) {
		super(name);
		try{
			int i1 = r.read();
			int i2 = r.read();
			int i3 = r.read();
			int i4 = r.read();
			int i5 = r.read();
			int i6 = r.read();
			int i7 = r.read();
			int i8 = r.read();	
			
			content  = (double)(java.lang.Float.intBitsToFloat((i1 << 56 | i2 << 48 | i3 << 40| i4 << 32 | i5 << 24 | i6 << 16 | i7 << 8 | i8 << 0 )));
		} catch(IOException e){
			
		}

	}
	


}
