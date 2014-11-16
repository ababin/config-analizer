package ru.babin.confanalize.input;

import java.util.List;

public class Configuration {
	
	public final String origFile;
	
	public final List <String> analizedFiles;	
	
	public Configuration(String orig, List <String> files){
		origFile = orig;
		analizedFiles = files;
	}
	
}
