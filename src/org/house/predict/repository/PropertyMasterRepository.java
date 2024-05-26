package org.house.predict.repository;

import java.util.List;

import org.house.predict.config.DBHelper;
import org.house.predict.model.AminityMasterModel;
import org.house.predict.model.PropertyMasterModel;

public class PropertyMasterRepository extends DBHelper{

	public boolean setProperty(PropertyMasterModel pmm) {
		// TODO Auto-generated method stub
		try
		{
			// data enter in propertymaster table 
			stmt=conn.prepareStatement("insert into propertymaster values ('0',?,?,?,?,?,?)");
			stmt.setString(1, pmm.getAddress());
			stmt.setInt(2, pmm.getSqid());
			stmt.setInt(3, pmm.getAreaid());
			stmt.setInt(4, pmm.getCityid());
			stmt.setInt(5, pmm.getNbed());
			stmt.setInt(6, pmm.getNdath());
			int value=stmt.executeUpdate();
			int pid=-1;
			stmt=conn.prepareStatement("select max(pid) from propertymaster ");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				pid=rs.getInt(1);
			}
			// data add in propertymaster and aminity join
			List<AminityMasterModel> al=pmm.getAmList();
			for(int i=0;i<al.size();i++)
			{
				AminityMasterModel amm=al.get(i);
				String amiName=amm.getAmName();
				stmt=conn.prepareStatement("select amid from aminitymaster where aminities=?");
				stmt.setString(1, amiName);
				rs=stmt.executeQuery();
				if(rs.next())
				{
					int amid=rs.getInt(1);
					stmt=conn.prepareStatement("insert into propertyaminityjoin values (?,?)");
					stmt.setInt(1, pid);
					stmt.setInt(2, amid);
					stmt.executeUpdate();
				}
			}
			return value>0 ? true: false;
		}
		catch(Exception ex)
		{
			System.out.println("Error in adding property "+ex);
		}
		return false;
	}

}
