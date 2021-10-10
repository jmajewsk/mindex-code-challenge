package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.reporting_structure.DirectReportingGraph;
import com.mindex.challenge.data.reporting_structure.Node;
import com.mindex.challenge.data.reporting_structure.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure reporting(@PathVariable String id) {
        LOG.debug("Reading Report Structure [{}]", id);
        Employee startingEmployee = read(id);
        DirectReportingGraph directReportingGraph = new DirectReportingGraph(this);
        directReportingGraph.createFromParent(new Node<>(startingEmployee));
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(startingEmployee);
        reportingStructure.setNumberOfReports(directReportingGraph.getSize() - 1);
        return reportingStructure;
    }
}
