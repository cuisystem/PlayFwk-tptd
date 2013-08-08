package models;

public class adress_component {
	public String getLong_name() {
		return long_name;
	}
	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	@Override
	public String toString() {
		return "adress_component [long_name=" + long_name + ", short_name="
				+ short_name + "]";
	}
	private String long_name;
	private String short_name;
	
}
