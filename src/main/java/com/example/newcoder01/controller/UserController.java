package com.example.newcoder01.controller;

import com.example.newcoder01.entity.User;
import com.example.newcoder01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;

@Controller
public class UserController {
    @Value("${user.activation_code}")
    private String activation_code;

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUid/{id}")
    @ResponseBody
    public User getUById(@PathVariable(required=false)int id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public void addItem(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String header_url = request.getParameter("header_url");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(0);
        user.setType(1);
        user.setActivation_code(activation_code);
        user.setHeader_url("D:\\1.jpg");
        user.setSalt("49f10");
        user.setCreate_time(new Date());
        System.out.println(header_url);
        System.out.println(user);
        userService.addItem(user);
        try {
            response.getWriter().print("<script>history.back(-1)</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/update/{cmd}")
    @ResponseBody
    public String update(
            HttpServletRequest request,HttpServletResponse response,
            @PathVariable(required = true)String cmd,@RequestParam(name="id")int id,@RequestParam(name="value")String value){
        int result = 0;
        switch (cmd){
            case "password":
                result = userService.updatePassword(id, value);break;
        }
        if(result != 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
