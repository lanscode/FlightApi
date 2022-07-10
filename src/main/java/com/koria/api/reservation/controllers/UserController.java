package com.koria.api.reservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koria.api.reservation.dto.LoginRequest;
import com.koria.api.reservation.models.User;
import com.koria.api.reservation.service.SecurityService;
import com.koria.api.reservation.service.UserService;

@Controller
public class UserController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private BCryptPasswordEncoder encoder; //Has to be defined as a bean in a configuration class, otherwise, spring will not create it
	@Autowired
	private UserService service;
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		LOGGER.info("Register Form called");
		return "user/register";
	}
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String doRegistration(@ModelAttribute("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		service.save(user);
		return "user/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		LOGGER.debug("Login Form called");
		return "user/login";
	}
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest,ModelMap modelMap) {
		LOGGER.warn("Trying to log into system");
        try {
        	//User user = service.findByEmail(loginRequest.getEmail());
    		//String cryptedPassword = encoder.encode(loginRequest.getPassword());		
    		boolean loginResponse = securityService.login(loginRequest.getEmail(), loginRequest.getPassword());
    		
    		if(loginResponse) {
    			LOGGER.info("Logged in successfully");
    			return "flight/search";
    		}else {
    			LOGGER.error("UserName or Password incorrect. Please try again");
    			modelMap.addAttribute("errorMsg", "UserName or Password incorrect. Please try again");
    			return "user/login";
    		}
        }catch (Exception e) {
        	LOGGER.error("UserName or Password incorrect. Please try again");
			modelMap.addAttribute("errorMsg", "UserName or Password incorrect. Please try again");
			return "user/login";
		}
		
	}
}
