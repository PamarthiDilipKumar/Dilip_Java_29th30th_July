package com.example.demo.dto;

public class EmployeeDto {
    private Long id;
    private String name;
    private String designation;
    private EmployeeAddressDto employeeAddressDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmployeeAddressDto getEmployeeAddressDto() {
        return employeeAddressDto;
    }

    public void setEmployeeAddressDto(EmployeeAddressDto employeeAddressDto) {
        this.employeeAddressDto = employeeAddressDto;
    }
}
