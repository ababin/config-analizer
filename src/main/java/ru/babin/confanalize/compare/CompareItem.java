package ru.babin.confanalize.compare;

import ru.babin.confanalize.model.ConfigParam;

public class CompareItem {
	
	public ConfigParam origParam;
	public ConfigParam srcParam;
	public ItemType type; 
	
	public CompareItem(ConfigParam origParam, ConfigParam srcParam, ItemType type){
		 this.origParam = origParam;
		 this.srcParam = srcParam;
		 this.type = type;		 
	}
	
		
	
}
