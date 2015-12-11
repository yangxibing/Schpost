package com.schpost.Dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schpost.entity.Orders;
import com.schpost.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orders entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.schpost.Dao.Orders
 * @author MyEclipse Persistence Tools
 */
public class OrdersDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(OrdersDAO.class);
	// property constants
	public static final String IDUSER = "iduser";
	public static final String IDPOSTER = "idposter";
	public static final String TYPE = "type";
	public static final String EX_COMPANY = "exCompany";
	public static final String EX_NAME = "exName";
	public static final String EX_CELLNUM = "exCellnum";
	public static final String EX_ADDRESS = "exAddress";
	public static final String DE_NAME = "deName";
	public static final String DE_CELLNUM = "deCellnum";
	public static final String DE_ADDRESS = "deAddress";
	public static final String STATUS = "status";
	public static final String PAY_TYPE = "payType";
	public static final String IS_URGENT = "isUrgent";
	public static final String PRICE = "price";

	protected void initDao() {
		// do nothing
	}

	public void save(Orders transientInstance) {
		log.debug("saving Orders instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(Orders transientInstance) {
		log.debug("updating Commodity instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public Orders findById(java.lang.Integer id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getHibernateTemplate().get(
					"com.schpost.entity.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Orders> findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
		try {
			List<Orders> results = (List<Orders>) getHibernateTemplate()
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
		log.debug("finding Orders instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orders as model where model."
					+ propertyName + "= ? order by od_time desc";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Orders> findByIduser(Object iduser) {
		return findByProperty(IDUSER, iduser);
	}

	public List<Orders> findByIdposter(Object idposter) {
		return findByProperty(IDPOSTER, idposter);
	}

	public List<Orders> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Orders> findByExCompany(Object exCompany) {
		return findByProperty(EX_COMPANY, exCompany);
	}

	public List<Orders> findByExName(Object exName) {
		return findByProperty(EX_NAME, exName);
	}

	public List<Orders> findByExCellnum(Object exCellnum) {
		return findByProperty(EX_CELLNUM, exCellnum);
	}

	public List<Orders> findByExAddress(Object exAddress) {
		return findByProperty(EX_ADDRESS, exAddress);
	}

	public List<Orders> findByDeName(Object deName) {
		return findByProperty(DE_NAME, deName);
	}

	public List<Orders> findByDeCellnum(Object deCellnum) {
		return findByProperty(DE_CELLNUM, deCellnum);
	}

	public List<Orders> findByDeAddress(Object deAddress) {
		return findByProperty(DE_ADDRESS, deAddress);
	}

	public List<Orders> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Orders> findByPayType(Object payType) {
		return findByProperty(PAY_TYPE, payType);
	}

	public List<Orders> findByIsUrgent(Object isUrgent) {
		return findByProperty(IS_URGENT, isUrgent);
	}

	public List<Orders> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders order by od_time ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrdersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrdersDAO) ctx.getBean("OrdersDAO");
	}
}