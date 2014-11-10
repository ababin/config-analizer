package ru.babin.confanalize.model;

public class Context {
	
	private static final int CONTEXT_SIZE = 3;
	
	private String [] lines = new String[CONTEXT_SIZE];
			
	public void addString(String str){
		for(int  i = 0; i < CONTEXT_SIZE; i++){
			if(lines[i] == null){
				lines[i] = str;
				break;
			}
		}
		throw new RuntimeException("Context is full !");
	}
		
	public boolean isReady(){
		boolean res = true;
		for(int i = 0; i < CONTEXT_SIZE; i++){
			res = res && lines[i] != null;
		}
		return res;
	}
	
}
