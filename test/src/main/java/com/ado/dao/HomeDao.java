package com.ado.dao;

import org.springframework.stereotype.Repository;

import com.ado.model.Home;

@Repository
public interface HomeDao {
	public void save(Home home);
}
