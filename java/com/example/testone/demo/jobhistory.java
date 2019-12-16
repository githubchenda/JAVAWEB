package com.example.testone.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class jobhistory {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/jobh", method = RequestMethod.GET)
    public void show(Model model,HttpServletRequest request, HttpServletResponse response){

        List<Job> joblist=new ArrayList<Job>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : list) {
            Job jobs=new Job();
            jobs.setName(map.get("name").toString());
            jobs.setNumber(map.get("number").toString());
            jobs.setDate(map.get("data").toString());
            joblist.add(jobs);
            System.out.println(map.get("name").toString());
        }


        model.addAttribute("joblist",joblist);

    }
}
