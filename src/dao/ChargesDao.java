package lab2.dao;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import lab2.entity.Charge;



public class ChargesDao extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public List<Charge> getChargesByAct(String act) {
		
		List<Charge> chargeList = null;
//		DetachedCriteria criteria = DetachedCriteria.forClass(Charge.class);
//		criteria.add( Restrictions.like("act_id", "%" + act + "%") );
//		criteria.addOrder(  Order.asc("act_id.act") );
//		chargeList =  getHibernateTemplate().findByCriteria(criteria);
		return (List<Charge>) getHibernateTemplate().find(
			" from lab2.entity.Charge where ACT_ID.act like ?", 
			"%" + act + "%");
	}
	@SuppressWarnings("unchecked")
	public List<Charge> getCharges() {
		return getHibernateTemplate().loadAll(Charge.class);
	}

	
	public void addCharge(Charge charge) {
		getHibernateTemplate().save(charge);
	}
	
	public void updateCharge(Charge charge) {
		getHibernateTemplate().update( charge);
	}
	
	public void deleteCharge(Charge charge) {
		getHibernateTemplate().delete(charge);
	}

}
