package ru.babin.confanalize.input;

import static junit.framework.Assert.*;
import static ru.babin.confanalize.input.InputArgsParser.ORIGINAL_PARAM;
import static ru.babin.confanalize.input.InputArgsParser.PATH_PARAM;

import org.junit.Test;

public class InputArgsParserTest {
	
	InputArgsParser parser = new InputArgsParser();
	
	@Test
	public void test_minimal(){
		String orig = "/opt/file1";
		String path = "/opt/file2";
		String [] args = new String[] { ORIGINAL_PARAM + "=" + orig, PATH_PARAM + "=" + path};
		Configuration conf = parser.parse(args);
		assertEquals(conf.origFile, orig);
		assertEquals(conf.analizedFiles.get(0), path);
	}
	
	@Test
	public void test_originalAndTwoFiles(){
		String orig = "/opt/file1";
		String f1 = "/opt/file1";
		String f2 = "/opt/file2";
		String path = f1 + ";" + f2;
		String [] args = new String[] { ORIGINAL_PARAM + "=" + orig, PATH_PARAM + "=" + path};
		Configuration conf = parser.parse(args);
		assertEquals(conf.origFile, orig);
		assertEquals(conf.analizedFiles.size(), 2);
		assertEquals(conf.analizedFiles.get(0), f1);
		assertEquals(conf.analizedFiles.get(1), f2);
	}
	
	@Test
	public void test_WithErrorPath(){
		String orig = "/opt/file1";
		String f1 = "";
		String f2 = "";
		String path = f1 + ";" + f2;
		String [] args = new String[] { ORIGINAL_PARAM + "=" + orig, PATH_PARAM + "=" + path};
		try{
			parser.parse(args);
		}catch(RuntimeException e){
			return;
		}
		fail();
	}
	
	@Test
	public void test_WithErrorOrig(){
		String f1 = "/opt/file1";
		String f2 = "/opt/file2";
		String path = f1 + ";" + f2;
		String [] args = new String[] { PATH_PARAM + "=" + path};
		try{
			parser.parse(args);
		}catch(RuntimeException e){
			return;
		}
		fail();
	}
	
	
	
	
	
	
}
