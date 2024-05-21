package org.house.predict.model;

public class AreaSquerFeet {
	private int sfid;
	private float sfArea;
	AreaSquerFeet()
	{
		
	}
	AreaSquerFeet(int sfid,float sfArea)
	{
		this.sfid=sfid;
		this.sfArea=sfArea;
	}
	public int getSfid() {
		return sfid;
	}
	public void setSfid(int sfid) {
		this.sfid = sfid;
	}
	public float getSfArea() {
		return sfArea;
	}
	public void setSfArea(float sfArea) {
		this.sfArea = sfArea;
	}
	
}
