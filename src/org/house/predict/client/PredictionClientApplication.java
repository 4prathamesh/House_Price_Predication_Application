package org.house.predict.client;
import java.util.*;

import org.house.predict.model.AreaMasterModel;
import org.house.predict.model.CityMasterModel;
import org.house.predict.service.AreaMasterService;
import org.house.predict.service.AreaSquerFeetService;
import org.house.predict.service.CityMasterService;
public class PredictionClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CityMasterService cms= new CityMasterService();
		AreaMasterService  ams= new AreaMasterService();
		AreaSquerFeetService asfs= new AreaSquerFeetService();
		List<CityMasterModel> list= new ArrayList<CityMasterModel>();
		boolean flag=false;
		do {
			
			Scanner sc= new Scanner(System.in);
			System.out.println("1. Add New City");
			System.out.println("2. Diaplay all City");
			System.out.println("3. Add Bulk Cites");
			System.out.println("4. Add New area ");
			System.out.println("5. City wise Area count");
			System.out.println("6. City wise Area names ");
			System.out.println("12. Exit App!!!!!!");
			
			System.out.println("enter the choice");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the City Name");
				String cityName=sc.nextLine();
				CityMasterModel model= new CityMasterModel();
				model.setCityName(cityName);
				boolean b=cms.isAddCity(model);
				if(b)
				{
					System.out.println("New city is adde");
				}
				else
				{
					System.out.println("city is not add");
				}
				break;
			case 2:
				System.out.println("List of all city ");
				list=cms.getAllCites();
				if(list!=null)
				{
					list.forEach((m)->System.out.println(m.getCityId()+"\t"+m.getCityName()));
				}
				else
				{
					System.out.println("city is not present");
				}
				break;
				
			case 3:
				b= cms.isBulkAddCities();
				if(b)
				{
					System.out.println("city added Successfull ...");
				}
				else
				{
					System.out.println("city is not add");
				}
				break;
			case 4:			//    Add New area
				System.out.println("enter the City name ");
				String cname=sc.nextLine();
				int cityid=cms.getCityId(cname);
				if(cityid!=-1)
				{
					System.out.println("Enter the area ");
					String areaName=sc.nextLine();
					
					AreaMasterModel amodel=new AreaMasterModel();
					amodel.setCityId(cityid);
					amodel.setAreaId(ams.getAreaId());
					amodel.setAreaName(areaName);
//					System.out.println(amodel.getCityId()+"\t"+amodel.getAreaName()+"\t"+amodel.getAreaId());
					b=ams.isAddArea(amodel);
					if(b)
					{
						System.out.println("area is add ");
					}
					else
					{
						System.out.println("area is not add");
					}
				}
				else
				{
					System.out.println("City is not Present");
					System.out.println("do you want to add city ");
					String msj=sc.nextLine();
					if(msj.equals("yes"))
					{
						
						model= new CityMasterModel();
						model.setCityName(cname);
						b=cms.isAddCity(model);
						if(b)
						{
							System.out.println("New city is adde");
						}
						else
						{
							System.out.println("city is not add");
						}
					}
				}
				
				break;
			case 5:           //    City wise Area count
				List<Object[]> cityWiseAreaCount= cms.getCityWiseCount();
				Iterator<Object[]> it=cityWiseAreaCount.iterator();
				System.out.println("City \t No of Area");
				while(it.hasNext())
				{
					Object obj[]=it.next();
					System.out.println(obj[0] +"\t"+ obj[1]);
				}
				
				break;
			case 6:   //  City wise Area names
				
				LinkedHashMap<String, ArrayList<String>> caNameMap =cms.getCityWiseAreaName();
				for(Map.Entry<String, ArrayList<String>> m : caNameMap.entrySet())
				{
					System.out.println("\nCity Name : "+m.getKey());
					System.out.println("+++++++++++++++++++++++++++++++");
					ArrayList<String> al=m.getValue();
					System.out.println("Area name: ");
					for(String l:al)
					{
						System.out.println("\t"+l);
					}
					System.out.println();
				}
				
				break;
			case 7:  // Enter the Squer feet
				
				System.out.println("Enter the Squer feet ");
				float sf=sc.nextFloat();
				int sfid=asfs.getSquerFeetId();
				System.out.println("Squer feet "+sfid);
				b=asfs.setSquerFeet(sf,sfid);
				
				break;
				
			case 12:
				flag=true;
				break;
				default:
					System.out.println("Wrong choice");
			}
			if(flag)
			{
				break;
			}
		}while(true);

	}

}
