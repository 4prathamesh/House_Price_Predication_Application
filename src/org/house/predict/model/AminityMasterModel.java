package org.house.predict.model;

public class AminityMasterModel {
	private int amid;
	private String amName;
	public AminityMasterModel()
	{
		
	}
	public AminityMasterModel(int amid,String amName)
	{
		this.amid=amid;
		this.amName=amName;
	}
	public int getAmid() {
		return amid;
	}
	public void setAmid(int amid) {
		this.amid = amid;
	}
	public String getAmName() {
		return amName;
	}
	public void setAmName(String amName) {
		this.amName = amName;
	}

}
