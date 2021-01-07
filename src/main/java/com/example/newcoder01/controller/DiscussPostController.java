package com.example.newcoder01.controller;

import com.example.newcoder01.entity.Discuss_post;
import com.example.newcoder01.entity.Page;
import com.example.newcoder01.entity.User;
import com.example.newcoder01.service.IDiscussPostService;
import com.example.newcoder01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DiscussPostController {
    @Autowired
    private IDiscussPostService discussPostService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/findDiscussPostByUid")
    @ResponseBody
    public List<Discuss_post> findDiscussPostByUid(HttpServletRequest request, HttpServletResponse response){
        int limit = Integer.parseInt(request.getParameter("limit"));
        int offset = Integer.parseInt(request.getParameter("offset"));
        String uid = request.getParameter("uid");
        return discussPostService.findByUid(uid,limit,offset);
    }

    @RequestMapping("/findDiscussPost")
    @ResponseBody
    public List<Discuss_post> findDiscussPost(HttpServletRequest request,HttpServletResponse response){
        int limit = Integer.parseInt(request.getParameter("limit"));
        int offset = Integer.parseInt(request.getParameter("offset"));
        String userId = request.getParameter("userId");
        return discussPostService.findDiscussPost(userId,limit,offset);
    }

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model, Page page){
        String userId = request.getParameter("userId");
        int rows = discussPostService.discussPostCount(userId);

        page.setRows(rows);
        page.setPath("/index?userId="+userId);

        List<Discuss_post> discussPosts = discussPostService.findDiscussPost(userId,page.getLimit(), page.getOffset());
        List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();
        if(discussPosts != null){
            for(Discuss_post discussPost:discussPosts){
                Map<String,Object> map = new HashMap<>();
                map.put("post",discussPost);
                int user_id = Integer.parseInt(discussPost.getUser_id());
                User user = userService.findById(user_id);
                map.put("user",user);
                mapList.add(map);
            }
        }
        model.addAttribute("discussPosts",mapList);
        return "/demo/index";
    }
}
