package org.house.predict.repository;

import java.util.*;
import org.house.predict.config.DBHelper;
import org.house.predict.config.PathHelper;
import org.house.predict.model.CityMasterModel;
import java.io.*;
import java.sql.*;

public class CityMasterRepository extends DBHelper {

	public boolean isAddNewCity(CityMasterModel model) {
		try {

			stmt = conn.prepareStatement("insert into citymaster values('0',?)");
			stmt.setString(1, model.getCityName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	// case number 2 methode
	public List<CityMasterModel> getAllCities() {
		List<CityMasterModel> list = new ArrayList<CityMasterModel>();
		try {
			stmt = conn.prepareStatement("select *from citymaster");
			rs = stmt.executeQuery();
			// boolean flag=false;

			while (rs.next()) {
				CityMasterModel model = new CityMasterModel();
				model.setCityId(rs.getInt(1));
				model.setCityName(rs.getString(2));
				list.add(model);
				// flag=true;
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			return null;
		}
	}

	// case 3 methode
	public boolean isBulkAddCities() {
		try {
			FileReader fr = new FileReader(PathHelper.path + "city.csv");
			BufferedReader bw = new BufferedReader(fr);
			String line;
			int value = 0;
			while ((line = bw.readLine()) != null) {
				String cityd[] = line.split(",");
				stmt = conn.prepareStatement("insert into citymaster values ('0',?)");
				stmt.setString(1, cityd[1]);
				value = stmt.executeUpdate();
			}
			bw.close();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	// case 4:
	public int getCityId(String cname) {
		try {
			stmt = conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, cname);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
//			return stmt
		} catch (Exception ex) {
			System.out.println("error is " + ex);
			return -1;
		}
	}

	// case 5:
	private List<Object[]> cityWiseAreaCount = null;

	public List<Object[]> getCityWiseCount() {
		try {
			cityWiseAreaCount = new ArrayList<Object[]>();
			stmt = conn.prepareStatement("select cm.cityname , count(caj.cityid) from citymaster cm "
					+ "inner join cityareajoin caj on cm.cityid=caj.cityid inner join cityarea ca on "
					+ "ca.areaid=caj.areaid group by cm.cityname");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object obj[] = new Object[] { rs.getString(1), rs.getInt(2) };
				cityWiseAreaCount.add(obj);
			}
			return cityWiseAreaCount;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}

	}

	// **** case no 6
	public LinkedHashMap<String, ArrayList<String>> getCityWiseAreaName() {
		LinkedHashMap<String, ArrayList<String>> caNameMap = new LinkedHashMap<String, ArrayList<String>>();
		
		try {
			stmt = conn.prepareStatement(
					"select cm.cityname from citymaster cm inner join cityareajoin caj on "
					+ "cm.cityid=caj.cityid inner join cityarea ca on ca.areaid=caj.areaid "
					+ "group by cm.cityid");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				PreparedStatement pstmt=conn.prepareStatement("select ca.areaname from citymaster"
						+ " cm inner join cityareajoin caj on cm.cityid=caj.cityid inner join cityarea "
						+ "ca on ca.areaid=caj.areaid where cm.cityname= ? ");
				String cityName=rs.getString(1);
				pstmt.setString(1, cityName);
				ResultSet rs1 = pstmt.executeQuery();
//				if(rs1.next()) {
//					areaList.add(rs1.getString(1));
//				}
				ArrayList<String> areaList = new ArrayList<String>();
				while(rs1.next())
				{
					areaList.add(rs1.getString(1));
				}
				caNameMap.put(cityName, areaList);
//				areaList.clear();
			}
			return caNameMap;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}

		
	}

}
