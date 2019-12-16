package com.example.testone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Insert {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/insert", method=RequestMethod.GET)
    public String index() {

        String sql = "SELECT mobile FROM user WHERE id = ?";

        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);


        String sqlud = "INSERT INTO user VALUES (?, ?, ?,?,?);";
        int i = jdbcTemplate.update(sqlud, 3,"abc3","15362356988","123456","user");
        System.out.println("影响的行数: " + i);


        return "Hello " + mobile;
    }
}

