/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controllers.webservices;

import com.app.entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kkannao
 */
@RestController
@RequestMapping("/StudentWS")
public class StudentWS {

    private static List<Student> tempStudents;

    public StudentWS() {
        if (tempStudents == null) {
            tempStudents = new ArrayList<Student>();
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent() {
        System.out.println("inside getStudent ");
        return new Student(1, "Kartik", "Wardha");
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {
        System.out.println("inside getAllStudents ");
        System.out.println("size = " + tempStudents.size());
        return new ResponseEntity<List<Student>>(tempStudents, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String addStudent(@RequestBody Student std) {
        System.out.println("inside addStudent");
        tempStudents.add(std);
        return "Success";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String editStudent(@RequestBody Student std) {
        System.out.println("inside editStudent");
        for (int i = 0; i < tempStudents.size(); i++) {
            if (tempStudents.get(i).getRollNo() == std.getRollNo()) {
                tempStudents.set(i, std);
                break;
            }
        }
        return "Success";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String delete(@PathVariable("id") int id) {
        System.out.println("inside StudentWS/delete");
        String msg = null;
        Student tempStd = new Student();
        tempStd.setRollNo(id);

        for (Student std : tempStudents) {
            if (std.getRollNo() == tempStd.getRollNo()) {
                tempStudents.remove(std);
                msg = "Success";
                break;
            } else {
                msg = "No Data Found";
            }
        }
        return msg;
    }

}
