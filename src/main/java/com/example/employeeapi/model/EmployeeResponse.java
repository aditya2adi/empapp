package com.example.employeeapi.model;

public record EmployeeResponse(
        String id,
        String firstName,
        String lastName,
        String department
) {
}
