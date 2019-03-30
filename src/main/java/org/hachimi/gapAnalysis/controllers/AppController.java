package org.hachimi.gapAnalysis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController 
{

	@RequestMapping({"/doc"})
	public String doc(Model model)
	{
		return templateLayout(model, "doc.html");
	}
	@RequestMapping({"/", "index", "home"})
	public String home(Model model)
	{
		return templateLayout(model, "home.html");
	}
	
	@RequestMapping("templateLayout")
	public String templateLayout(Model model, String pageName)
	{
		model.addAttribute("PAGE", pageName);
		return "templateLayout.html";
	}
	

}
