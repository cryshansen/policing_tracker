package lab2.bll;

import java.util.Hashtable;
import java.util.List;

import lab2.dao.OfficerDao;
import lab2.entity.Officer;
public class OfficerManager {
	private static OfficerDao officerDao = lab2.util.SpringFactory.getOfficerDao();
	
	public java.util.List<Officer> getOfficers(){
		return officerDao.getOfficers();
	}
	//need a find by officer name and badge query
	public java.util.List<Officer> findOffenderByOfficerBadge(Hashtable searchTable){
		return officerDao.findOffenderByOfficerBadge(searchTable);
	}
	public Officer getOfficerByOfficerId(int officerId){
		return officerDao.getOfficerByOfficerId(officerId);
	}
	public void addOfficer(Officer officer){
		officerDao.addOfficer(officer);
	}
	public void updateOfficer(Officer officer){
		officerDao.updateOfficer(officer);
	}
	public void deleteOfficer(Officer officer){
		officerDao.deleteOfficer(officer);
	}
}
