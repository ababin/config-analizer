package ru.babin.confanalize.model;

import java.util.List;

public class ConfigurationFile {
	
	public final String fileName;
	
	public final List <ConfigParam> params;
	
	public ConfigurationFile(String fileName, List <ConfigParam> params){
		this.fileName = fileName;
		this.params = params;
	}
	
}
