package lab2.dao;

import java.util.Hashtable;
import java.util.List;

import lab2.entity.Offender;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * This is the DAO class for the offenders table.
 * @author Sam Wu
 *
 */
public class OffenderDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Offender> getOffenders() {
		return getHibernateTemplate().loadAll(Offender.class);
	}
	
	public Offender getOffenderByOffenderId(int offenderId) {
		return (Offender) getHibernateTemplate().get(Offender.class, offenderId);	
	}
	
	//may need to redo this without the hashcode only passing in first and last name
	@SuppressWarnings("unchecked")
	public List<Offender> findOffenderByAll(Hashtable searchTable) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Offender.class);
		java.util.Enumeration<String> e = searchTable.keys();
		while( e.hasMoreElements() ) {
			String fieldName = e.nextElement();
			String fieldValue = (String) searchTable.get(fieldName);
			/*if( fieldName.equalsIgnoreCase("employeeNumber") ) {
				criteria.createCriteria("salesRep").add( Restrictions.eq("employeeNumber", Integer.parseInt(fieldValue) ) );
			} else {*/
				criteria.add( Restrictions.like(fieldName,  fieldValue, MatchMode.ANYWHERE) );
			//}
			criteria.addOrder( Order.asc("lastName") );
		}
		return getHibernateTemplate().findByCriteria(criteria);		
	}
	
	public void addOffender(Offender offender) {
		getHibernateTemplate().save(offender);	
	}
	
	public void updateOffender(Offender offender) {
		getHibernateTemplate().update(offender);	
	}
	
	public void deleteOffender(Offender offender) {
		getHibernateTemplate().delete(offender);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(*) from lab2.entity.Offender");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
		
}
