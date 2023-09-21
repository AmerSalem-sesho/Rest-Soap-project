package com.example.sampleProject1;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.admin.AdminCommand;
import com.aerospike.client.policy.WritePolicy;
import com.example.sampleProject1.Repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SampleProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleProject1Application.class, args);
	}

}
