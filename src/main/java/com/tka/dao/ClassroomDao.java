package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Classroom;

@Repository
public class ClassroomDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Classroom> fetchAllClassrooms() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> results = criteria.list();
		return results;
	}

	public Classroom fetchclassroom(int classroomId) {
		Session session = sessionFactory.openSession();
		return session.get(Classroom.class, classroomId);
	}

	public void insertlocation(Classroom classroom) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classroom);
		transaction.commit();
	}

	public Classroom updatelocation(int clsId) {
		Session session = sessionFactory.openSession();
		return session.get(Classroom.class, clsId);
	}

	public void update(Classroom classroom) {
		Transaction transaction = sessionFactory.openSession().beginTransaction();
		sessionFactory.openSession().update(classroom);
		transaction.commit();
	}

	public ArrayList<Classroom> findByCapacityGreaterThan(int capacity) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		criteria.add(Restrictions.gt("clsCapacity", capacity)); // gt for greater than
		List<Classroom> results = criteria.list();
		return new ArrayList<>(results);
	}

	public ArrayList<Classroom> findByLocation(String location) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		criteria.add(Restrictions.eq("clsLocation", location)); // eq for equality
		List<Classroom> results = criteria.list();
		return new ArrayList<>(results);
	}

	public Classroom findByName(String clsName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		criteria.add(Restrictions.eq("clsName", clsName)); // eq for equality
		return (Classroom) criteria.uniqueResult();
	}
}