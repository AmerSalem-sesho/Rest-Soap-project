package com.example.sampleProject1.Repository;
import com.example.sampleProject1.Model.Employee;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface EmployeeRepository extends AerospikeRepository<Employee, Integer> {}
