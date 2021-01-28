package com.guner.employee.service;

import com.guner.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employee);

    EmployeeDto getById(Long id);

    EmployeeDto getByFirstNameAndLastName(String firstName, String lastName);

    List<EmployeeDto> getAll();

    List<EmployeeDto> getByFirstNameContains(String firstName);

    List<EmployeeDto> getByLastNameContains(String lastName);

    Boolean delete(Long id);

    EmployeeDto update(Long id, EmployeeDto employee);

    EmployeeDto softDelete(Long id, EmployeeDto employee);

}
