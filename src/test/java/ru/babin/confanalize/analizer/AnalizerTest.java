package ru.babin.confanalize.analizer;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static junit.framework.Assert.*;
import ru.babin.confanalize.model.ConfigParam;

public class AnalizerTest {
	
	@Test
	public void test_paramWith2LinesDec(){
		String [] strs = new String[] {
				"# string description 1",
				"# string description 2",
				"q.w.e=rty"
		};
		
		Analizer analizer = new Analizer();
		List <ConfigParam> params = new ArrayList <ConfigParam>();
		ConfigParam param;
		for(int i = 0;i < strs.length;  i++){
			param = analizer.processAndGetParam(strs[i]);
			if(param != null){
				params.add(param);
			}
		}
		param = analizer.getLastParam();
		if(param != null){
			params.add(param);
		}
		
		assertEquals(params.size(), 1);
		
		param = params.get(0);
		assertEquals(param.name , "q.w.e");
		assertEquals(param.val , "rty");
		assertEquals(param.desc , "string description 1 string description 2");
		
	}
	
}
