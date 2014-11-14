package ru.babin.confanalize.analizer;

import ru.babin.confanalize.model.ConfigParam;
import ru.babin.confanalize.model.ConfigParamDesc;
import ru.babin.confanalize.model.ConfigSection;


public class Analizer {
	
	private ConfigSection curSection;
	private ConfigParam curParam;
	private ConfigParamDesc curDesc;
	private ConfigParamAnalizer paramAnalizer = new ConfigParamAnalizer();
	private ConfigParamDescAnalizer descAnalizer = new ConfigParamDescAnalizer();
	private ConfigSectionAnalizer sectionAnalizer = new ConfigSectionAnalizer();
	
		
	public ConfigParam processAndGetParam(String str){
		if(sectionAnalizer.isValidObject() && !sectionAnalizer.isValidObjectForAddedValue(str)){
			sectionIsReadyEvent();			
		} else if(descAnalizer.isValidObject() && !descAnalizer.isValidObjectForAddedValue(str)){
			descIsReadyEvent();
		} else if(paramAnalizer.isValidObject() && !paramAnalizer.isValidObjectForAddedValue(str)){
			paramIsReadyEvent();
		}
		
		addStringForAnalizers(str);
		
		return prepareParam();		
	}
	
	public ConfigParam getLastParam(){
		if(paramAnalizer.isValidObject()){
			curParam = paramAnalizer.prepareObject();
		}
		return prepareParam();
	}
	
	private void sectionIsReadyEvent(){
		curSection = sectionAnalizer.prepareObject();
		newSectionAnalizer();
		newParamAnalizer();
		newDescAnalizer();
	}
	
	private void descIsReadyEvent(){
		curDesc = descAnalizer.prepareObject();
		curParam = null;
		newDescAnalizer();
		newParamAnalizer();
	}
	
	private void paramIsReadyEvent(){
		curParam = paramAnalizer.prepareObject();
		newParamAnalizer();
		newDescAnalizer();
	}
			
	private ConfigParam prepareParam(){
		if(curParam != null){
			if(curSection != null){
				curParam.sectionIndex = curSection.index;
				curParam.sectionName = curSection.name;
			}
			if(curDesc != null){
				curParam.desc = curDesc.desc;
			}
		}
		ConfigParam prepared = curParam;
		curParam = null;
		
		return prepared;
	}
	
	private void newSectionAnalizer(){
		sectionAnalizer = new ConfigSectionAnalizer();
	}
	
	private void newParamAnalizer(){
		paramAnalizer = new ConfigParamAnalizer();
	}
	
	private void newDescAnalizer(){
		descAnalizer = new ConfigParamDescAnalizer();
	}
	
	private void addStringForAnalizers(String str){
		sectionAnalizer.addString(str);
		descAnalizer.addString(str);
		paramAnalizer.addString(str);
	}
}
