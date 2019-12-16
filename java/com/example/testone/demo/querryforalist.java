package com.example.testone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class querryforalist {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/show8", method = RequestMethod.GET)
    public Object getuser() {

        String sql = "SELECT mobile FROM user WHERE id = ?";

        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);


        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        /*for (Map<String, Object> map : list) {
            System.out.println(map);
        }*/
        Object userr= list.get(2);
        System.out.println(userr);

        return list.get(2);
    }

    /*public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("uname","jack");
        model.addAttribute("password","a15639878");
        System.out.println(getuser());
        return "show1";
    }*/


}

