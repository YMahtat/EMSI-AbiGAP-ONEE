package org.hachimi.gapAnalysis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessIntelligenceController 
{

    @Autowired
	AppController appController;
	
	@RequestMapping({"/bi",})
	public String bi(Model model)
	{
		return appController.templateLayout(model, "bi.html");
	}
    
}