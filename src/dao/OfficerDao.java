package lab2.dao;
import java.util.Hashtable;
import java.util.List;


import lab2.entity.Officer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class OfficerDao extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	
	public List<Officer> getOfficers() {
		return getHibernateTemplate().loadAll(Officer.class);
	}
	
	public Officer getOfficerByOfficerId(int officerId) {
		return (Officer) getHibernateTemplate().get(Officer.class, officerId);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Officer>findOffenderByOfficerBadge(Hashtable searchTable){
		
		
			DetachedCriteria criteria = DetachedCriteria.forClass(Officer.class);
			java.util.Enumeration<String> e = searchTable.keys();
			while( e.hasMoreElements() ) {
				String fieldName = e.nextElement();
				String fieldValue = (String) searchTable.get(fieldName);
				if( fieldName.equalsIgnoreCase("badge") ) {
					criteria.createCriteria("badge").add( Restrictions.eq("badge", Integer.parseInt(fieldValue) ) );
				} else {
					criteria.add( Restrictions.like(fieldName,  fieldValue, MatchMode.ANYWHERE) );
				}
				criteria.addOrder( Order.asc("officer") );
			}
			return getHibernateTemplate().findByCriteria(criteria);		
		}
		
	
	public void addOfficer(Officer officer) {
		getHibernateTemplate().save(officer);	
	}
	
	public void updateOfficer(Officer officer) {
		getHibernateTemplate().update(officer);	
	}
	
	public void deleteOfficer(Officer officer) {
		getHibernateTemplate().delete(officer);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(*) from lab2.entity.Officer");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
}
