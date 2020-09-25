package com.radis.demo.model;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    private String id;
    private String name;
    private String salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
