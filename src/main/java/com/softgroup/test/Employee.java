package com.softgroup.test;

import java.io.Serializable;

public class Employee implements Serializable{
    private String name;
    private int id;
    private Payment payment;

    private static int idCounter = 0;

    public Employee(String name, Payment payment) {
        this.name = name;
        this.payment = payment;
        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", average monthly salary=" + payment.calculateAverageMonthlySalary() +
                '}';
    }
}
