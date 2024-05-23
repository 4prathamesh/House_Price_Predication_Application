package org.house.predict.service;

import org.house.predict.repository.AminityMasterRepository;

public class AminityMasterService {
	AminityMasterRepository amr= new AminityMasterRepository();
	public boolean setAminity(String aminityName) {
		// TODO Auto-generated method stub
		return amr.setAminity(aminityName);
	}

}
