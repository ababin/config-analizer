package ru.babin.confanalize.compare;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import ru.babin.confanalize.model.ConfigParam;

public class ConfigComparatorTest {
	
	ConfigComparator comparator = new ConfigComparator();
	
	@Test
	public void test(){
		
		List <ConfigParam> orig = prepareConfigParam("p1","v1","p2","v2","p3","v3","p4","v4"           );
		List <ConfigParam> src  = prepareConfigParam("p1","v2",          "p3","v5","p4","v4", "p5","v5");
		
		List <CompareItem> items = comparator.compare(orig, src);
		Assert.assertEquals(items.size(), 4);
		Assert.assertEquals(items.get(0).type, ItemType.DIFFERENCE);
		Assert.assertEquals(items.get(1).type, ItemType.ABSENCE);
		Assert.assertEquals(items.get(2).type, ItemType.DIFFERENCE);
		Assert.assertEquals(items.get(3).type, ItemType.UNKNOWN);
	}
	
	private List <ConfigParam> prepareConfigParam(String ... params){
		int paramsCount = params.length / 2;
		List<ConfigParam> res = new ArrayList <ConfigParam> (); 
		int index = 0;
		for(int i = 0; i < paramsCount; i++){
			res.add(new ConfigParam(params[index],params[index+1]));
			index+=2;
		}
		return res;
	}
	
	
}
