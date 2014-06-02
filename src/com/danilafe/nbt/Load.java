package com.danilafe.nbt;

import java.io.File;
import java.util.Scanner;

public class Load {
	
	public Load(){
		
		//Create the scanner to get input
		Scanner s = new Scanner(System.in);
		
		//Prompt and get the filename.
		System.out.println("Enter name of NBT file. Please unzip it first. Include the extension");
		String filename = s.nextLine();
		
		new NBTRead(new File(filename));
		
	}
	
	public static void main(String[] args) {
		new Load();
	}

}
