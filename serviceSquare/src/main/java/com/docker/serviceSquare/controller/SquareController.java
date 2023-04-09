package com.docker.serviceSquare.controller;

import java.time.Duration;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.docker.serviceSquare.entity.*;
import com.docker.serviceSquare.repo.SquareRepo;

@CrossOrigin
@RestController
public class SquareController {
	@Autowired
	private SquareRepo squarerepo;
	
	@GetMapping(value="/square/{num}")
	public int getMessage(@PathVariable("num") int num) {
		LocalTime metric_start = LocalTime.now();
		int square,metric;
		square= (num*num);
		LocalTime metric_end = LocalTime.now();
		Duration duration= Duration.between(metric_start,metric_end);
		metric=  (int) duration.toMillis();
		Square s=new Square();
		s.setMetric(metric);		
		System.out.println(metric);		
		squarerepo.save(s);		
		return square;
	}
}
