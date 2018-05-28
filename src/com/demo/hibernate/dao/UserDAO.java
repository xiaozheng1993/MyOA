package com.demo.hibernate.dao;

import java.util.List;

import com.demo.struts.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.hibernate.beans.User;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	public Pager findPager(final int pageSize,
						   final int pageNo) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();

		// set query condition
		Criteria criteria = session.createCriteria(User.class);

		// get total count
		int rowCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);

		// get current page list
		int startIndex = pageSize * (pageNo - 1);
		criteria.addOrder(Order.desc("createDate"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		List result = criteria.list();

		session.close();

		return new Pager(pageSize, pageNo, rowCount, result);
	}

	public boolean isValid(final String username, final String password) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).add(
						Restrictions.eq("password", password)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExist(final String username) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(User.class).add(
						Restrictions.eq("username", username)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void insertUser(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	public User getUser(String userid) {
		return (User) getHibernateTemplate().get(User.class,
				new Integer(userid));
	}

	public List getUsers() {
		return getHibernateTemplate().find("from "+ User.class);
	}

	public void deleteUser(String userid) {
		Object p = getHibernateTemplate().load(User.class, new Integer(userid));
		getHibernateTemplate().delete(p);
	}

	public User findById(String id) {
		return (User) getHibernateTemplate().get(User.class,
				new Integer(id));
	}
}
