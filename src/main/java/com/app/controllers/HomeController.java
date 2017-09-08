/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controllers;

import com.app.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kkannao
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) {
        System.out.println("inside index ");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.0.117:9080/BillMavenApp/StudentWS/get";
        Student std = restTemplate.getForObject(url, Student.class);

        if (std != null) {
            System.out.println("name = " + std.getName());
            System.out.println("city = " + std.getCity());
            System.out.println("age = " + std.getRollNo());
        }

        map.put("student", std);
        return "home";
    }

}
