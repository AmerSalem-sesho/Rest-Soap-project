package com.example.sampleProject1.Service;
import com.example.sampleProject1.Model.Employee;
import com.example.sampleProject1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //read employee from database
        Employee temp = repository.findById(id).get();
        //assign new values for the employee
        temp.setId(employee.getId());
        temp.setName(employee.getName());
        temp.setAge(employee.getAge());
        temp.setSalary(employee.getSalary());
        //then we update the employee using the update method
        return repository.save(temp);
    }
}
