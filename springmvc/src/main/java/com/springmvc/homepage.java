package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homepage {
	
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Hiiiiiiiiiiiiiiiii");        
		
		model.addAttribute("name","rushi");
		return "index";
	}
	
	
	
	
	@RequestMapping("/about")
	public String about() {
		
		return "about";
	}

}
