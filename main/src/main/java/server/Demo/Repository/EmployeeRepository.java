package server.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.Demo.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
