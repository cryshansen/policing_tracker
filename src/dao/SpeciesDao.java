package lab2.dao;

import java.util.List;


import lab2.entity.Charge;
import lab2.entity.Species;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SpeciesDao extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<Species> getSpecies() {
		return getHibernateTemplate().loadAll(Species.class);
	}
	
	/*public Species getSpeciesBySpeciesId(int speciesId) {
		return (Species) getHibernateTemplate().get(Species.class, speciesId);	
	}*/
	public List<Species> getSpeciesByDescription(String description){
		List<Species> speciesList = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Species.class);
		criteria.add( Restrictions.like("description", "%" + description + "%") );
		
		speciesList =  getHibernateTemplate().findByCriteria(criteria);
		return (List<Species>) speciesList;
	}
	/*public void addSpecies(Species species) {
		getHibernateTemplate().save(species);	
	}
	
	public void updateSpecies(Species species) {
		getHibernateTemplate().update(species);	
	}
	
	public void deleteSpecies(Species species) {
		getHibernateTemplate().delete(species);	
	}*/
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(*) from lab2.entity.Species");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}

}
