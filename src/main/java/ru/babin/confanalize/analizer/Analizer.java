package ru.babin.confanalize.analizer;

import ru.babin.confanalize.model.ConfigParam;
import ru.babin.confanalize.model.ConfigSection;


public class Analizer {
	
	private ConfigSection section;
	private ConfigParam param;
	private ConfigParamAnalizer paramAnalizer = new ConfigParamAnalizer();
	private ConfigSectionAnalizer sectionAnalizer = new ConfigSectionAnalizer();
	
		
	public ConfigParam processAndGetParam(String str){
		if(sectionAnalizer.isValidObject() && !sectionAnalizer.isValidObjectForAddedValue(str)){
			// section is ready!!
			section = sectionAnalizer.prepareObject();
			sectionAnalizer = new ConfigSectionAnalizer();
			paramAnalizer = new ConfigParamAnalizer();
		}
		
		if(paramAnalizer.isValidObject() && !paramAnalizer.isValidObjectForAddedValue(str)){
			param = paramAnalizer.prepareObject();
			paramAnalizer = new ConfigParamAnalizer();
		}
		
		sectionAnalizer.addString(str);
		paramAnalizer.addString(str);
		
		return prepareParam();		
	}
	
	public ConfigParam getLastParam(){
		if(paramAnalizer.isValidObject()){
			param = paramAnalizer.prepareObject();
		}
		return prepareParam();
	}
	
	private ConfigParam prepareParam(){
		if(param != null){
			if(section != null){
				param.sectionIndex = section.index;
				param.sectionName = section.name;
			}
		}
		ConfigParam prepared = param;
		param = null;
		
		return prepared;
	}
	
	
	
}
