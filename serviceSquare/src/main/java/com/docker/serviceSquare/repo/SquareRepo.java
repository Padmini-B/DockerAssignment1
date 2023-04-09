package com.docker.serviceSquare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.serviceSquare.entity.Square;

public interface SquareRepo extends JpaRepository <Square, Integer>{
	
}
