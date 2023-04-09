package com.docker.serviceFibonacci.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.serviceFibonacci.entity.Fibonacci;

public interface FibonacciRepo extends JpaRepository <Fibonacci, Integer>{

}
