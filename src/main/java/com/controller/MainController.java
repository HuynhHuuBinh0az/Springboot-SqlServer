package com.controller;

import com.entity.*;
import com.repository.UserRepository;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
    private UserRepository userRepository;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
		model.addAttribute("Users", userRepository.findAll());
		model.addAttribute("User", new Users());
		return "index";
    }
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String insert(Model model, @ModelAttribute("User") Users user) {
		userRepository.save(user);
		return "redirect:/index";
    }
	
	@RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
		Users user = userRepository.findById(id).get();
		model.addAttribute("User", user);
		model.addAttribute("Users", userRepository.findAll());
		return "index";
    }
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		userRepository.delete(userRepository.findById(id).get());;
		return "redirect:/index";
    }
}
