package com.example.testone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class update {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/updatedemo", method=RequestMethod.GET)
    public String index() {

        String sql = "SELECT mobile FROM user WHERE id = ?";

        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);


        String sqlud = "UPDATE user SET nickname=? WHERE id=?;";
        int i = jdbcTemplate.update(sqlud, "abd1",  1);
        System.out.println("影响的行数: " + i);


        return "Hello " + mobile;
    }
}
