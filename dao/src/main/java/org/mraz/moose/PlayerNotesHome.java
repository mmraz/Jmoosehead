package org.mraz.moose;

// Generated May 30, 2011 12:26:14 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class PlayerNotes.
 * @see org.mraz.moose.PlayerNotes
 * @author Hibernate Tools
 */
public class PlayerNotesHome {

	private static final Log log = LogFactory.getLog(PlayerNotesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PlayerNotes transientInstance) {
		log.debug("persisting PlayerNotes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayerNotes instance) {
		log.debug("attaching dirty PlayerNotes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayerNotes instance) {
		log.debug("attaching clean PlayerNotes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlayerNotes persistentInstance) {
		log.debug("deleting PlayerNotes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayerNotes merge(PlayerNotes detachedInstance) {
		log.debug("merging PlayerNotes instance");
		try {
			PlayerNotes result = (PlayerNotes) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlayerNotes findById(java.lang.Integer id) {
		log.debug("getting PlayerNotes instance with id: " + id);
		try {
			PlayerNotes instance = (PlayerNotes) sessionFactory
					.getCurrentSession().get("org.mraz.moose.PlayerNotes", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PlayerNotes instance) {
		log.debug("finding PlayerNotes instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("org.mraz.moose.PlayerNotes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
