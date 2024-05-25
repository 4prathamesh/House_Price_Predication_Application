package org.house.predict.service;

import org.house.predict.model.PropertyMasterModel;
import org.house.predict.repository.PropertyMasterRepository;

public class PropertyMasterService {
	
	PropertyMasterRepository pmrepo= new PropertyMasterRepository();
	public boolean addProperty(PropertyMasterModel pmm) {
		// TODO Auto-generated method stub
		return pmrepo.setProperty(pmm);
	}

}
