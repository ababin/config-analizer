package ru.babin.confanalize.model;

public class ConfigSection {
	public long level;
	public String index;
	public String name;
	
	public ConfigSection(String index, String desc){
		this.index = index;
		this.name = desc;
	}
}
