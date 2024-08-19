package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public EmployeeDto addDetails(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addDetails(employeeDto);
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAll() {
        return employeeService.getAllDetails();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        return employeeService.getDetailsById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateDetails(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

}
