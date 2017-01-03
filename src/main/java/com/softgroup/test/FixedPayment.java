package com.softgroup.test;

public class FixedPayment extends Payment {

    private double fixedMonthlyPayment;

    public FixedPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    public double calculateAverageMonthlySalary() {
        return getFixedMonthlyPayment();
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }
}
