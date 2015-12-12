package com.ado.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.ado.model.Home;

@Repository("homeDao")
public class HomeDaoImpl {

	private EntityManager entityManager;
	
	@PersistenceContext(unitName="jpa")
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	public void save(Home home){
		entityManager.persist(home);
	}
}

