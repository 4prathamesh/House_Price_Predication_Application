package org.house.predict.repository;

import org.house.predict.config.DBHelper;
import org.house.predict.model.PropertyMasterModel;

public class PropertyMasterRepository extends DBHelper{

	public boolean setProperty(PropertyMasterModel pmm) {
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("insert into propertymaster values ('0',?,?,?,?,?,?)");
			stmt.setString(1, pmm.getAddress());
			stmt.setInt(2, pmm.getSqid());
			stmt.setInt(3, pmm.getAreaid());
			stmt.setInt(4, pmm.getCityid());
			stmt.setInt(5, pmm.getNbed());
			stmt.setInt(6, pmm.getNdath());
			int value=stmt.executeUpdate();
			return value>0 ? true: false;
		}
		catch(Exception ex)
		{
			System.out.println("Error in adding property "+ex);
		}
		return false;
	}

}
