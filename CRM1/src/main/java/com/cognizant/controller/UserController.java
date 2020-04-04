package com.cognizant.controller;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.entity.Login;
import com.cognizant.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(Model model)
	{
		Login login=new Login();
		model.addAttribute("user", login);
		return "Login-form";
	}
	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("user") Login login)
	{	
		boolean b=userService.validateUser(login.getUsername(),login.getPassword());
		if(!b)
			return "redirect:/user/login";
		return "Home"; 
	}
	@GetMapping("/showFormForAdd")
	public String addUser(Model model)
	{
		Login login =new Login();
		model.addAttribute("user", login);
		return "Registration-form";
	}
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") Login login,BindingResult bind)
	{
		if(bind.hasErrors())
			return "Registration-form";
		else
		{
			userService.saveUser(login);
			return "Home";
		}
	}
	
	
}
