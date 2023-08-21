package com.mikolaj.springboot.cruddemo.service;

import com.mikolaj.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
