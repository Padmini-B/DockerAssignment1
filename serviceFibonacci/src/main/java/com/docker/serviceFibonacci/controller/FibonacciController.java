package com.docker.serviceFibonacci.controller;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.docker.serviceFibonacci.entity.*;
import com.docker.serviceFibonacci.repo.FibonacciRepo;

@CrossOrigin
@RestController
public class FibonacciController {
	@Autowired
	private FibonacciRepo fibonaccirepo;
	
	@GetMapping(value="/fibonacci/{num}")
	public int getMessage(@PathVariable("num") int num) {
		LocalTime metric_start = LocalTime.now();
		int fibonacci=0,n1=0,n2=1,i,metric;
		for(i=2;i<num;i++)
		{
			fibonacci=n1+n2;
			n1=n2;
			n2=fibonacci;
		}
		LocalTime metric_end = LocalTime.now();
		Duration duration= Duration.between(metric_start,metric_end);
		metric=  (int) duration.toMillis();
		Fibonacci f=new Fibonacci();
		f.setMetric(metric);		
		System.out.println(metric);		
		fibonaccirepo.save(f);		
		if(num==1)
			return n1;
		else if(num==2)
			return n2;
		else
			return fibonacci;
	}
}
