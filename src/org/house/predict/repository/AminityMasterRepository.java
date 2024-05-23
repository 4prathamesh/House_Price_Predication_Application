package org.house.predict.repository;

import org.house.predict.config.DBHelper;

public class AminityMasterRepository extends DBHelper {

	public boolean setAminity(String aminityName) {
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("insert into aminitymaster values ('0',?)");
			stmt.setString(1, aminityName);
			int value=stmt.executeUpdate();
			return value>0 ? true : false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
}
