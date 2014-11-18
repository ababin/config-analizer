package ru.babin.confanalize.main;

import java.util.List;

import ru.babin.confanalize.input.Configuration;
import ru.babin.confanalize.input.InputArgsParser;
import ru.babin.confanalize.model.ConfigurationFile;
import ru.babin.confanalize.model.ConfigurationHolder;
import ru.babin.confanalize.parser.ConfigurationFileParser;
import ru.babin.confanalize.report.ReportCreator;

public class Main {

	static InputArgsParser argsParser = new InputArgsParser();
	static ConfigurationFileParser configFileParser = new ConfigurationFileParser();
	static ReportCreator reportCreator = new ReportCreator();
	
	public static void main(String[] args) {
		Configuration configuration = argsParser.parse(args);
		
		ConfigurationFile originalFile = configFileParser.parse(configuration.origFile);
		List <ConfigurationFile> analizedFiles = configFileParser.parse(configuration.analizedFiles);
		
		ConfigurationHolder originalHolder = new ConfigurationHolder(originalFile);
		ConfigurationHolder analizedHolder = new ConfigurationHolder(analizedFiles);
		
		reportCreator.prepareAndShowDifference(originalHolder, analizedHolder , configuration.flags);
	}

}
