package com.ado.service;

import org.springframework.stereotype.Component;
import com.ado.model.Home;

@Component
public interface HomeService {
	
	public void save(Home home);
}
