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
public class GoodsOrderController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/nodeliverygoodsordershow", method = RequestMethod.GET)
    public String weifahuo(Model model,HttpServletRequest request, HttpServletResponse response){
        List<GoodsOrder> goodsorderlist=new ArrayList<GoodsOrder>();
        List<Map<String, Object>> golist = jdbcTemplate.queryForList("select * from goodsorder where orderstate=?","未发货");
        //List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : golist) {
            GoodsOrder ffgoodsorder=new GoodsOrder();
            ffgoodsorder.setOrderid(map.get("orderid").toString());
            ffgoodsorder.setGoodsname(map.get("goodsname").toString());
            ffgoodsorder.setOrderprice(map.get("orderprice").toString());
            ffgoodsorder.setCustomername(map.get("customername").toString());
            ffgoodsorder.setMobile(map.get("mobile").toString());
            ffgoodsorder.setAddress(map.get("address").toString());
            ffgoodsorder.setMail(map.get("mail").toString());
            ffgoodsorder.setOrdertime(map.get("ordertime").toString());
            ffgoodsorder.setDeliverytime(map.get("deliverytime").toString());
            ffgoodsorder.setOrderstate(map.get("orderstate").toString());
            System.out.println(map.get("orderid").toString());
            goodsorderlist.add(ffgoodsorder);
            System.out.println(map);
        }
        model.addAttribute("goodsorderlist",goodsorderlist);
        return "nodeliverygoodsorder";
    }


    @RequestMapping(value = "/deliverygoodsordershow", method = RequestMethod.GET)
    public String deliverygoodsorder(Model model,HttpServletRequest request, HttpServletResponse response){
        List<GoodsOrder> goodsorderlist=new ArrayList<GoodsOrder>();
        List<Map<String, Object>> golist = jdbcTemplate.queryForList("select * from goodsorder where orderstate=?","已发货");
        //List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : golist) {
            GoodsOrder ffgoodsorder=new GoodsOrder();
            ffgoodsorder.setOrderid(map.get("orderid").toString());
            ffgoodsorder.setGoodsname(map.get("goodsname").toString());
            ffgoodsorder.setOrderprice(map.get("orderprice").toString());
            ffgoodsorder.setCustomername(map.get("customername").toString());
            ffgoodsorder.setMobile(map.get("mobile").toString());
            ffgoodsorder.setAddress(map.get("address").toString());
            ffgoodsorder.setMail(map.get("mail").toString());
            ffgoodsorder.setOrdertime(map.get("ordertime").toString());
            ffgoodsorder.setDeliverytime(map.get("deliverytime").toString());
            ffgoodsorder.setOrderstate(map.get("orderstate").toString());
            System.out.println(map.get("orderid").toString());
            goodsorderlist.add(ffgoodsorder);
            System.out.println(map);
        }
        model.addAttribute("goodsorderlist",goodsorderlist);
        return "deliverygoodsorder";
    }





    @RequestMapping(value = "/delgoodsorder", method = RequestMethod.GET)
    public String deledata(Model model, HttpServletRequest request, HttpServletResponse response){
        String orderid=request.getParameter("orderid");
        String sql = "DELETE FROM goodsorder WHERE orderid=?;";
        int i = jdbcTemplate.update(sql, orderid);
        System.out.println("影响的行数: " + i);

        model.addAttribute("orderid",orderid);
        return "deletegoodsorder";
    }

    @RequestMapping(value = "/delivegoodsorder", method = RequestMethod.GET)
    public String delivery(Model model, HttpServletRequest request, HttpServletResponse response){
        String orderid=request.getParameter("orderid");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String deliverydate=df.format(new Date());
        String sql = "UPDATE goodsorder SET orderstate=?,deliverytime=? WHERE orderid=?;";
        int i = jdbcTemplate.update(sql, "已发货",deliverydate,orderid );
        System.out.println("影响的行数: " + i);


        model.addAttribute("orderid",orderid);
        return "deliverysuccess";
    }


    @RequestMapping(value = "/addgoodsinfo1", method = RequestMethod.GET)
    public String addsoldorder(Model model, HttpServletRequest request, HttpServletResponse response){

        String goodsname=request.getParameter("goodsname");
        String goodsprice=request.getParameter("goodsprice");
        String stock=request.getParameter("stock");
        String goodsdescribe=request.getParameter("goodsdescribe");
        String goodsclass=request.getParameter("goodsclass");

        String sql="select goodsid from goods where goodsid=(select max(goodsid) from goods)";
        String result=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;
        System.out.println("结果"+result);
        System.out.println("数据是"+res);
        String sqlud = "INSERT INTO goods VALUES (?, ?, ?,?,?,?);";
        int i = jdbcTemplate.update(sqlud, res,goodsname,goodsprice,stock,goodsdescribe,goodsclass);
        System.out.println("影响的行数: " + i);
        model.addAttribute("id","10");
        //return "workerlisttemp.html";
        return "addgoodssuccess.html";
    }
}
