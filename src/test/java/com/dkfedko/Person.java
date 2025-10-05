package com.dkfedko;

import com.dkfedko.anotation.Inject;
import com.dkfedko.anotation.Run;

public class Person {

    private String name;
    double salary;
    @Inject
    int age;
    private double weight;
    private double overtimeRate;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name =").append(name);
        sb.append(", salary =").append(salary);
        sb.append(", age ").append(age);
        sb.append(", weight = ").append(weight);
        sb.append(", payWithOverTime =").append(salary);
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
    public double getSalary() {
        return salary;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    @Run
    public final double calculateOvertimes(int days, double rate, double overTimeRate) {
        double payCheck;
        if (days<=21){
            return days*rate;
        }else{
            int overTimeDays = days - 21;
            payCheck =  (21*rate)+(overTimeDays*rate*overTimeRate);
        }
        this.salary = payCheck;
        return payCheck;
    }
}
