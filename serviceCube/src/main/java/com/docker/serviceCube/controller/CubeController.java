package com.docker.serviceCube.controller;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.docker.serviceCube.entity.*;
import com.docker.serviceCube.repo.CubeRepo;

@CrossOrigin
@RestController
public class CubeController {
	@Autowired
	private CubeRepo cuberepo;
	
	@GetMapping(value="/cube/{num}")
	public int getMessage(@PathVariable("num") int num) {
		LocalTime metric_start = LocalTime.now();
		int cube,metric;
		cube= (num*num*num);
		LocalTime metric_end = LocalTime.now();
		Duration duration= Duration.between(metric_start,metric_end);
		metric=  (int) duration.toMillis();
		Cube c=new Cube();
		c.setMetric(metric);		
		System.out.println(metric);		
		cuberepo.save(c);		
		return cube;
	}
}
