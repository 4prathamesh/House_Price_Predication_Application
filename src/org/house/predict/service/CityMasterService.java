package org.house.predict.service;
import java.util.*;
import org.house.predict.model.CityMasterModel;
import org.house.predict.repository.CityMasterRepository;

public class CityMasterService {
	
	CityMasterRepository cityRepo = new CityMasterRepository();
	
	public boolean isAddCity(CityMasterModel model)
	{
		boolean b= cityRepo.isAddNewCity(model);
		return b;
	}
	
	
	//case no 2
	public List<CityMasterModel> getAllCites() 
	{
		return cityRepo.getAllCities();
	}
	
	//case no 3
	public boolean isBulkAddCities()
	{
		return cityRepo.isBulkAddCities();
	}
	
	//case no 4
	public int getCityId(String cname)
	{
		return cityRepo.getCityId(cname);
	}
	
//	case no 5
	
	public List<Object[]> getCityWiseCount()
	{
		return cityRepo.getCityWiseCount();
	}
	
	// **** case no 6
	public LinkedHashMap<String, ArrayList<String>> getCityWiseAreaName()
	{
		return cityRepo.getCityWiseAreaName();
	}
}
