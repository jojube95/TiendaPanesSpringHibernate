package com.joan.tiendapanes.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tienda")
public class LogOut {

	@Autowired 
	private HttpSession httpSession;
	
	@RequestMapping("/logOut")
	public String logOut() {
				
		httpSession.invalidate();
				
		return "index";
	}
}
