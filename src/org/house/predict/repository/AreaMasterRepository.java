package org.house.predict.repository;

import org.house.predict.config.DBHelper;
import org.house.predict.model.AreaMasterModel;
import java.sql.*;

public class AreaMasterRepository extends DBHelper{
	
//		public int addAreaofCity(String areaName)
//		{
//			int cityid=0;
//			try
//			{
//				
//				stmt=conn.prepareStatement("insert into cityarea values('0',?)");
//				stmt.setString(1, areaName);
//				int value=stmt.executeUpdate();
//				stmt=conn.prepareStatement("select max(areaid) from cityarea");
//				rs=stmt.getResultSet();
//				cityid=rs.getInt(1)+1;
//				return cityid;
//			}
//			catch(Exception ex)
//			{
//				System.out.println("error is "+ex);
//				return cityid;
//			}
//		}
	// 				***** 		case no 4
	private static int areaid=0;
	public int getAreaId()
	{
		try
		{
			stmt=conn.prepareStatement("select max(areaid) from cityarea");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				areaid=rs.getInt(1);
			}
			return ++areaid;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return -1;
		}
	}
	public boolean isAddArea(AreaMasterModel amodel)
	{
		try
		{
//			stmt=conn.prepareStatement("insert into cityarea ('0',?)");
//			stmt.setString(1, amodel.getAreaName());
//			int value=stmt.executeUpdate();
//			if(value>0)
//			{
//				stmt=conn.prepareStatement("insert into cityareajoin(?,?)");
//				stmt.setInt(1, amodel.getCityId());
//				stmt.setInt(2, amodel.getAreaId());
//			}
			CallableStatement cstmt= conn.prepareCall("{call savearea(?, ?, ?)}");
			cstmt.setInt(1, amodel.getAreaId());
			cstmt.setString(2, amodel.getAreaName());
			cstmt.setInt(3, amodel.getCityId());
			boolean b=cstmt.execute();
			return !b;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return false;
		}

	}
	
}
