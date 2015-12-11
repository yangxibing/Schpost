package com.schpost.Dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schpost.entity.Poster;

/**
 * A data access object (DAO) providing persistence and search support for
 * Poster entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.schpost.Dao.Poster
 * @author MyEclipse Persistence Tools
 */
public class PosterDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PosterDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String CELLPHONE_NUM = "cellphoneNum";
	public static final String LEVEL = "level";
	public static final String IS_WORKING = "isWorking";
	public static final String WKPLACE = "wkplace";

	protected void initDao() {
		// do nothing
	}

	public void save(Poster transientInstance) {
		log.debug("saving Poster instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Poster persistentInstance) {
		log.debug("deleting Poster instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Poster findById(java.lang.Integer id) {
		log.debug("getting Poster instance with id: " + id);
		try {
			Poster instance = (Poster) getHibernateTemplate().get(
					"com.schpost.entity.Poster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Poster> findByExample(Poster instance) {
		log.debug("finding Poster instance by example");
		try {
			List<Poster> results = (List<Poster>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Poster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Poster as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Poster> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Poster> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Poster> findByCellphoneNum(Object cellphoneNum) {
		return findByProperty(CELLPHONE_NUM, cellphoneNum);
	}

	public List<Poster> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<Poster> findByIsWorking(Object isWorking) {
		return findByProperty(IS_WORKING, isWorking);
	}

	public List<Poster> findByWkplace(Object wkplace) {
		return findByProperty(WKPLACE, wkplace);
	}

	public List findAll() {
		log.debug("finding all Poster instances");
		try {
			String queryString = "from Poster";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Poster merge(Poster detachedInstance) {
		log.debug("merging Poster instance");
		try {
			Poster result = (Poster) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Poster instance) {
		log.debug("attaching dirty Poster instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Poster instance) {
		log.debug("attaching clean Poster instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PosterDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PosterDAO) ctx.getBean("PosterDAO");
	}
}