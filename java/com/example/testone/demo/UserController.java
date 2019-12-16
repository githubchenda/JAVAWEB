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
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String name;
    String password;
    @RequestMapping(value = "/managerlogin", method = RequestMethod.GET)
    public String show(Model model,HttpServletRequest request, HttpServletResponse response){

         name=request.getParameter("name");
         password=request.getParameter("password");
        String workersql = "SELECT password FROM user WHERE nickname = ?";
        String workerpassword= (String)jdbcTemplate.queryForObject(
                workersql, new Object[] {name }, String.class);
        String userrolesql = "SELECT role FROM user WHERE nickname = ?";
        String userrole= (String)jdbcTemplate.queryForObject(
                userrolesql, new Object[] {name }, String.class);


        List<Users> userslist=new ArrayList<Users>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        for (Map<String, Object> map : list) {
            Users ffuser=new Users();
            ffuser.setNickname(map.get("nickname").toString());
            ffuser.setId(map.get("id").toString());
            ffuser.setMobile(map.get("mobile").toString());
            ffuser.setPassword(map.get("password").toString());
            ffuser.setRole(map.get("role").toString());
            ffuser.setMail(map.get("mail").toString());
            ffuser.setAddress(map.get("address").toString());
            userslist.add(ffuser);
        }


        model.addAttribute("userslist",userslist);

        model.addAttribute("uname",name);


        if(workerpassword.equals(password)&&userrole.equals("管理员")) {
    //return "show2.html";
    // return "manager";
            return "manager.html";
    //return "testfrag.html";
}
        if(workerpassword.equals(password)&&userrole.equals("客人")) {
                //return "show2.html";
                // return "manager";
                return "customer.html";
                //return "testfrag.html";
                }
                //return "redirect:/login.html";
                // return "redirect:/tab/list.html";

                return "redirect:/login.html";
                }


    @RequestMapping(value = "/showalluserlist", method = RequestMethod.GET)
    public String showalluser(Model model,HttpServletRequest request, HttpServletResponse response){

        List<Users> userslist=new ArrayList<Users>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        for (Map<String, Object> map : list) {
            Users ffuser=new Users();
            ffuser.setNickname(map.get("nickname").toString());
            ffuser.setId(map.get("id").toString());
            ffuser.setMobile(map.get("mobile").toString());
            ffuser.setPassword(map.get("password").toString());
            ffuser.setRole(map.get("role").toString());
            ffuser.setMail(map.get("mail").toString());
            ffuser.setAddress(map.get("address").toString());
            userslist.add(ffuser);
        }

        model.addAttribute("userslist",userslist);

        model.addAttribute("uname",name);



            return "alluser.html";

    }


    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deledata(Model model, HttpServletRequest request, HttpServletResponse response){
        String userid=request.getParameter("id");
        String sql = "DELETE FROM user WHERE id=?;";
        int i = jdbcTemplate.update(sql, userid);
        System.out.println("影响的行数: " + i);
        System.out.println(userid);
        model.addAttribute("id",userid);
        model.addAttribute("usernames",name);
        model.addAttribute("userpasswords",password);
        System.out.println("del"+name);
        System.out.println("del"+password);
        return "deleteworker";
    }

    @RequestMapping(value = "/edi", method = RequestMethod.GET)
    public String edidata(Model model, HttpServletRequest request, HttpServletResponse response){
        String userid=request.getParameter("id");
        String username=request.getParameter("name");
        String userpassword=request.getParameter("password");
        String usermobile=request.getParameter("mobile");
        String userrole=request.getParameter("role");
        String useraddress=request.getParameter("address");
        String usermail=request.getParameter("mail");

       /* String sqlud = "UPDATE user SET nickname=? WHERE id=?;";
        int i = jdbcTemplate.update(sqlud, "abd1",  1);
        System.out.println("影响的行数: " + i);*/
       /* String sql = "DELETE FROM user WHERE id=?;";
        int i = jdbcTemplate.update(sql, userid);
        System.out.println("影响的行数: " + i);
        System.out.println(userid);
        model.addAttribute("id",userid);
        model.addAttribute("usernames",name);
        model.addAttribute("userpasswords",password);
        System.out.println("del"+name);
        System.out.println("del"+password);*/
        model.addAttribute("userid",userid);
        model.addAttribute("username",username);
        model.addAttribute("userpassword",userpassword);
        model.addAttribute("usermobile",usermobile);
        model.addAttribute("userrole",userrole);
        model.addAttribute("useraddress",useraddress);
        model.addAttribute("usermail",usermail);
        System.out.println(useraddress);
        return "editworker";
        //return "redirect:/updateuser.html";
    }


    @RequestMapping(value = "/updateworkerinfo", method = RequestMethod.GET)
    public String updatedata(Model model, HttpServletRequest request, HttpServletResponse response){
        String userid=request.getParameter("updateid");
        String username=request.getParameter("updatename");
        String userpassword=request.getParameter("updatepassword");
        String usermobile=request.getParameter("updatemobile");
        String userrole=request.getParameter("updaterole");
        String useraddress=request.getParameter("updateaddress");
        String usermail=request.getParameter("updatemail");
        String sql = "UPDATE user SET nickname=?,password=?,mobile=?,role=?,address=?,mail=? WHERE id=?;";
        int i = jdbcTemplate.update(sql, username,userpassword,usermobile,userrole,useraddress,usermail,userid);
        System.out.println("更新数据库影响的行数: " + i);
        System.out.println(userrole);
        model.addAttribute("fuserid",userid);
        model.addAttribute("fusername",username);
        model.addAttribute("fuserpassword",userpassword);
        model.addAttribute("fusermobile",usermobile);
        model.addAttribute("fuserrole",userrole);
        System.out.println(userid);
        return "updateworker";
    }

    @RequestMapping(value = "/addusers", method = RequestMethod.GET)
    public String addusers(Model model, HttpServletRequest request, HttpServletResponse response){
        String userpassword=request.getParameter("password");
        String usernickname=request.getParameter("nickname");
        String usermobile=request.getParameter("mobile");
        String userrole=request.getParameter("role");
        String useraddress=request.getParameter("address");
        String usermail=request.getParameter("mail");

        String sql="select id from user where id=(select max(id) from user)";
        String result=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;
         System.out.println("结果"+result);
         System.out.println("数据是"+res);

        String sqlud = "INSERT INTO user VALUES (?, ?, ?,?,?,?,?);";
        int i = jdbcTemplate.update(sqlud, res,usernickname,usermobile,userpassword,userrole,usermail,useraddress);
        System.out.println("影响的行数: " + i);
        model.addAttribute("id","10");
        //return "workerlisttemp.html";
        return "addusersuccess.html";
    }

    @RequestMapping(value = "/alljoblist", method = RequestMethod.GET)
    public String showalljob(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Job> jobslist=new ArrayList<Job>();
        List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : jlist) {
            Job ffjob=new Job();
            ffjob.setName(map.get("name").toString());
            ffjob.setNumber(map.get("number").toString());
            ffjob.setDate(map.get("Date").toString());
            System.out.println(map.get("name").toString());
            jobslist.add(ffjob);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("jobslist",jobslist);
        return "alljob";
    }

    @RequestMapping(value = "/allorderlist", method = RequestMethod.GET)
    public String allorderlist(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Order> orderslist=new ArrayList<Order>();
        List<Map<String, Object>> ordlist = jdbcTemplate.queryForList("select * from soldorder");
        for (Map<String, Object> map : ordlist) {
            Order fforder=new Order();
            fforder.setOrderid(map.get("orderid").toString());
            fforder.setGoodsname(map.get("goodsname").toString());
            fforder.setGoodsnum(map.get("goodsnum").toString());
            fforder.setGoodsprice(map.get("goodsprice").toString());
            fforder.setOrderdate(map.get("orderdate").toString());
            System.out.println(map.get("goodsname").toString());
            orderslist.add(fforder);
            System.out.println(map);
        }
        model.addAttribute("uid","123456789");
        model.addAttribute("orderslist",orderslist);
        return "allorder";
    }

    @RequestMapping(value = "/addsoldorder", method = RequestMethod.GET)
    public String addsoldorder(Model model, HttpServletRequest request, HttpServletResponse response){
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



    //工人部分代码

    @RequestMapping(value = "/jobshow", method = RequestMethod.GET)
    public String workermain(Model model,HttpServletRequest request, HttpServletResponse response){
        List<Job> jobslist=new ArrayList<Job>();
        List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job where name=?",name);
        //List<Map<String, Object>> jlist = jdbcTemplate.queryForList("select * from job");
        for (Map<String, Object> map : jlist) {
            Job ffjob=new Job();
            ffjob.setName(map.get("name").toString());
            ffjob.setNumber(map.get("number").toString());
            ffjob.setDate(map.get("Date").toString());
            System.out.println(map.get("name").toString());
            jobslist.add(ffjob);
            System.out.println(map);
        }
        model.addAttribute("workername",name);
        model.addAttribute("jobslist",jobslist);
        return "worker";
    }

    @RequestMapping(value = "/addtodayjobse", method = RequestMethod.GET)
    public String addtest(HttpServletRequest request, HttpServletResponse response, Model model){


        String number=request.getParameter("number");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());
        String sql = "INSERT INTO job VALUES (?, ?, ?);";
        int i = jdbcTemplate.update(sql, name,number,date);
        System.out.println("影响的行数: " + i);


        System.out.println(date);
        System.out.println(name);
        System.out.println(number);

        return "addtodayjobsuccess";
    }


    //客人部分的代码
    @RequestMapping(value = "/edipersonalinfo", method = RequestMethod.GET)
    public String edipersonaldata(Model model, HttpServletRequest request, HttpServletResponse response){
        String mobilesql = "SELECT mobile FROM user WHERE nickname= ?";
        String mailsql = "SELECT mail FROM user WHERE nickname= ?";
        String addresssql = "SELECT address FROM user WHERE nickname= ?";


        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(mobilesql, new Object[] {name}, String.class);
        String mail = (String)jdbcTemplate.queryForObject(mailsql, new Object[] {name}, String.class);
        String address = (String)jdbcTemplate.queryForObject(addresssql, new Object[] {name}, String.class);
        System.out.println("电话手机："+mobile);
        model.addAttribute("usermobile",mobile);
        model.addAttribute("usermail",mail);
        model.addAttribute("useraddress",address);

        return "personalinfo";
    }


    @RequestMapping(value = "/updatepersonalinfo", method = RequestMethod.GET)
    public String updatepersonaldata(Model model, HttpServletRequest request, HttpServletResponse response){
        String usermobile=request.getParameter("updatemobile");
        String useraddress=request.getParameter("updateaddress");
        String usermail=request.getParameter("updatemail");
        String sql = "UPDATE user SET mobile=?,address=?,mail=? WHERE nickname=?;";
        int i = jdbcTemplate.update(sql,usermobile,useraddress,usermail,name);
        System.out.println("更新数据库影响的行数: " + i);

        model.addAttribute("fusermobile",usermobile);

        System.out.println(useraddress);
        return "updateperinfo";
    }





    @RequestMapping(value = "/personalgoodsordershow", method = RequestMethod.GET)
    public String deliverygoodsorder(Model model,HttpServletRequest request, HttpServletResponse response){
        List<GoodsOrder> goodsorderlist=new ArrayList<GoodsOrder>();
        List<Map<String, Object>> golist = jdbcTemplate.queryForList("select * from goodsorder where customername=?",name);
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
        return "personalgoodsorder";
    }

    @RequestMapping(value = "/showmyshopcart", method = RequestMethod.GET)
    public String showmyshopcartlist(Model model,HttpServletRequest request, HttpServletResponse response){
        List<ShopCart> shopcartlist=new ArrayList<ShopCart>();
        List<Map<String, Object>> shcartlist = jdbcTemplate.queryForList("select * from shoppingcart  where customername=?", name);
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




    @RequestMapping(value = "/allgoodslist", method = RequestMethod.GET)
    public String showallgoodslist(Model model,HttpServletRequest request, HttpServletResponse response){
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

    @RequestMapping(value = "/shipinshengxianlist", method = RequestMethod.GET)
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

    @RequestMapping(value = "/bangongwenjiaolist", method = RequestMethod.GET)
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

    @RequestMapping(value = "/jiayongdianqilist", method = RequestMethod.GET)
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

    @RequestMapping(value = "/shumadianzilist", method = RequestMethod.GET)
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



    @RequestMapping(value = "/addtomycart", method = RequestMethod.GET)
    public String addtomycartfun(HttpServletRequest request, HttpServletResponse response, Model model){
        String shgoodsid=request.getParameter("shgoodsid");
        String shgoodsname=request.getParameter("shgoodsname");
        String shgoodsprice=request.getParameter("shgoodsprice");
        String shgoodsdescribe=request.getParameter("shgoodsdescribe");
        String shcartidsql="select shcartid from shoppingcart where shcartid=(select max(shcartid) from shoppingcart)";
        String result=(String)jdbcTemplate.queryForObject(shcartidsql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;


        String sql = "INSERT INTO shoppingcart VALUES (?, ?, ?,?,?,?);";
        int i = jdbcTemplate.update(sql, res,shgoodsid,shgoodsname,shgoodsprice,shgoodsdescribe,name);

        model.addAttribute("shgoodsname",shgoodsname);
        System.out.println("影响的行数: " + i);

        System.out.println(shgoodsdescribe);
        return "addtomycartsuccess";
    }


    @RequestMapping(value = "/buildorder", method = RequestMethod.GET)
    public String buildorderfun(HttpServletRequest request, HttpServletResponse response, Model model){

        String shgoodsname=request.getParameter("shgoodsname");
        String shgoodsprice=request.getParameter("shgoodsprice");
        String customername=request.getParameter("customername");


        String orderidsql="select orderid from goodsorder where orderid=(select max(orderid) from goodsorder)";
        String result=(String)jdbcTemplate.queryForObject(orderidsql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;


        String mobilesql = "SELECT mobile FROM user WHERE nickname= ?";
        String mailsql = "SELECT mail FROM user WHERE nickname= ?";
        String addresssql = "SELECT address FROM user WHERE nickname= ?";
        String shcartid=request.getParameter("shcartid");


        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(mobilesql, new Object[] {customername}, String.class);
        String mail = (String)jdbcTemplate.queryForObject(mailsql, new Object[] {customername}, String.class);
        String address = (String)jdbcTemplate.queryForObject(addresssql, new Object[] {customername}, String.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String ordertime=df.format(new Date());
        String sql = "INSERT INTO goodsorder VALUES (?, ?, ?,?,?,?,?,?,?,?);";
        int i = jdbcTemplate.update(sql, res,shgoodsname,shgoodsprice,customername,mobile,address,mail,ordertime,"未发货","未发货");

        model.addAttribute("shgoodsname",shgoodsname);
        System.out.println("影响的行数: " + i);



        String delsql = "DELETE FROM shoppingcart WHERE shcartid=?;";
        int ii = jdbcTemplate.update(delsql, shcartid);
        System.out.println("删除购物车影响的行数: " + ii);
        model.addAttribute("shcartid",shcartid);

        return "addtoshopcartsuccess";
    }


    @RequestMapping(value = "/userregister", method = RequestMethod.GET)
    public String userregisterfun(Model model, HttpServletRequest request, HttpServletResponse response){
        String userpassword=request.getParameter("password");
        String usernickname=request.getParameter("nickname");
        String usermobile=request.getParameter("mobile");
        String userrole=request.getParameter("role");
        String useraddress=request.getParameter("address");
        String usermail=request.getParameter("mail");

        String sql="select id from user where id=(select max(id) from user)";
        String result=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
        Integer res=Integer.valueOf(result)+1;
        System.out.println("结果"+result);
        System.out.println("数据是"+res);

        String sqlud = "INSERT INTO user VALUES (?, ?, ?,?,?,?,?);";
        int i = jdbcTemplate.update(sqlud, res,usernickname,usermobile,userpassword,"客人",usermail,useraddress);
        System.out.println("影响的行数: " + i);
        model.addAttribute("id","10");
        //return "workerlisttemp.html";
        return "registersuccess.html";
    }


}
