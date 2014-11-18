package ru.babin.confanalize.input;

import java.util.List;

public class Configuration {
	
	public final String origFile;
	
	public final List <String> analizedFiles;	
	
	public final Flags flags;
	
	public Configuration(String orig, List <String> files, Flags flags){
		origFile = orig;
		analizedFiles = files;
		this.flags = flags;
	}
	
}
