package ru.babin.confanalize.analizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigParamDescAnalizerTest {
	
	
	@Test
	public void test_paramAppears(){
		ConfigParamDescAnalizer cpa = new ConfigParamDescAnalizer();
		cpa.addString("qwe=rou trt trrrr");
		assertFalse(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("# sdfsdfffff"));
		assertFalse(cpa.isValidObject());
	}
	
	@Test
	public void test_desc(){
		ConfigParamDescAnalizer cpa = new ConfigParamDescAnalizer();
		cpa.addString("# description sdfsdf");
		assertTrue(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("qwe=qwe"));
		assertTrue(cpa.isValidObjectForAddedValue("# eeeeeeeeeeeee"));
		cpa.addString("# description sdfsdf 2222222222");
		assertTrue(cpa.isValidObject());
	}
	
	
}
