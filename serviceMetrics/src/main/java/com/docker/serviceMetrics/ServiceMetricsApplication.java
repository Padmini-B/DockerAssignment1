package com.docker.serviceMetrics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin
@RestController
public class ServiceMetricsApplication {
	@GetMapping(value="/metrics")
	public String getMessage() {
		String url="jdbc:mysql://localhost:3306/docker_db";
        String user="root";
        String password="paddu@18";
        String metrics = "";
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            String q1="select avg(metric) from square";
            String q2="select avg(metric) from qube";
            String q3="select avg(metric) from fibonacci";
            ResultSet rs=st.executeQuery(q1);
            while(rs.next())
            {
            	metrics= "Square Function: " + rs.getDouble(1) + "ms";
            }
            ResultSet rs2=st.executeQuery(q2);
            while(rs2.next())
            {
            	metrics=metrics + ", Cube Function: " + rs2.getDouble(1) + "ms";
            }
            ResultSet rs3=st.executeQuery(q3);
            while(rs3.next())
            {
            	metrics=metrics + ", Fibonacci Function: " + rs3.getDouble(1) + "ms";
            }            
		}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(metrics);
		return metrics;
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceMetricsApplication.class, args);
	}

}
