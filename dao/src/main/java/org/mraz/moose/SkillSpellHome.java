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
 * Home object for domain model class SkillSpell.
 * @see org.mraz.moose.SkillSpell
 * @author Hibernate Tools
 */
public class SkillSpellHome {

	private static final Log log = LogFactory.getLog(SkillSpellHome.class);

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

	public void persist(SkillSpell transientInstance) {
		log.debug("persisting SkillSpell instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SkillSpell instance) {
		log.debug("attaching dirty SkillSpell instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SkillSpell instance) {
		log.debug("attaching clean SkillSpell instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SkillSpell persistentInstance) {
		log.debug("deleting SkillSpell instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SkillSpell merge(SkillSpell detachedInstance) {
		log.debug("merging SkillSpell instance");
		try {
			SkillSpell result = (SkillSpell) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SkillSpell findById(java.lang.Integer id) {
		log.debug("getting SkillSpell instance with id: " + id);
		try {
			SkillSpell instance = (SkillSpell) sessionFactory
					.getCurrentSession().get("org.mraz.moose.SkillSpell", id);
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

	public List findByExample(SkillSpell instance) {
		log.debug("finding SkillSpell instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("org.mraz.moose.SkillSpell")
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
