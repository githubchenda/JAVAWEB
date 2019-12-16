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
public class querryforgoodslist{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/allgoodslist1", method = RequestMethod.GET)
    public String show(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Goods> goodslist=new ArrayList<Goods>();
        List<Map<String, Object>> glist = jdbcTemplate.queryForList("select * from goods");
        for (Map<String, Object> map : glist) {
            Goods ffgoods=new Goods();
            ffgoods.setGoodsid(map.get("goodsid").toString());
            ffgoods.setGoodsname(map.get("goodsname").toString());
            ffgoods.setGoodsprice(map.get("goodsprice").toString());
            ffgoods.setStock(map.get("stock").toString());
            ffgoods.setGoodsdescribe(map.get("goodsdescribe").toString());
            ffgoods.setGoodsclass(map.get("goodsclass").toString());
            goodslist.add(ffgoods);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("goodslist",goodslist);
        return "allgoods";
    }

    @RequestMapping(value = "/shipinshengxianlist1", method = RequestMethod.GET)
    public String showshipinshengxian(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Goods> goodslist=new ArrayList<Goods>();
        List<Map<String, Object>> glist = jdbcTemplate.queryForList("select * from goods where goodsclass=?","食品生鲜");
        for (Map<String, Object> map : glist) {
            Goods ffgoods=new Goods();
            ffgoods.setGoodsid(map.get("goodsid").toString());
            ffgoods.setGoodsname(map.get("goodsname").toString());
            ffgoods.setGoodsprice(map.get("goodsprice").toString());
            ffgoods.setStock(map.get("stock").toString());
            ffgoods.setGoodsdescribe(map.get("goodsdescribe").toString());
            ffgoods.setGoodsclass(map.get("goodsclass").toString());
            goodslist.add(ffgoods);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("goodslist",goodslist);
        return "shangpinfenlei";
    }

    @RequestMapping(value = "/bangongwenjiaolist1", method = RequestMethod.GET)
    public String showbangongwenjiaolist(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Goods> goodslist=new ArrayList<Goods>();
        List<Map<String, Object>> glist = jdbcTemplate.queryForList("select * from goods where goodsclass=?","办公文教");
        for (Map<String, Object> map : glist) {
            Goods ffgoods=new Goods();
            ffgoods.setGoodsid(map.get("goodsid").toString());
            ffgoods.setGoodsname(map.get("goodsname").toString());
            ffgoods.setGoodsprice(map.get("goodsprice").toString());
            ffgoods.setStock(map.get("stock").toString());
            ffgoods.setGoodsdescribe(map.get("goodsdescribe").toString());
            ffgoods.setGoodsclass(map.get("goodsclass").toString());
            goodslist.add(ffgoods);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("goodslist",goodslist);
        return "shangpinfenlei";
    }

    @RequestMapping(value = "/jiayongdianqilist1", method = RequestMethod.GET)
    public String showjiayongdianqilist(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Goods> goodslist=new ArrayList<Goods>();
        List<Map<String, Object>> glist = jdbcTemplate.queryForList("select * from goods where goodsclass=?","家用电器");
        for (Map<String, Object> map : glist) {
            Goods ffgoods=new Goods();
            ffgoods.setGoodsid(map.get("goodsid").toString());
            ffgoods.setGoodsname(map.get("goodsname").toString());
            ffgoods.setGoodsprice(map.get("goodsprice").toString());
            ffgoods.setStock(map.get("stock").toString());
            ffgoods.setGoodsdescribe(map.get("goodsdescribe").toString());
            ffgoods.setGoodsclass(map.get("goodsclass").toString());
            goodslist.add(ffgoods);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("goodslist",goodslist);
        return "shangpinfenlei";
    }

    @RequestMapping(value = "/shumadianzilist1", method = RequestMethod.GET)
    public String showshumadianzilist(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Goods> goodslist=new ArrayList<Goods>();
        List<Map<String, Object>> glist = jdbcTemplate.queryForList("select * from goods where goodsclass=?","数码电子");
        for (Map<String, Object> map : glist) {
            Goods ffgoods=new Goods();
            ffgoods.setGoodsid(map.get("goodsid").toString());
            ffgoods.setGoodsname(map.get("goodsname").toString());
            ffgoods.setGoodsprice(map.get("goodsprice").toString());
            ffgoods.setStock(map.get("stock").toString());
            ffgoods.setGoodsdescribe(map.get("goodsdescribe").toString());
            ffgoods.setGoodsclass(map.get("goodsclass").toString());
            goodslist.add(ffgoods);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("goodslist",goodslist);
        return "shangpinfenlei";
    }
}
