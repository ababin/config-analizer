package ru.babin.confanalize.check;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import ru.babin.confanalize.model.ConfigParam;

public class DoubleCheckTest {

	
	@Test
	public void test(){
		
		DoubleCheck check = new DoubleCheck();
		List <ConfigParam> doubles =  check.getDoubles(prepareConfigParam());  
		Assert.assertNotNull(doubles);
		Assert.assertEquals(doubles.size(), 2);
		Assert.assertEquals(doubles.get(0).name , "param2");
		Assert.assertEquals(doubles.get(1).name , "param4");
	}
	
	private List <ConfigParam> prepareConfigParam(){
		List<ConfigParam> res = new ArrayList <ConfigParam> (); 
		res.add(new ConfigParam("param1","val1"));
		res.add(new ConfigParam("param2","val@"));
		res.add(new ConfigParam("param3","val3"));
		res.add(new ConfigParam("param4","val4"));
		res.add(new ConfigParam("param5","val5"));
		res.add(new ConfigParam("param2","val1"));
		res.add(new ConfigParam("param4","val1"));
		return res;
	}
	
}
