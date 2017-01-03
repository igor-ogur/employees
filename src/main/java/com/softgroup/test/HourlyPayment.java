package com.softgroup.test;

public class HourlyPayment extends Payment {

    private double hourlyRate;

    public HourlyPayment(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculateAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
