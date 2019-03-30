package org.hachimi.gapAnalysis.controllers;

import java.io.IOException;

import org.hachimi.gapAnalysis.utilities.RESTfulJSON;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AzureML 
{
	@Autowired
	AppController appController;
	
	@RequestMapping("/studio")
	public String mlStudio(Model model)
	{
		return appController.templateLayout(model, "studio.html");
	}

	@RequestMapping("/predict")
	public String predict(Model model)
	{
		return appController.templateLayout(model, "predict.html");
	}

	@RequestMapping({"/cachePredict"})
	public @ResponseBody String cache(Model model, @RequestBody String jsonBody) throws IOException, ParseException
	{
		return RESTfulJSON.getPostRequest(jsonBody).toJSONString();
	}
	
	@RequestMapping({"/reportPrediction",})
	public String reportml(Model model)
	{
		return appController.templateLayout(model, "reportPrediction.html");
	}

}
