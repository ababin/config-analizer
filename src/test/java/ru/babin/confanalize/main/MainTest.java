package ru.babin.confanalize.main;

import static ru.babin.confanalize.input.InputArgsParser.ORIGINAL_PARAM;
import static ru.babin.confanalize.input.InputArgsParser.PATH_PARAM;

import org.junit.Test;

public class MainTest {
	
	Main main = new Main();
	
	@Test
	public void test(){
		
		String [] args = new String[] { ORIGINAL_PARAM + "=src/test/resources/full_test/iptvmw-config.properties" , 
				PATH_PARAM + "=src/test/resources/full_test/iptvmw-config-analized.properties"};
		
		main.main(args);
				
	}
	
	
	
}
