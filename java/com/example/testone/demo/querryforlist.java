package com.example.testone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class querryforlist {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/out03", method=RequestMethod.GET)
    public String index() {

        String sql = "SELECT mobile FROM user WHERE id = ?";

        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);


    List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user where password=?", "123");
    for (Map<String, Object> map : list) {
        System.out.println(map);
 }

        return "Hello " + mobile+list;
    }
}

