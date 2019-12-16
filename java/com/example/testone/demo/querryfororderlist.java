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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class querryfororderlist{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/allorderlist1", method = RequestMethod.GET)
    public String show(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Order> orderslist=new ArrayList<Order>();
        List<Map<String, Object>> ordlist = jdbcTemplate.queryForList("select * from soldorder");
        for (Map<String, Object> map : ordlist) {
            Order fforder=new Order();
            fforder.setOrderid(map.get("orderid").toString());
            fforder.setGoodsname(map.get("goodsname").toString());
            fforder.setGoodsnum(map.get("goodsnum").toString());
            fforder.setOrderdate(map.get("orderdate").toString());
            System.out.println(map.get("goodsname").toString());
            orderslist.add(fforder);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("orderslist",orderslist);
        return "allorder";
    }


    @RequestMapping(value = "/addsoldorder14", method = RequestMethod.GET)
    public String addusers(Model model, HttpServletRequest request, HttpServletResponse response){
        String userpassword=request.getParameter("password");
        String usernickname=request.getParameter("nickname");
        String usermobile=request.getParameter("mobile");

        String sql="select orderid from soldorder where orderid=(select max(orderid) from soldorder)";
        String result=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;
        System.out.println("结果"+result);
        System.out.println("数据是"+res);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());
        String sqlud = "INSERT INTO soldorder VALUES (?, ?, ?,?,?);";
        int i = jdbcTemplate.update(sqlud, res,userpassword,usernickname,usermobile,date);
        System.out.println("影响的行数: " + i);
        model.addAttribute("id","10");
        //return "workerlisttemp.html";
       return "addordersuccess.html";
    }


}
