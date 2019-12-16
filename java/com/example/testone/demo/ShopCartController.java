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
public class ShopCartController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/showallshopcart", method = RequestMethod.GET)
    public String weifahuo(Model model,HttpServletRequest request, HttpServletResponse response){
        List<ShopCart> shopcartlist=new ArrayList<ShopCart>();
        List<Map<String, Object>> shcartlist = jdbcTemplate.queryForList("select * from shoppingcart");
        //List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : shcartlist) {
            ShopCart ffshopcart=new ShopCart();
            ffshopcart.setShcartid(map.get("shcartid").toString());
            ffshopcart.setShgoodsid(map.get("shgoodsid").toString());
            ffshopcart.setShgoodsname(map.get("shgoodsname").toString());
            ffshopcart.setCustomername(map.get("customername").toString());
            ffshopcart.setShgoodsprice(map.get("shgoodsprice").toString());
            ffshopcart.setShgoodsdescribe(map.get("shgoodsdescribe").toString());
            shopcartlist.add(ffshopcart);
            System.out.println(map);
        }
        model.addAttribute("shopcartlist",shopcartlist);
        return "shoppingcartlist";
    }

    @RequestMapping(value = "/deleteshopcartitem", method = RequestMethod.GET)
    public String deledata(Model model, HttpServletRequest request, HttpServletResponse response){
        String shcartid=request.getParameter("shcartid");
        String sql = "DELETE FROM shoppingcart WHERE shcartid=?;";
        int i = jdbcTemplate.update(sql, shcartid);
        System.out.println("影响的行数: " + i);
        model.addAttribute("shcartid",shcartid);
        return "deleteshoppingitem";
    }


}
