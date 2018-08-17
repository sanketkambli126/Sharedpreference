package com.example.sanke.sharedpreference;

public class Employee {
    private int id;
    private String name;
    private String lastname;

    public Employee(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                "";
    }
}
