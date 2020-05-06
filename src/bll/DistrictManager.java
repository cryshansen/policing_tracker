package lab2.bll;

import java.util.Hashtable;
import java.util.List;
import lab2.entity.District;
import lab2.dao.DistrictDao;

public class DistrictManager {
	private static DistrictDao districtDao = lab2.util.SpringFactory.getDistrictDao();
	
	@SuppressWarnings("unchecked")
	public java.util.List<District> getDistricts(){
	return districtDao.getDistricts();	
	}
	 public District getDistrictByDistrictCode(String code){
		 return districtDao.getDistrictByDistrictCode(code);
		 
	 }
	 
	 public void addDistrict(District district){
		 districtDao.addDistrict(district);
	 }
	 public void updateDistrict(District district){
		 districtDao.updateDistrict(district);
	 }
	 public void deleteDistrict(District district){
		 districtDao.deleteDistrict(district);
	 }

}
