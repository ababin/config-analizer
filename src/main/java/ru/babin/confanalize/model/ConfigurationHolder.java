package ru.babin.confanalize.model;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationHolder {
	
	public final List <ConfigurationFile> files;
	
	public List <ConfigParam> params;
	
	public ConfigurationHolder(ConfigurationFile file){
		this.files = new ArrayList <ConfigurationFile>();
		files.add(file);
		merge();
	}
	
	public ConfigurationHolder(List <ConfigurationFile> files){
		this.files = files;
		merge();
	}
	
	private void merge(){
		params = new ArrayList <ConfigParam>();
		for(ConfigurationFile file : files){
			for(ConfigParam param : file.params){
				int index = params.indexOf(param);
				if(index >=0){
					params.remove(index);
					params.add(index, param);
				}else{
					params.add(param);
				}
			}
		}
	}
}
