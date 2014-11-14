package ru.babin.confanalize.compare;

import java.util.ArrayList;
import java.util.List;

import ru.babin.confanalize.model.ConfigParam;

public class ConfigComparator {
	
	public List <CompareItem> compare(List <ConfigParam> original, List <ConfigParam> source){
		List <CompareItem> items = new ArrayList<CompareItem> ();
		
		for(int i=0; i < original.size(); i++){
			ConfigParam orig = original.get(i);
			if(source.contains(orig)){
				ConfigParam src = source.get(source.indexOf(orig));
				if(!orig.val.equals(src.val)){
					items.add(new CompareItem(orig, src, ItemType.DIFFERENCE));
				}
			}else{
				items.add(new CompareItem(orig, null, ItemType.ABSENCE));
			}
		}
		
		for(int i=0; i < source.size(); i++){
			ConfigParam src = source.get(i);
			if(!original.contains(src)){
				items.add(new CompareItem(null, src, ItemType.UNKNOWN));
			}
		}
				
		return items.isEmpty() ? null : items;
	}
	
}
