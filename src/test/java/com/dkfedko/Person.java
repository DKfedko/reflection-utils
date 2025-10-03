package com.dkfedko;

import com.dkfedko.anotation.Inject;
import com.dkfedko.anotation.Run;

public class Person {

    String name;
    String salary;
    @Inject
    int age;
    private double weight;
    private final double overtimeRate = 1.48;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name =").append(name);
        sb.append(", salary =").append(salary);
        sb.append(", age ").append(age);
        sb.append(", weight = ").append(weight);
        sb.append(", overtimePay =").append(overtimeRate);
        sb.append('}');
        return sb.toString();
    }
    private String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    @Run
    public int getAge() {
        return age;
    }
    @Run
    public String getSalary() {
        return salary;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(String salary){
        this.salary=salary;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    @Run
    private final double calculateOvertimes(int days, double rate, double overTimeRate) {
        if (days<=21){
            return days*rate;
        }else{
            int overTimeDays = days - 21;
            return (21*rate)+(overTimeDays*rate*overTimeRate);
        }
    }
}
