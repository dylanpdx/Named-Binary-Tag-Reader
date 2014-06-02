package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <b><i>NOT FINISHED</i></b><br><br>
 * 
 * <i>"A list of nameless tags, all of the same type.<br> The list is prefixed with the Type ID of the items it contains (thus 1 byte)<br>, and the length of the list as a signed integer (a further 4 bytes)." </i><br><br>
 * Reads and stores the list of tags into its array list.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class List extends ListTag{
	
	public byte type;
	
	public List(java.lang.String name, FileInputStream r){
		super(name);
		try {
			type = (byte) r.read();
			int length = r.read() << 24 | r.read() << 16 | r.read() << 8 | r.read();
			System.out.println("My length is " + length);
			for(int i = 0; i < length;i  ++){
				System.out.println("Read something");
				switch(type){
				case 1:
					content.add(new Byte("", r));
					break;
				case 2:
					content.add(new Short("", r));
					break;
				case 3:
					content.add(new Int("", r));
					break;
				case 4:
					content.add(new Long("", r));
					break;
				case 5:
					content.add(new Float("", r));
					break;
				case 6:
					content.add(new Double("", r));
					break;
				case 7:
					content.add(new Byte_Array("", r));
					break;
				case 8:
					content.add(new String("", r));
					break;
				case 9:
					content.add(new List("", r));
					break;
				case 10:
					content.add(new Compound("", r));
					break;
				case 11:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	

}
