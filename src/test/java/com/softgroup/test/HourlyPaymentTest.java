package com.softgroup.test;


import org.junit.Assert;
import org.junit.Test;

public class HourlyPaymentTest {
    @Test
    public void testCalculateAverageMonthlySalary() throws Exception {
        double hourlyRate = 20;
        HourlyPayment hourlyPayment = new HourlyPayment(hourlyRate);
        double expectedResult = 3328.0;
        Assert.assertEquals(expectedResult, hourlyPayment.calculateAverageMonthlySalary(), 0.001);
    }
}
