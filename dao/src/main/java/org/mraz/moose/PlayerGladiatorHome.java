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
 * Home object for domain model class PlayerGladiator.
 * @see org.mraz.moose.PlayerGladiator
 * @author Hibernate Tools
 */
public class PlayerGladiatorHome {

	private static final Log log = LogFactory.getLog(PlayerGladiatorHome.class);

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

	public void persist(PlayerGladiator transientInstance) {
		log.debug("persisting PlayerGladiator instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayerGladiator instance) {
		log.debug("attaching dirty PlayerGladiator instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayerGladiator instance) {
		log.debug("attaching clean PlayerGladiator instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlayerGladiator persistentInstance) {
		log.debug("deleting PlayerGladiator instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayerGladiator merge(PlayerGladiator detachedInstance) {
		log.debug("merging PlayerGladiator instance");
		try {
			PlayerGladiator result = (PlayerGladiator) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlayerGladiator findById(java.lang.Integer id) {
		log.debug("getting PlayerGladiator instance with id: " + id);
		try {
			PlayerGladiator instance = (PlayerGladiator) sessionFactory
					.getCurrentSession().get("org.mraz.moose.PlayerGladiator",
							id);
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

	public List findByExample(PlayerGladiator instance) {
		log.debug("finding PlayerGladiator instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("org.mraz.moose.PlayerGladiator")
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
