package com.guner.employee.repository;

import com.guner.employee.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getByFirstNameAndLastName(String firstname, String lastName);

    List<Employee> getByFirstNameContains(String firstName);

    List<Employee> getByLastNameContains(String lastName);

    List<Employee> findAll(Sort sort);
}
