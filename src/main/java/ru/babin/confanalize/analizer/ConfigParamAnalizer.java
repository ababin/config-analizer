package ru.babin.confanalize.analizer;

import ru.babin.confanalize.model.ConfigParam;


public class ConfigParamAnalizer extends BaseObAnalizer <ConfigParam> {
				
	public void addString(String str){
		lines.add(str);
	}
	
	@Override
	public boolean isValidObject(){
		return isValidParam() && isValidDesc();
	}
	
	@Override
	public boolean isValidObjectForAddedValue(String str) {
		addString(str);
		boolean res = isValidObject();
		lines.remove(lines.size()-1);
		return res;
	}
	
	@Override
	public ConfigParam prepareObject(){
		if(!isValidObject()){
			throw new RuntimeException("Can't prepare object ! Object is not valid ConfigParam!");
		}
		String paramString = lines.get(lines.size()-1);
		String name = prepareParamName(paramString);
		String desc = prepareParamDesc();
		String val = prepareParamVal(paramString);
		ConfigParam section = new ConfigParam(name, desc , val);
		return section;
	}
	
	private boolean isValidDesc(){
		for(int i = 0; i < lines.size()-1; i++){
			if(!lines.get(i).startsWith(COMENT_CHAR)){
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidParam(){
		return !lines.isEmpty()
				&& !lines.get(lines.size()-1).startsWith(COMENT_CHAR);
	}
	
	
	
	private String prepareParamDesc(){
		String strOut = "";
		for(int i  = 0; i < lines.size() - 1; i++){
			strOut += lines.get(i).substring(1);
		}
		return strOut.replaceAll("\\s+", " ").trim();
	}
	
	private String prepareParamName(String str){
		int index = str.indexOf("=");
		return index < 0 ? null : str.substring(0, index).trim();
	}
	
	private String prepareParamVal(String str){
		int index = str.indexOf("=");
		return index < 0 ? null : str.substring(index+1);
	}
	
}
