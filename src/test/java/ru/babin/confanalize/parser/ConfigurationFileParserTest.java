package ru.babin.confanalize.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ru.babin.confanalize.model.ConfigParam;
import ru.babin.confanalize.model.ConfigurationFile;

public class ConfigurationFileParserTest {

	
	@Test
	public void test() throws IOException{
		ConfigurationFileParser p = new ConfigurationFileParser();
		ConfigurationFile confFile = p.parse("src/test/resources/iptvmw-config.properties");
		assertTrue(!confFile.params.isEmpty());
		assertEquals(confFile.params.size() , 86);
		for(ConfigParam param : confFile.params){
			System.out.println();
			System.out.println(param.sectionIndex + " (" + param.sectionName + ")");
			System.out.println(param.name + " {{" + param.desc + "}}");
		}
		
	}
	
	@Test
	public void test_oneDescFor2props() throws IOException{
		ConfigurationFileParser p = new ConfigurationFileParser();
		ConfigurationFile confFile = p.parse("src/test/resources/iptvmw-config_one_desc_for_2_props.properties");
		assertTrue(!confFile.params.isEmpty());
		assertEquals(confFile.params.size() , 3);
		assertEquals(confFile.params.get(1).desc , confFile.params.get(2).desc);
		
		for(ConfigParam param : confFile.params){
			System.out.println();
			System.out.println(param.sectionIndex + " (" + param.sectionName + ")");
			System.out.println(param.name + " {{" + param.desc + "}}");
		}
		
		
	}
	
}
