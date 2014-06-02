package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <i>"A single, big endian 64 bit integer" </i><br><br>
 * Reads and stores one long.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Long extends Tag{

	public long content = 0;
	
	public Long(java.lang.String name, FileInputStream r){
		super(name);
		try {
			int f = r.read();
			int s = r.read();
			int t = r.read();
			int fr = r.read();
			int ff = r.read();
			int sx = r.read();
			int sev = r.read();
			int e = r.read();
			content = (f << 56 | s << 48 | t << 40| fr << 32 | ff << 24 | sx << 16 | sev << 8 | e << 0 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getValue(){
		return content;
	}
	
}
