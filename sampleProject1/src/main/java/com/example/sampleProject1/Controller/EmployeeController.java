package com.example.sampleProject1.Controller;
import com.example.sampleProject1.Model.Employee;
import com.example.sampleProject1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @DeleteMapping
    public void deleteEmployeeById(@RequestParam int id){employeeService.deleteEmployeeById(id);}
    @DeleteMapping("/deleteAll")
    public String deleteAllEmployees(){return employeeService.deleteAllEmployees();}
    @PutMapping
    public Employee updateEmployee(@RequestParam int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
}
