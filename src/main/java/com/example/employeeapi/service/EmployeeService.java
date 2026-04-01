package com.example.employeeapi.service;

import com.example.employeeapi.model.EmployeeRequest;
import com.example.employeeapi.model.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeService {

    private final Map<String, EmployeeResponse> employees = new ConcurrentHashMap<>();

    public EmployeeResponse create(EmployeeRequest request) {
        String id = UUID.randomUUID().toString();
        EmployeeResponse employee = new EmployeeResponse(
                id,
                request.firstName(),
                request.lastName(),
                request.department()
        );
        employees.put(id, employee);
        return employee;
    }

    public List<EmployeeResponse> findAll() {
        return new ArrayList<>(employees.values());
    }

    public EmployeeResponse update(String id, EmployeeRequest request) {
        if (!employees.containsKey(id)) {
            throw new NoSuchElementException("Employee not found with id: " + id);
        }

        EmployeeResponse updated = new EmployeeResponse(
                id,
                request.firstName(),
                request.lastName(),
                request.department()
        );
        employees.put(id, updated);
        return updated;
    }

    public void delete(String id) {
        EmployeeResponse removed = employees.remove(id);
        if (removed == null) {
            throw new NoSuchElementException("Employee not found with id: " + id);
        }
    }
}
