package ru.babin.confanalize.model;

public class ConfigParam {
	
	public String sectionIndex;
	public String sectionName;
	public String name;
	public String desc;
	public String val;
	
	public ConfigParam(String name, String desc, String val){
		this.name = name;
		this.desc = desc;
		this.val = val;
	}
	
}
