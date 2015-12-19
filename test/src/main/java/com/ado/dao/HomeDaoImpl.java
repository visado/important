package com.ado.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ado.model.Home;

@Repository("homeDao")
public class HomeDaoImpl implements HomeDao{

	@PersistenceContext(unitName="jpa")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	@Transactional
	public void save(Home home){
		entityManager.persist(home);
	}
}

