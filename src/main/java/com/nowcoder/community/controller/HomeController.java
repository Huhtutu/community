package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HomeController {

    @Resource
    private DiscussPostService discussPostService;

    @Resource
    private UserService userService;

    /**
     *
     * @param model
     * @param pageInfo
     * @return
     */
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String indexPage(Model model , PageInfo pageInfo) {
        pageInfo.setRows(discussPostService.findDiscussPostRows(0));
        pageInfo.setPath("/index");
        List<DiscussPost> postList = discussPostService.findDiscussPosts(0, pageInfo.getOffset(), pageInfo.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (postList != null) {
            for (DiscussPost post : postList) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        //log.info("查询帖子信息:{}"+postList);
        return "index";
    }
}
