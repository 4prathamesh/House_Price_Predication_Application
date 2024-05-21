package org.house.predict.repository;

import org.house.predict.config.DBHelper;

public class AreaSquerFeetRepository extends DBHelper {
	public boolean setSquerFeet(float sf, int sfid)
	{
		try
		{
			stmt=conn.prepareStatement("insert into areasquerfeet values (?,?)");
			stmt.setInt(1, sfid);
			stmt.setFloat(2, sf);
			int value=stmt.executeUpdate();
			return value > 0 ? true : false;

		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
	public int getSquerFeetId()
	{
		try
		{
			stmt=conn.prepareStatement("select max(sqid) from areasquerfeet ");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return -1;
		}
		return -1;
	}
}
