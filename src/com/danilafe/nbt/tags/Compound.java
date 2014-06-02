package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * <i>"Effectively a list of a named tags. Order is not guaranteed." </i><br><br>
 * Reads and stores all the other tags inside it.
 * @author DanilaFedorin
 * @param name The name of the tag
 * @param r The reader to use
 */
public class Compound extends ListTag {

	
	public Compound(java.lang.String name, FileInputStream r){
		super(name);
		int read;
		try {
			while((read = r.read()) != 0 && read != -1){
				switch(read){
				case 1:
					content.add(new Byte(readName(r), r));
					break;
				case 2:
					content.add(new Short(readName(r), r));
					break;
				case 3:
					content.add(new Int(readName(r), r));
					break;
				case 4:
					content.add(new Long(readName(r), r));
					break;
				case 5:
					content.add(new Float(readName(r), r));
					break;
				case 6:
					content.add(new Double(readName(r), r));
					break;
				case 7:
					content.add(new Byte_Array(readName(r), r));
					break;
				case 8:
					content.add(new String(readName(r), r));
					break;
				case 9:
					content.add(new List(readName(r), r));
					break;
				case 10:
					content.add(new Compound(readName(r), r));
					break;
				case 11:
					System.out.println("11");
					break;
				}
			}
			System.out.println("Length of " + name + " " + content.size());
			for(Tag t: content){
				System.out.println("Content of " + name + " " + t.name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Uses the reader to get the name of the tag to follow.
	 * @param r the reader to use
	 * @return the name of the tag.
	 */
	private java.lang.String readName(FileInputStream r){
		try {
			
			java.lang.String returns = "";
			int length = r.read() << 8 | r.read();
			
			for(int i = 0; i < length; i ++){
				returns += (char)r.read();
			}
			
			return returns;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Tag getLatestTag(){
		return content.get(content.size() - 1);
	}
	

	
}
