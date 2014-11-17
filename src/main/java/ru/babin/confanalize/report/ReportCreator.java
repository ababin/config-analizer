package ru.babin.confanalize.report;

import java.util.ArrayList;
import java.util.List;

import ru.babin.confanalize.compare.CompareItem;
import ru.babin.confanalize.compare.ConfigComparator;
import ru.babin.confanalize.compare.ItemType;
import ru.babin.confanalize.model.ConfigurationHolder;

public class ReportCreator {
	
	ConfigComparator comparator = new ConfigComparator();
	
	public void prepareAndShowDifference(ConfigurationHolder original, ConfigurationHolder analized){
		List <CompareItem> items = comparator.compare(original.params, analized.params);
		
		if(items.isEmpty()){
			print("Comparing ... OK!");
			return;
		}
		
		// ItemType.ABSENCE;
		List <CompareItem> absence = filterByType(items, ItemType.ABSENCE);
		showReportByAbsence(absence);
		
		List <CompareItem> difference = filterByType(items, ItemType.DIFFERENCE);
		showReportByDifference(difference);
		
		List <CompareItem> unknown = filterByType(items, ItemType.UNKNOWN);
		showReportByUnknown(unknown);
		
		reportEnd();
	}
	
	
	
	
	private void showReportByAbsence(List<CompareItem> absences) {
		if(!absences.isEmpty()){
			print("ABSENCE PARAMETERS: ");
			print("----------------------------------------------------------------------------------------");
			for(CompareItem item : absences){
				print("# " + item.origParam.sectionIndex + " " + item.origParam.sectionName);
				print("# " + item.origParam.desc);
				print(item.origParam.name + "=" + item.origParam.val);
				print("");
			}
			print("----------------------------------------------------------------------------------------");
			print("");
			print("");
		}		
	}
	
	private void showReportByDifference(List<CompareItem> differences) {
		if(!differences.isEmpty()){
			print("DIFFERENCE PARAMETERS: ");
			print("----------------------------------------------------------------------------------------");
			for(CompareItem item : differences){
				print("# " + item.origParam.sectionIndex + " " + item.origParam.sectionName);
				print("# " + item.origParam.desc);
				print(item.origParam.name + "=" + item.origParam.val + " [ORIGINAL]");
				print(item.origParam.name + "=" + item.srcParam.val + " [ANALIZED]");
				print("");
			}
			print("----------------------------------------------------------------------------------------");
			print("");
			print("");
		}		
	}
	
	private void showReportByUnknown(List<CompareItem> unknowns) {
		if(!unknowns.isEmpty()){
			print("UNKNOWN PARAMETERS: ");
			print("----------------------------------------------------------------------------------------");
			for(CompareItem item : unknowns){
				print("# " + item.srcParam.sectionIndex + " " + item.srcParam.sectionName);
				print("# " + item.srcParam.desc);
				print(item.srcParam.name + "=" + item.srcParam.val);
				print("");
			}
			print("----------------------------------------------------------------------------------------");
			print("");
			print("");
		}		
	}
	
	private void reportEnd(){
		print("REPORT END");
	}




	private List <CompareItem> filterByType(List<CompareItem> itemsIn , ItemType type){
		List <CompareItem> res = new ArrayList <CompareItem> ();
		for(CompareItem item : itemsIn){
			if(item.type == type){
				res.add(item);
			}
		}
		return res;
	}
	
	private void print(String str){
		System.out.println(str);
	}
	
	
}
