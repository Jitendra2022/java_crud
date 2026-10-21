package com.example.crud.service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Employee create(Employee employee) {
        employee.setId(null);
        return repository.save(employee);
    }

    // READ ALL
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return repository.findAll();
    }

    // READ ONE
    @Transactional(readOnly = true)
    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee id " + id + " nahi mila"));
    }

    // READ by department
    @Transactional(readOnly = true)
    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartmentIgnoreCase(department);
    }

    // UPDATE
    public Employee update(Long id, Employee updated) {
        Employee existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setSalary(updated.getSalary());
        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        Employee existing = getById(id);
        repository.delete(existing);
    }
}
