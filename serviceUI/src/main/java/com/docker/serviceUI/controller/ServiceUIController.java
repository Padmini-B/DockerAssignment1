package com.docker.serviceUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ServiceUIController<Microservice> {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/square")
	public ModelAndView square(@RequestParam("num")int num,Model model)
	{
		int square=this.restTemplate.getForObject("http://square:8081/square/"+num,int.class);
		ModelAndView modelAndView = new ModelAndView("square");
		System.out.println(square);
	    modelAndView.addObject("response", "Square of " + num +": " +square);
		//model.addAttribute("response", square);
		modelAndView.setViewName("index.html");
		return modelAndView;	
	}
	@GetMapping("/cube")
	public ModelAndView cube(@RequestParam("num")int num)
	{
		int cube=this.restTemplate.getForObject("http://cube:8082/cube/"+num,int.class);
		ModelAndView modelAndView = new ModelAndView("cube");
		modelAndView.addObject("response","Cube of " + num +": " + cube);
		modelAndView.setViewName("index.html");
		return modelAndView;
	}
	@GetMapping("/fibonacci")
	public ModelAndView fibonacci(@RequestParam("num")int num)
	{
		int fibonacci=this.restTemplate.getForObject("http://fibonacci:8083/fibonacci/"+num,int.class);
		ModelAndView modelAndView = new ModelAndView("fibonacci");
		modelAndView.addObject("response","Fibonacci of " + num +": " +  fibonacci);
		modelAndView.setViewName("index.html");
		return modelAndView;
	}
	@GetMapping("/metrics")
	public ModelAndView metrics()
	{
		String metrics=this.restTemplate.getForObject("http://metrics:8084/metrics",String.class);
		ModelAndView modelAndView = new ModelAndView("metrics");
		modelAndView.addObject("response","Metrics: " +  metrics);
		modelAndView.setViewName("index.html");
		return modelAndView;	
	}
}
