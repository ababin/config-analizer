package ru.babin.confanalize.input;

import java.util.ArrayList;
import java.util.List;

public class InputArgsParser {
	
	public static final String ORIGINAL_PARAM = "-orig";
	public static final String DEFAULT_ORIGINAL_FILE = "original.properties";
	public static final String PATH_PARAM="-path";
	 
	
	public boolean validate(String [] args){
		return false;
	}
	
	public Configuration parse(String [] args){
		String orig = getParameter(ORIGINAL_PARAM, args);
		if(orig == null){
			orig = DEFAULT_ORIGINAL_FILE;
		}
		validateOriginalParam(orig);
		
		String path = getParameter(PATH_PARAM, args);
		validatePathParam(path);
		
		Flags  flags = new Flags(getFlagsString(args));
		
		return new Configuration(orig, parsePath(path), flags);
	}
	
	private List<String> parsePath(String val){
		String [] ar = val.split(";");
		List <String> res = new ArrayList <String>();
		for(int i=0; i< ar.length; i++){
			if(ar[i] != null || !ar[i].trim().isEmpty()){
				res.add(ar[i].trim());
			}
		}
		if(res.isEmpty()){
			throw new RuntimeException("Parameter '" + PATH_PARAM +"' is not valid! Example: " + PATH_PARAM + "=file1;file2");
		}
		return res;
	}
	
	private String getParameter(String paramName, String [] args){
		for(int i=0; i < args.length; i++){
			if(args[i].startsWith(paramName+"=")){
				return args[i].substring(paramName.length() + 1).trim();
			}
		}
		return null;
	}
	
	private String getFlagsString(String [] args){
		for(int i=0; i < args.length; i++){
			if(args[i].startsWith("-F")){
				return args[i].substring(2).trim();
			}
		}
		return null;
	}
	
	private void validateOriginalParam(String value){
		validateParam(ORIGINAL_PARAM, value);
	}
	
	private void validatePathParam(String value){
		validateParam(PATH_PARAM, value);
	}
	
	private void validateParam(String paramName, String paramValue){
		if(paramValue == null || paramValue.isEmpty()){
			throw new RuntimeException("Parameter '" + paramName + "' is not defined or NULL !");
		}
	}
	
	
	
}
