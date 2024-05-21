package server.Demo.Service;

import java.util.List;

import server.Demo.Model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    

}
