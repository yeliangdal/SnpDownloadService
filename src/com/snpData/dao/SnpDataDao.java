package com.snpData.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.snpData.model.SnpData;

import java.util.List;

import org.hibernate.Query;

public class SnpDataDao implements SnpDataDaoInterface {
	
	private Session currentSession;
	
	private Transaction currentTransaction;
	
	public SnpDataDao(){};
	
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	
	
	//helper class that creates Hibernate sessionfactory
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	
	public void persist(SnpData entity) {
		getCurrentSession().save(entity);
	}

	public void update(SnpData entity) {
		getCurrentSession().update(entity);
	}
	
	public SnpData getSleepDataByProfileID(long profileID) {
		String hql = "from SnpData where profile_id= :profile_id";
		Query query = getCurrentSession().createQuery(hql);
		query.setLong("profile_id", profileID); 
		SnpData snpData = (SnpData)query.uniqueResult();
		return snpData;
	}
	
}
