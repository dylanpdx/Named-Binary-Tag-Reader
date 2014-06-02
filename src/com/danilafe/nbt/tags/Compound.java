package com.danilafe.nbt.tags;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Compound extends Tag {

	public ArrayList<Tag> contents = new ArrayList<Tag>();
	
	public Compound(java.lang.String name, FileInputStream r){
		super(name);
		int read;
		try {
			while((read = r.read()) != 0 && read != -1){
				switch(read){
				case 1:
					contents.add(new Byte(readName(r), r));
					break;
				case 2:
					contents.add(new Short(readName(r), r));
					break;
				case 3:
					contents.add(new Int(readName(r), r));
					break;
				case 4:
					contents.add(new Long(readName(r), r));
					break;
				case 5:
					contents.add(new Float(readName(r), r));
					break;
				case 6:
					contents.add(new Double(readName(r), r));
					break;
				case 7:
					contents.add(new Byte_Array(readName(r), r));
					break;
				case 8:
					contents.add(new String(readName(r), r));
					break;
				case 9:
					contents.add(new List(readName(r), r));
					break;
				case 10:
					contents.add(new Compound(readName(r), r));
					break;
				case 11:
					System.out.println("11");
					break;
				}
			}
			System.out.println("Length of " + name + " " + contents.size());
			for(Tag t: contents){
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
		return contents.get(contents.size() - 1);
	}
	
}
