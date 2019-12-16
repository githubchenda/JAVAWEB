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
public class querryforjoblist{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/alljoblist1", method = RequestMethod.GET)
    public String show(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Job> jobslist=new ArrayList<Job>();
        List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : jlist) {
            Job ffjob=new Job();
            ffjob.setName(map.get("name").toString());
            ffjob.setNumber(map.get("number").toString());
            ffjob.setDate(map.get("Date").toString());
            System.out.println(map.get("name").toString());
            jobslist.add(ffjob);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("jobslist",jobslist);
        return "alljob";
    }
}
