package com.ado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ado.dao.HomeDao;
import com.ado.model.Home;

@Component("homeService")
public class HomeServiceImpl {
	
	@Autowired
	private HomeDao dao;
	
	public void setCustomerDao(HomeDao dao){
		this.dao= dao;
	}
	
	public void save(Home home){
		dao.save(home);
	}
}
