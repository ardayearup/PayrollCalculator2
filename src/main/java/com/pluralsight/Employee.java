package com.pluralsight;

public class Employee
{
    private int employee_id;
    private String name;
    private double hours_worked;
    private double pay_rate;

    public Employee(int employee_id, String name, double hours_worked, double pay_rate)
    {
        this.employee_id = employee_id;
        this.name = name;
        this.hours_worked = hours_worked;
        this.pay_rate = pay_rate;
    }

    public double gross_pay() {
        return ( getHours_worked() * getPay_rate() );
    }


    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(double hours_worked) {
        this.hours_worked = hours_worked;
    }

    public double getPay_rate() {
        return pay_rate;
    }

    public void setPay_rate(double pay_rate) {
        this.pay_rate = pay_rate;
    }
}
