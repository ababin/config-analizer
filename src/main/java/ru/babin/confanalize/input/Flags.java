package ru.babin.confanalize.input;

public class Flags {
	
	public final boolean showAbsence;
	public final boolean showDifference;
	public final boolean showUnknown;
	
	public Flags(String flags){
		showAbsence = flags == null || flags.toUpperCase().contains("A") ? true : false;
		showDifference = flags == null || flags.toUpperCase().contains("D") ? true : false;
		showUnknown = flags == null || flags.toUpperCase().contains("U") ? true : false;
	}
}
