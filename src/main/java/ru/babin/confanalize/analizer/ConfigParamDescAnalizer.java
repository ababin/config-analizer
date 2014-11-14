package ru.babin.confanalize.analizer;

import ru.babin.confanalize.model.ConfigParamDesc;


public class ConfigParamDescAnalizer extends BaseObAnalizer <ConfigParamDesc> {
		
	@Override
	public boolean isValidObject(){
		return isValidDesc();
	}
	
	@Override
	public boolean isValidObjectForAddedValue(String str) {
		addString(str);
		boolean res = isValidObject();
		lines.remove(lines.size()-1);
		return res;
	}
	
	@Override
	public ConfigParamDesc prepareObject(){
		if(!isValidObject()){
			throw new RuntimeException("Can't prepare object ! Object is not valid ConfigParamDesc!");
		}
		String desc = prepareParamDesc();
		ConfigParamDesc configParamDesc = new ConfigParamDesc(desc);
		return configParamDesc;
	}
	
	private boolean isValidDesc(){
		for(int i = 0; i < lines.size(); i++){
			if(!lines.get(i).startsWith(COMENT_CHAR)){
				return false;
			}
		}
		return lines.isEmpty() ? false : true;
	}
		
	private String prepareParamDesc(){
		String strOut = "";
		for(int i  = 0; i < lines.size() - 1; i++){
			strOut += lines.get(i).substring(1);
		}
		return strOut.replaceAll("\\s+", " ").trim();
	}
	
}
