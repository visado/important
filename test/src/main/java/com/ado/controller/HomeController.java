package com.ado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ado.model.Home;
import com.ado.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/index")
	public String index(){
		
		Home home = new Home();
		home.setId(6);
		home.setInfo("nico");
		home.setName("brain");
		home.setPic("c.jpg");	
		homeService.save(home);
		
		//add commnit 
		return "index";
	}
}
