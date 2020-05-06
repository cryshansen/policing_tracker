package lab2.dao;

import java.util.List;

import lab2.entity.Act;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ActDao extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<Act> getActs() {
		return getHibernateTemplate().loadAll(Act.class);
	}
	
	public Act getActByActId(int actId) {
		return (Act) getHibernateTemplate().get(Act.class, actId);	
	}
	
	public void addAct(Act act) {
		getHibernateTemplate().save(act);	
	}
	
	public void updateAct(Act act) {
		getHibernateTemplate().update(act);	
	}
	
	public void deleteAct(Act act) {
		getHibernateTemplate().delete(act);	
	}

}
