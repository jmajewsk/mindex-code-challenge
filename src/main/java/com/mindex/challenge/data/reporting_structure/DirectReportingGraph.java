package com.mindex.challenge.data.reporting_structure;

import com.mindex.challenge.controller.EmployeeController;
import com.mindex.challenge.data.Employee;

import java.util.ArrayList;
import java.util.List;

public class DirectReportingGraph extends DirectReportingDirectedGraph<Employee> {

    private final EmployeeController employeeService;

    public DirectReportingGraph(EmployeeController employeeController) {
        this.employeeService = employeeController;
    }

    @Override
    public List<Node<Employee>> getChildrenOfNode(Employee item) {
        List<Node<Employee>> employeeNodes = new ArrayList<>();
        if (item.getDirectReports() == null) {
            return employeeNodes;
        }
        for (Employee directReport : item.getDirectReports()) {
            Employee foundEmployee = this.employeeService.read(directReport.getEmployeeId());
            System.out.println(directReport.getEmployeeId());
            employeeNodes.add(new Node<>(foundEmployee));

        }
        return employeeNodes;
    }
}
