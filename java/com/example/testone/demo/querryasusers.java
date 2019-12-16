package com.example.testone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class querryasusers{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/show9", method = RequestMethod.GET)
    public String getuser(Model model) {

        /*String sql = "SELECT mobile FROM user WHERE id = ?";


        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        for (Map<String, Object> map : list) {
            System.out.println(map);
            System.out.println(map.get("id"));
        }
        System.out.println(list);
        Users fuser=new Users();
        fuser.setNickname(list.get(2).get("nickname").toString());
        fuser.setId(list.get(2).get("id").toString());
        fuser.setId(list.get(2).get("mobile").toString());
        fuser.setId(list.get(2).get("password").toString());
        fuser.setId(list.get(2).get("role").toString());
        model.addAttribute("fuser",fuser);*/

        model.addAttribute("uid","123456789");
        model.addAttribute("uname","jack");
        model.addAttribute("password","a15639878");
        return "show11";

    }

      /* String sqll="select  from user";
        RowMapper<Users> rowMapper=new BeanPropertyRowMapper<Users>(Users.class);
        List<Users> users= jdbcTemplate.query(sqll, rowMapper);

        for (Users user : users) {
           System.out.println(user);
             }
        return "hello"+users+mobile;
    }*/

    /*public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("uname","jack");
        model.addAttribute("password","a15639878");
        System.out.println(getuser());
        return "show1";
    }*/


}

