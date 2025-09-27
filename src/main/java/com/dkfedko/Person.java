package com.dkfedko;

import com.dkfedko.anotation.Inject;
import com.dkfedko.anotation.Run;

public class Person {

    String name;
    String salary;
    @Inject
    int age;
    double weight;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age").append(age);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
    public String getName() {
        return name;
    }
    private double getWeight() {
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
}
