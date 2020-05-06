package lab2.dao;
import java.util.List;

import lab2.entity.District;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DistrictDao extends HibernateDaoSupport{

	public List<District> getDistricts() {
		return getHibernateTemplate().loadAll(District.class);
	}
	
	public District getDistrictByDistrictCode(String code) {
		return (District) getHibernateTemplate().get(District.class, code);	
	}
	
	public void addDistrict(District district) {
		getHibernateTemplate().save(district);	
	}
	
	public void updateDistrict(District district) {
		getHibernateTemplate().update(district);	
	}
	
	public void deleteDistrict(District district) {
		getHibernateTemplate().delete(district);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(*) from lab2.entity.District");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
	
}
