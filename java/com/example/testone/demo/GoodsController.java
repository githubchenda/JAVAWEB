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
public class GoodsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/edigoods", method = RequestMethod.GET)
    public String edigoodsdata(Model model, HttpServletRequest request, HttpServletResponse response){
        String goodsid=request.getParameter("goodsid");
        String goodsname=request.getParameter("goodsname");
        String goodsprice=request.getParameter("goodsprice");
        String stock=request.getParameter("stock");
        String goodsdescribe=request.getParameter("goodsdescribe");
        String goodsclass=request.getParameter("goodsclass");
        model.addAttribute("goodsid",goodsid);
        model.addAttribute("goodsname",goodsname);
        model.addAttribute("goodsprice",goodsprice);
        model.addAttribute("stock",stock);
        model.addAttribute("goodsdescribe",goodsdescribe);
        model.addAttribute("goodsclass",goodsclass);
        System.out.println(goodsid);
        return "editgoods";
    }


    @RequestMapping(value = "/updategoodsinfo", method = RequestMethod.GET)
    public String updatedata(Model model, HttpServletRequest request, HttpServletResponse response){
        String updategoodsid=request.getParameter("updategoodsid");
        String updategoodsname=request.getParameter("updategoodsname");
        String updategoodsprice=request.getParameter("updategoodsprice");
        String updatestock=request.getParameter("updatestock");
        String updategoodsdescribe=request.getParameter("updategoodsdescribe");
        String updategoodsclass=request.getParameter("updategoodsclass");

        String sql = "UPDATE goods SET goodsname=?,goodsprice=?,stock=?,goodsdescribe=?,goodsclass=? WHERE goodsid=?;";
        int i = jdbcTemplate.update(sql, updategoodsname,updategoodsprice,updatestock,updategoodsdescribe, updategoodsclass, updategoodsid);
        System.out.println("更新数据库goods影响的行数: " + i);
        model.addAttribute("fgoodsid",updategoodsid);
        return "updategoods";
    }

    @RequestMapping(value = "/delgoods", method = RequestMethod.GET)
    public String deledata(Model model, HttpServletRequest request, HttpServletResponse response){
        String goodsid=request.getParameter("goodsid");
        String sql = "DELETE FROM goods WHERE goodsid=?;";
        int i = jdbcTemplate.update(sql, goodsid);
        System.out.println("影响的行数: " + i);

        model.addAttribute("goodsid",goodsid);
        return "deletegoods";
    }


    @RequestMapping(value = "/addgoodsinfo", method = RequestMethod.GET)
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
