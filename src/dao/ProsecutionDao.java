package lab2.dao;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import lab2.entity.Offender;
import lab2.entity.Prosecution;

public class ProsecutionDao extends HibernateDaoSupport{



		public Prosecution getProsecutionByProsecutionId(int prosecutionId) {
			return (Prosecution) getHibernateTemplate().get(Prosecution.class, prosecutionId);	
		}
		@SuppressWarnings("unchecked")
		public List<Prosecution> getProsecutions() {
			return getHibernateTemplate().loadAll(Prosecution.class);
		}
		
		@SuppressWarnings("unchecked")
		public List<Prosecution> findProseuctionsByAll(Hashtable searchTable) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Prosecution.class);
			java.util.Enumeration<String> e = searchTable.keys();
			while( e.hasMoreElements() ) {
				String fieldName = e.nextElement();
				String fieldValue = (String) searchTable.get(fieldName);
				if( fieldName.equalsIgnoreCase("offenderId") ) {
					criteria.createCriteria("offender").add( Restrictions.eq("offenderId", Integer.parseInt(fieldValue) ) );
				} else if (fieldName.equalsIgnoreCase("chargeId") ) {
					criteria.createCriteria("charge").add( Restrictions.eq("chargeId", Integer.parseInt(fieldValue) ) );
				
				} else if (fieldName.equalsIgnoreCase("officerId") ) {
					criteria.createCriteria("officer").add( Restrictions.eq("officerId", Integer.parseInt(fieldValue) ) );
				} else if (fieldName.equalsIgnoreCase("chargerTypeId") ) {
						criteria.createCriteria("chargeType").add( Restrictions.eq("enforRefCodeId", Integer.parseInt(fieldValue) ) );
				} else if (fieldName.equalsIgnoreCase("ticketTypeId") ) {
						criteria.createCriteria("ticketType").add( Restrictions.eq("enforRefCodeId", Integer.parseInt(fieldValue) ) );
				} else if (fieldName.equalsIgnoreCase("initiatedById") ) {
					criteria.createCriteria("initiatedBy").add( Restrictions.eq("enforRefCodeId", Integer.parseInt(fieldValue) ) );
				}else if (fieldName.equalsIgnoreCase("fileyear") ) {
					criteria.add( Restrictions.eq("fieldName", Integer.parseInt(fieldValue) ) );
				}else {
					criteria.add( Restrictions.like(fieldName,  fieldValue, MatchMode.ANYWHERE) );
				}
				//criteria.addOrder( Order.asc("customerName") );
			}
			
			return getHibernateTemplate().findByCriteria(criteria);		
		}
		
		@SuppressWarnings("unchecked")
		public List<Prosecution> getProsecutionByAll(
				String FirstName,
				String LastName,
				String description,
				String Section,	
				Integer file_year,
				String Docket_Ticket_Number,
				Integer ChargerType,
				String Place_Of_Offence,
				Integer TicketType,
				String	Place_Of_Trial,
				Integer InitiatedBy,
				String Officer,
				Integer Badge
					) {
			
			return getHibernateTemplate().find(
				"from lab2.entity.Prosecution where " +
				"offenderId.firstName like ? and " +
				"offenderId.lastName like ? and " +
				"chargeId.description like ? and " +
				"chargeId.section like ? and " +
				" fileyear = ? and " +
				"docketticketNumber like ? and " +
				"chargerTypeDomainId.enforRefCodeID = ? and " +
				"placeOfOffence like ? and " +
				"ticketTypeDomainId.enforRefCodeID like ? and " +
				"placeOfTrial like ? and " +
				"initiatedByDomainID.enforRefCodeID like ? and " +
				"officer_Id.officer like ? and " +
				"officer_Id.badge = ?",
				new Object[] {
						"%" + FirstName +"%",
						"%" + LastName + "%",
						"%" + description + "%",
						"%" + Section +"%",
						file_year,
						"%" + Docket_Ticket_Number +"%",
						ChargerType, 
						"%" + Place_Of_Offence + "%",
						TicketType,
						"%" + Place_Of_Trial +"%",
						InitiatedBy, 
						"%" + Officer + "%",
						Badge,
				
						
				});
		}

				
		
		public void addProsecution(Prosecution prosecution) {
			getHibernateTemplate().save(prosecution);
		}
		
		public void updateProsecution(Prosecution prosecution) {
			getHibernateTemplate().update( prosecution);
		}
		
		public void deleteProsecution(Prosecution prosecution) {
			getHibernateTemplate().delete(prosecution);
		}
	
		
	}

