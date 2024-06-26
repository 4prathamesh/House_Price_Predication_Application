package org.house.predict.model;

import java.util.List;

public class PropertyMasterModel {
	private int id ;
	private String address;
	private int  sqid    ;
	private int areaid;
	private int cityid;
	private int nbed;
	private int nbath;
	private DealModel dm;
	public DealModel getDm() {
		return dm;
	}
	public void setDm(DealModel dm) {
		this.dm = dm;
	}
	private List<AminityMasterModel> amList;
	
	public List<AminityMasterModel> getAmList() {
		return amList;
	}
	public void setAmList(List<AminityMasterModel> amList) {
		this.amList = amList;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSqid() {
		return sqid;
	}
	public void setSqid(int sqid) {
		this.sqid = sqid;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getNbed() {
		return nbed;
	}
	public void setNbed(int nbed) {
		this.nbed = nbed;
	}
	public int getNdath() {
		return nbath;
	}
	public void setNdath(int nbath) {
		this.nbath = nbath;
	}
	
	public PropertyMasterModel()
	{
		
	}
	public PropertyMasterModel(String address,int sqid,int areaid,int cityid,int nbed,int nbath,List<AminityMasterModel> amList)
	{
		this.address = address;
		this.sqid=sqid;
		this.areaid=areaid;
		this.cityid=cityid;
		this.nbed=nbed;
		this.nbath=nbath;
		this.amList=amList;
	}
}
