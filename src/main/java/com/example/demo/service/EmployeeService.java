package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeAddressDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeAddress;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;




@Service
public class EmployeeService {
    private final ModelMapper modelMapper=new ModelMapper();

    @Autowired
    private EmployeeDao employeeDao;

//    private EmployeeDto convertToDto(Employee employee) {
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setId(employee.getId());
//        employeeDto.setName(employee.getName());
//        employeeDto.setDesignation(employee.getDesignation());
//        employeeDto.setEmployeeAddressDto(convertToDto(employee.getEmployeeAddress()));
//        return employeeDto;
//    }
//
//    private Employee convertToEntity(EmployeeDto employeeDto) {
//        Employee employee = new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setName(employeeDto.getName());
//        employee.setDesignation(employeeDto.getDesignation());
//        employee.setEmployeeAddress(convertToEntity(employeeDto.getEmployeeAddressDto()));
//        return employee;
//    }
//
//    private EmployeeAddressDto convertToDto(EmployeeAddress employeeAddress) {
//        EmployeeAddressDto employeeAddressDto = new EmployeeAddressDto();
//        employeeAddressDto.setStreet(employeeAddress.getStreet());
//        employeeAddressDto.setCity(employeeAddress.getCity());
//        employeeAddressDto.setState(employeeAddress.getState());
//        employeeAddressDto.setPin(employeeAddress.getPin());
//        return employeeAddressDto;
//    }
//
//    private EmployeeAddress convertToEntity(EmployeeAddressDto employeeAddressDto) {
//        EmployeeAddress employeeAddress = new EmployeeAddress();
//        employeeAddress.setStreet(employeeAddressDto.getStreet());
//        employeeAddress.setCity(employeeAddressDto.getCity());
//        employeeAddress.setState(employeeAddressDto.getState());
//        employeeAddress.setPin(employeeAddressDto.getPin());
//        return employeeAddress;
//    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        //BeanUtils.copyProperties(employee, employeeDto);
        modelMapper.map(employee,employeeDto);

        EmployeeAddressDto employeeAddressDto = new EmployeeAddressDto();
       // BeanUtils.copyProperties(employee.getEmployeeAddress(), employeeAddressDto);
        modelMapper.map(employee.getEmployeeAddress(),employeeAddressDto);
        employeeDto.setEmployeeAddressDto(employeeAddressDto);

        return employeeDto;
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        //BeanUtils.copyProperties(employeeDto, employee);
        modelMapper.map(employeeDto,employee);

        EmployeeAddress employeeAddress = new EmployeeAddress();
       // BeanUtils.copyProperties(employeeDto.getEmployeeAddressDto(), employeeAddress);
        modelMapper.map(employeeDto.getEmployeeAddressDto(),employeeAddress);
        employee.setEmployeeAddress(employeeAddress);

        return employee;
    }


    public EmployeeDto addDetails(EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        Employee savedEmployee = employeeDao.save(employee);
        return convertToDto(savedEmployee);
    }

    public List<EmployeeDto> getAllDetails() {
        List<Employee> employeeList = employeeDao.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeDtoList.add(convertToDto(employee));
        }
        return employeeDtoList;
    }

    public EmployeeDto getDetailsById(Long id) {
        Employee employee = employeeDao.findById(id).orElseThrow();
        return convertToDto(employee);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        employee.setId(id);
        Employee updatedEmployee = employeeDao.save(employee);
        return convertToDto(updatedEmployee);
    }
}