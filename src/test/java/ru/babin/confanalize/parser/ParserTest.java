package ru.babin.confanalize.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ru.babin.confanalize.model.ConfigParam;

public class ParserTest {

	
	@Test
	public void test() throws IOException{
		Parser p = new Parser();
		List <ConfigParam> params = p.parse("src/test/resources/iptvmw-config.properties");
		assertTrue(!params.isEmpty());
		assertEquals(params.size() , 86);
		for(ConfigParam param : params){
			System.out.println();
			System.out.println(param.sectionIndex + " (" + param.sectionName + ")");
			System.out.println(param.name + " {{" + param.desc + "}}");
		}
		
	}
	
	@Test
	public void test_oneDescFor2props() throws IOException{
		Parser p = new Parser();
		List <ConfigParam> params = p.parse("src/test/resources/iptvmw-config_one_desc_for_2_props.properties");
		assertTrue(!params.isEmpty());
		assertEquals(params.size() , 3);
		assertEquals(params.get(1).desc , params.get(2).desc);
		
		for(ConfigParam param : params){
			System.out.println();
			System.out.println(param.sectionIndex + " (" + param.sectionName + ")");
			System.out.println(param.name + " {{" + param.desc + "}}");
		}
		
		
	}
	
}
