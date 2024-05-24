package org.house.predict.service;

import org.house.predict.repository.AreaSquerFeetRepository;

public class AreaSquerFeetService {
	AreaSquerFeetRepository asfrepo=new AreaSquerFeetRepository();
	public boolean setSquerFeet(float sf, int sfid) {
		// TODO Auto-generated method stub
		return asfrepo.setSquerFeet(sf,sfid);
	}
	
	public int getSquerFeetId()
	{
		int id=asfrepo.getSquerFeetId();
		id++;
		return id;
	}

	public int getSquerFeetidBySq(float sq) {
		// TODO Auto-generated method stub
		return asfrepo.getSquerFeetIdBySq(sq);
	}
}
