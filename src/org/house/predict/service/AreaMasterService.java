package org.house.predict.service;


import org.house.predict.model.AreaMasterModel;
import org.house.predict.repository.AreaMasterRepository;

public class AreaMasterService {
	AreaMasterRepository amr= new AreaMasterRepository();
//	public int addAreaofCity(String cityArea)
//	{
//		return amr.addAreaofCity(cityArea);
//	}
	public int getAreaId()
	{
		return amr.getAreaId();
	}
	
	public boolean isAddArea(AreaMasterModel amodel) {
		// TODO Auto-generated method stub
		return amr.isAddArea(amodel);
	}

}
