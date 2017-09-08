/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kkannao
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    private int rollNo;
    private int age;
    private String name;
    private String city;

    public Student(int rollNo, String name, String city) {
        this.rollNo = rollNo;
        this.name = name;
        this.city = city;
    }
    

    public Student(){}
    
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    

}
