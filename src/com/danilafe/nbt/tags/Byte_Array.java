package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <i>"A length-prefixed array of signed bytes. <br> The prefix is a signed integer (thus 4 bytes)" </i><br><br>
 * This class reads the next bytes in the reader as <br>needed, and fills its arraylist of bytes with the read byte Tags.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Byte_Array extends Tag{

	public ArrayList<Byte> bytes = new ArrayList<Byte>();
	
	public Byte_Array(java.lang.String name, FileInputStream r){
		super(name);
		try {
			int i1 = r.read();
			int i2 = r.read();
			int i3 = r.read();
			int i4 = r.read();
			
			int totallength = i1 << 24 | i2 << 16 | i3 << 8 | i4 <<0;
			for(int i = 0; i < totallength; i  ++){
				
				//Define vars
				java.lang.String tname = "";
				int length = 0;
				
				//Get the length of the name
				length = r.read() << 8 | r.read();
				
				//Compile the name
				for(int z = 0; z < length; z ++){
					tname += (char) r.read();
				}
				
				bytes.add(new Byte(tname, r));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
