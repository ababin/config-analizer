package ru.babin.confanalize.analizer;

import java.util.ArrayList;

public abstract class BaseObAnalizer <T> {
	
	protected static final String COMENT_CHAR = "#";
	
	protected ArrayList <String> lines = new ArrayList <String>();
	
	public abstract boolean isValidObject();
	
	public abstract boolean isValidObjectForAddedValue(String str);
	
	public abstract T prepareObject();
}
