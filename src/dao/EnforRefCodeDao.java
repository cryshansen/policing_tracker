package lab2.dao;
import java.util.List;

import lab2.entity.EnforRefCode;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import lab2.entity.EnforRefCode;

public class EnforRefCodeDao extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<EnforRefCode> getEnforRefCodes() {
		return getHibernateTemplate().loadAll(EnforRefCode.class);
	}
	public List<EnforRefCode> getByAll(java.util.Hashtable<String,String> searchTable){
		java.util.List<EnforRefCode> resultSet;
		DetachedCriteria criteria = DetachedCriteria.forClass(EnforRefCode.class);
		java.util.Enumeration<String> e = searchTable.keys();
		while( e.hasMoreElements() ) {
			String fieldName = e.nextElement();
			String fieldValue = searchTable.get(fieldName);
//			criteria.add( Restrictions.like(fieldName,  "%"  + fieldValue + "%") );
			criteria.add( Restrictions.sqlRestriction( fieldName + "  like ?", "%"  + fieldValue + "%", 
					org.hibernate.Hibernate.STRING) );
		}
		
		resultSet = getHibernateTemplate().findByCriteria(criteria);
		return resultSet;
	}
	
	public EnforRefCode getEnforRefCodeByEnforRefCode(int enforRefCodeId) {
		return (EnforRefCode) getHibernateTemplate().get(EnforRefCode.class, enforRefCodeId);	
	}
	@SuppressWarnings("unchecked")
	public List<EnforRefCode> getAllViolationTypeDomains(

			String Violation){
		return getHibernateTemplate().find(
				"from lab2.entity.EnforRefCode where " +
				"enforRefCodeID.rvDomain like ? ",
				new Object[] {
						"%" + Violation +"%",
				});
			}

	//suspendOffDomainId chargerTypeDomainId regCommunDomainId initiatedBy
	
	public void addEnforRefCode(EnforRefCode enforRefCode) {
		getHibernateTemplate().save(enforRefCode);	
	}
	
	public void updateEnforRefCode(EnforRefCode enforRefCode) {
		getHibernateTemplate().update(enforRefCode);	
	}
	
	public void deleteEnforRefCode(EnforRefCode enforRefCode) {
		getHibernateTemplate().delete(enforRefCode);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(*) from lab2.entity.EnforRefCode");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}

}
