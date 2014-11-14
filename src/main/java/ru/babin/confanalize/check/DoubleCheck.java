package ru.babin.confanalize.check;

import java.util.ArrayList;
import java.util.List;

import ru.babin.confanalize.model.ConfigParam;

public class DoubleCheck {
	
	public List <ConfigParam> getDoubles(List <ConfigParam> params){
		List <ConfigParam> doubles = new ArrayList <ConfigParam>();
		
		for(int i = 0; i < params.size(); i++){
			ConfigParam param1 = params.get(i);
			for(int j = i+1; j < params.size(); j++){
				if(param1.name.equals(params.get(j).name)){
					doubles.add(param1);
				}
			}
		}
		
		return doubles.isEmpty() ? null : doubles;
	} 
	
}
