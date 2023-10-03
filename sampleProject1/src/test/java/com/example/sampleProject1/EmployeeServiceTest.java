package com.example.sampleProject1;

import com.example.sampleProject1.Model.Employee;
import com.example.sampleProject1.Repository.EmployeeRepository;
import com.example.sampleProject1.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;
    @Mock
    EmployeeRepository employeeRepository;
    @Test
    public void saveEmployeeTest()
    {
        Employee employee = new Employee(1,"Amer salem", 23, 20000);

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertEquals(employee, savedEmployee);
    }

    @Test
    public void findEmployeeById()
    {
        int id = 1;

        Employee employee = new Employee(id, "john", 23, 2500);

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));

        Employee retrievedEmployee = employeeService.getEmployeeById(id);

        assertEquals(employee, retrievedEmployee);

    }
    @Test
    public void findEmployeeByIdNotFound()
    {
        int id = 1;

        Employee employee = new Employee(id, "john", 23, 2500);

        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Employee retrievedEmployee = employeeService.getEmployeeById(id);

        assertNotEquals(employee, retrievedEmployee);

    }

    @Test
    public void deleteEmployeeById()
    {
        int id = 1;

        employeeService.deleteEmployeeById(id);

        verify(employeeRepository, times(1)).deleteById(id);

    }

    @Test
    public void deleteAllEmployeesTest()
    {
        String message = "all Employees deleted!";
        String response = employeeService.deleteAllEmployees();

        verify(employeeRepository, times(1)).deleteAll();

        assertEquals(message, response);
    }

    @Test
    void testUpdateEmployee()
    {
        int id = 1;
        Employee existingEmployee = new Employee(id, "John Doe", 30, 50000.0);

        when(employeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));

        Employee result = employeeService.updateEmployee(id, existingEmployee);

        assertNotNull(result);
        assertEquals(existingEmployee, result);
    }
}
