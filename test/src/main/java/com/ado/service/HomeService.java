package com.ado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ado.dao.HomeDao;
import com.ado.model.Home;

@Service(value="homeService")
public class HomeService {
	
	@Autowired
	private HomeDao homeDao;
	
	public void save(Home home){
		
		homeDao.save(home);
	}
}
