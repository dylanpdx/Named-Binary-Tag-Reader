package com.danilafe.nbt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.danilafe.nbt.GUI.DisplayNodes;
import com.danilafe.nbt.tags.Compound;

/**
 * This class opens an unzipped NBT (Named Binary Tag) and parses it. As all NBT file start <br> with a compound tag, this class only has one method - to get the compound tag parsed.
 * @author DanilaFedorin
 * @param nbt the file that needs to be parsed.
 */
public class NBTRead {
	
	/*
	 * 0	 TAG_End	 0	 This tag serves no purpose but to signify the end of an open TAG_Compound. In most libraries, this type is abstracted away and never seen. TAG_End is not named.
	 * 1	 TAG_Byte	 1	 A single signed byte
	 * 2	 TAG_Short	 2	 A single signed, big endian 16 bit integer
	 * 3	 TAG_Int	 4	 A single signed, big endian 32 bit integer
	 * 4	 TAG_Long	 8	 A single signed, big endian 64 bit integer
	 * 5	 TAG_Float	 4	 A single, big endian IEEE-754 single-precision floating point number
	 * 6	 TAG_Double	 8	 A single, big endian IEEE-754 double-precision floating point number
	 * 7	 TAG_Byte_Array	 ...	 A length-prefixed array of signed bytes. The prefix is a signed integer (thus 4 bytes)
	 * 8	 TAG_String	 ...	 A length-prefixed UTF-8 string. The prefix is an unsigned short (thus 2 bytes)
	 * 9	 TAG_List	 ...	 A list of nameless tags, all of the same type. The list is prefixed with the Type ID of the items it contains (thus 1 byte), and the length of the list as a signed integer (a further 4 bytes).
	 * 10	 TAG_Compound	 ...	 Effectively a list of a named tags. Order is not guaranteed.
	 * 11	 TAG_Int_Array	 ...	 A length-prefixed array of signed integers. The prefix is a signed integer (thus 4 bytes) and indicates the number of 4 byte integers.
	 */
	
	/**
	 * This class opens an unzipped NBT (Named Binary Tag) and parses it. As all NBT file start <br> with a compound tag, this class only has one method - to get the compound tag parsed.
	 * @author DanilaFedorin
	 * @param nbt the file that needs to be parsed.
	 */
	public NBTRead(File nbt){
		try {
			FileInputStream r = new FileInputStream(nbt);
			int read;
			int tagsread = 0;
			while((read = r.read()) != -1){
				if(read == 10){
					
					//Define vars
					String name = "";
					int length = 0;
					
					//Get the length of the name
					length = r.read() << 8 | r.read();
					
					//Compile the name
					for(int i = 0; i < length; i ++){
						name += (char) (read = r.read());
					}
					
					new DisplayNodes(new Compound(name, r));
					
					
				}
			}
			
			r.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
