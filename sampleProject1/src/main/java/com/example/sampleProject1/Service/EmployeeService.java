package com.example.sampleProject1.Service;
import com.example.sampleProject1.Model.Employee;
import com.example.sampleProject1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }
    public void deleteEmployeeById(int id) {repository.deleteById(id);}
    public String deleteAllEmployees(){repository.deleteAll();return "all Employees deleted!";}
    public Employee updateEmployee(int id,Employee employee) {

        Employee temp = repository.findById(id).orElse(new Employee());
        temp.setId(employee.getId());
        temp.setName(employee.getName());
        temp.setAge(employee.getAge());
        temp.setSalary(employee.getSalary());
        repository.save(temp);
        return temp;
    }
}
