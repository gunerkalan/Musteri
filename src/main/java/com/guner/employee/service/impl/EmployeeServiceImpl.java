package com.guner.employee.service.impl;

import com.guner.employee.dto.EmployeeDto;
import com.guner.employee.entity.Employee;
import com.guner.employee.repository.EmployeeRepository;
import com.guner.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto save(EmployeeDto employee) {

        Employee employeeCheck = employeeRepository.getByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());

        if(employeeCheck != null){
            throw new IllegalArgumentException("FirstName and LastName is already exists");
        }

        Employee emp = modelMapper.map(employee, Employee.class);
        emp = employeeRepository.save(emp);
        return employee;
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee empl = employeeRepository.getOne(id);
        return modelMapper.map(empl, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getByFirstNameAndLastName(String firstName, String lastName) {
        Employee empl = employeeRepository.getByFirstNameAndLastName(firstName,lastName);
        return modelMapper.map(empl, EmployeeDto.class);
    }


    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> data = employeeRepository.findAll();
        return Arrays.asList(modelMapper.map(data,EmployeeDto[].class));
    }

    @Override
    public List<EmployeeDto> getByFirstNameContains(String firstName) {
        List<Employee> data = employeeRepository.getByFirstNameContains(firstName);
        return Arrays.asList(modelMapper.map(data,EmployeeDto[].class));
    }

    @Override
    public List<EmployeeDto> getByLastNameContains(String lastName) {
        List<Employee> data = employeeRepository.getByFirstNameContains(lastName);
        return Arrays.asList(modelMapper.map(data,EmployeeDto[].class));
    }

    @Override
    public Boolean delete(Long id) {
       employeeRepository.deleteById(id);
       return Boolean.TRUE;
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employee) {
        Employee employeeDb = employeeRepository.getOne(id);
        if(employeeDb==null) {
            throw new IllegalArgumentException("Employee Does Not Exist ID:" + id);
        }

        employeeDb.setFirstName(employee.getFirstName());
        employeeDb.setLastName(employee.getLastName());
        employeeDb.setEmailId(employee.getEmailId());
        employeeDb.setPhoneNumber(employee.getPhoneNumber());
        employeeDb.setIsActive(Boolean.TRUE);

        employeeRepository.save(employeeDb);
        return modelMapper.map(employeeDb, EmployeeDto.class);
    }

    @Override
    public EmployeeDto softDelete(Long id, EmployeeDto employee) {

        Employee employeeDb = employeeRepository.getOne(id);

        if(employeeDb==null) {
            throw new IllegalArgumentException("Employee Does Not Exist ID:" + id);
        }

        employeeDb.setIsActive(Boolean.FALSE);
        employeeRepository.save(employeeDb);
        return modelMapper.map(employeeDb, EmployeeDto.class);

    }
}
