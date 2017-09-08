/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controllers;

import com.app.entity.Student;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kkannao
 */
@Controller
@RequestMapping("/students")
public class StudentsController {

    @RequestMapping("/all")
    public String allStudents(ModelMap map) {
        System.out.println("inside allStudents ");

        map.put("student", new Student());
        map.put("lstStudent", getStudents());
        map.put("saveAction", "/students/save");
        return "showAllStudents";
    }

    @RequestMapping("/form")
    public String getForm(ModelMap map) {
        System.out.println("inside getForm");
        map.put("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
        System.out.println("inside saveStudent ");
        System.out.println("std = " + std);
        if (std != null) {
            RestTemplate template = new RestTemplate();
            String url = "http://192.168.0.117:9080/BillMavenApp/StudentWS/save";
            System.out.println("url = " + url);
            ResponseEntity<String> msg = template.postForEntity(url, std, String.class);
            System.out.println("msg = " + msg.getBody());
        }
        return "redirect:/students/all";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap map) {
        System.out.println("inside edit ");
        List<Student> tempStudents = getStudents();
        Student tempStudent = new Student();
        tempStudent.setRollNo(id);
        for (Student std : tempStudents) {
            if (std.getRollNo() == tempStudent.getRollNo()) {
                tempStudent = std;
                break;
            }
        }
        map.put("student", tempStudent);
        map.put("lstStudent", tempStudents);
        map.put("saveAction", "/students/editSave");
        return "showAllStudents";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        System.out.println("inside delete ");
        System.out.println("id = " + id);
        RestTemplate template = new RestTemplate();
        String url = "http://192.168.0.117:9080/BillMavenApp/StudentWS/delete/" + id;
        String msg = template.getForObject(url, String.class);
        System.out.println("msg = " + msg);
        return "redirect:/students/all";
    }

    @RequestMapping("/editSave")
    public String editSave(@ModelAttribute("student") Student std, ModelMap map) {
        System.out.println("inside editSave ");
        RestTemplate template = new RestTemplate();
        String url = "http://192.168.0.117:9080/BillMavenApp/StudentWS/editStudent";
        System.out.println("url = " + url);
        ResponseEntity<String> msg = template.postForEntity(url, std, String.class);   
        System.out.println("msg = " + msg.getBody());
        return "redirect:/students/all";
    }

    public List<Student> getStudents() {
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Student>> lstStudent = new ParameterizedTypeReference<List<Student>>() {
        };

        String url = "http://192.168.0.117:9080/BillMavenApp/StudentWS/getAllStudents";
        System.out.println("url = " + url);

        ResponseEntity<List<Student>> studentResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, lstStudent);
        System.out.println("studentResponseEntity = " + studentResponseEntity.getBody());
        return studentResponseEntity.getBody();
    }

}
