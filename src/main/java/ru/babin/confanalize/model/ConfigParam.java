package ru.babin.confanalize.model;

public class ConfigParam {
	
	public String sectionIndex;
	public String sectionName;
	public String name;
	public String desc;
	public String val;
	
	public ConfigParam(String name, String val, String desc){
		this.name = name;
		this.desc = desc;
		this.val = val;
	}
	
	public ConfigParam(String name, String val){
		this.name = name;
		this.val = val;
	}
	
	public boolean equals(Object object){
		if (this == object) {
            return true;
        }
        if (!(object instanceof ConfigParam)) {
            return false;
        }
        final ConfigParam that = (ConfigParam) object;
        if (this.name == null || that.name == null || !this.name.equals(that.name)) {
            return false;
        }
        return true;
	}
	
	public int hashCode() {
        int hashCode = super.hashCode();
        hashCode = 29 * hashCode + (name == null ? 0 : name.hashCode());
        return hashCode;
    }
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("ConfigParam:{");
        sb.append("name: " + name + ";");
        sb.append("val: " + val + ";");
        sb.append("sectionName: " + sectionName + ";");
        sb.append("desc: " + desc + ";");
        sb.append("}");
        return sb.toString();
	}
	
}
