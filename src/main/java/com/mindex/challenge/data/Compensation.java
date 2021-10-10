package com.mindex.challenge.data;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Compensation {

    @Id
    private String compensationId;
    private Employee employee;
    private Double salary;
    private LocalDate effectiveDate;

    public Compensation() {
    }

    public String getCompensationId() {
        return compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
}
