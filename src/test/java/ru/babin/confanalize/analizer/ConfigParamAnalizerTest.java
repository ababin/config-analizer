package ru.babin.confanalize.analizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigParamAnalizerTest {
	
	
	@Test
	public void test_paramOnly(){
		ConfigParamAnalizer cpa = new ConfigParamAnalizer();
		cpa.addString("qwe=rou trt trrrr");
		assertTrue(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("# sdfsdfffff"));
		assertTrue(cpa.isValidObject());
	}
	
	@Test
	public void test_paramAndDesc(){
		ConfigParamAnalizer cpa = new ConfigParamAnalizer();
		cpa.addString("qwe=rou trt trrrr");
		assertTrue(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("# sdfsdfffff"));
		assertTrue(cpa.isValidObject());
	}
			
}
