package com.example.newcoder01.controller;

import com.example.newcoder01.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alphaController")
public class AlphaController {
    @Autowired
    @Qualifier("alphaService")
    private AlphaService alphaService;
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "hello,spring boot.";
    }
    @RequestMapping("/find")
    @ResponseBody
    public String executeSelect(){
        System.out.println("执行了控制层的方法...");
        return alphaService.executeSelect();

    }

    @RequestMapping("/rehead")
    public void rehead(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
        //返回响应体
        try {
            response.setContentType("text/html;charset=utf8");
            PrintWriter writer = response.getWriter();
            String code = request.getParameter("code");
            writer.print("<h1>刺激战场</h1>"+code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/retpage",method = RequestMethod.GET)
    @ResponseBody
    public String retpage(
            @RequestParam(name = "current",required = false,defaultValue = "1")int current,
            @RequestParam(name = "limit",required = false,defaultValue = "5")int limit
    ){
        System.out.println(current);
        System.out.println(limit);
        return "当前页："+current+",数据项："+limit;
    }

    @RequestMapping(path = "/retpage/{i}",method = RequestMethod.GET)
    @ResponseBody
    public String retpagei(@PathVariable(required=false)int i){
        System.out.println(i);
        return String.format("第%d页",i);
    }

    @RequestMapping(path = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public String toLogin(
            @RequestParam(name = "name",required = false,defaultValue = "null")String name,
            @RequestParam(name = "password",required = false,defaultValue = "null")String password
    ){
        return name+":"+password;
    }

    @RequestMapping(value = "/getSalary",method = RequestMethod.GET)
    public ModelAndView getSalary(HttpServletRequest request){
        System.out.println(request.getServletPath()+"/demo/main.html");
        ModelAndView model = new ModelAndView();
        model.addObject("name","张三");
        model.addObject("salary",2000);
        model.setViewName("/demo/main");
        return model;
    }

    @RequestMapping("/getSal")
    @ResponseBody
    public Map<String,Object> getsal(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","小王");
        map.put("age",18);
        map.put("sal",5000);

        return map;
    }

    @RequestMapping("/getSall")
    @ResponseBody
    public List<Map<String,Object>> getSall(){
        List<Map<String,Object>> maps = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","小王");
        map.put("age",18);
        map.put("sal",5000);
        maps.add(map);

        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","小赵");
        map1.put("age",25);
        map1.put("sal",7000);
        maps.add(map1);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","小林");
        map2.put("age",23);
        map2.put("sal",15000);
        maps.add(map2);

        return maps;
    }
}
