package ru.babin.confanalize.analizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.babin.confanalize.analizer.ConfigParamAnalizer;
import ru.babin.confanalize.model.ConfigParam;

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
		cpa.addString("# description sdfsdf");
		cpa.addString("qwe=rou trt trrrr");
		assertTrue(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("# sdfsdfffff"));
		assertTrue(cpa.isValidObject());
	}
	
	@Test
	public void test_paramAndDesc2(){
		ConfigParamAnalizer cpa = new ConfigParamAnalizer();
		cpa.addString("# description 1");
		cpa.addString("# description 2");
		cpa.addString("# description 3");
		cpa.addString("qwe=rou trt trrrr");
		assertTrue(cpa.isValidObject());
		assertFalse(cpa.isValidObjectForAddedValue("# sdfsdfffff"));
		assertTrue(cpa.isValidObject());
		
		// check object
		ConfigParam p = cpa.prepareObject();
		assertEquals(p.name, "qwe");
		assertEquals(p.desc, "description 1 description 2 description 3");
		assertEquals(p.val, "rou trt trrrr");
		
	}
	
}
