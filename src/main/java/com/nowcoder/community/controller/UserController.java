package com.nowcoder.community.controller;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.impl.UserServiceImpl;
import com.nowcoder.community.util.CommunityUtil;
import com.nowcoder.community.util.HostHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${community.path.upload}")
    private String uploadPath;

    @Value("${community.path.domain}")
    private String doMain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Resource
    private UserServiceImpl userService;

    @Resource
    private HostHolder hostHolder;

    @RequestMapping(path = "setting",method = RequestMethod.GET)
    public String getSettingPage(){
        return "/site/setting";
    }

    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    public String uploadHeader(MultipartFile headerImg, Model model){
        if(headerImg == null){
            model.addAttribute("error","您没有上传图片!");
            return "/site/setting";
        }

        String filename = headerImg.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if(suffix == null){
            model.addAttribute("error","文件格式不正确!");
            return "/site/setting";
        }

        //生成随机文件名
        filename = CommunityUtil.genertUUID() + suffix;
        //文件存放路径
        File dest = new File(uploadPath +"/" + filename);
        try {
            headerImg.transferTo(dest);
        } catch (IOException e) {
           logger.error("上传失败"+e.getMessage());
           throw new RuntimeException("上传失败!服务器异常!",e);
        }

        //更新当前用户头像的路径
        User user = (User) hostHolder.getUser();
        String headerUrl = doMain + contextPath + "/user/header" +filename;
        userService.updateHeader(user.getId(),headerUrl);
        return "redirect:/index";
    }

    @RequestMapping(path = "/header/{filename}",method = RequestMethod.GET)
    public void getHeader(@PathVariable("filename") String filename, HttpServletResponse response){
        //服务器存放路径
        filename = uploadPath + "/" + filename;
        //文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //响应图片
        response.setContentType("image" + suffix);
        try (
                OutputStream os = response.getOutputStream();
                FileInputStream inputStream = new FileInputStream(filename);
        ) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            logger.error("读取头像失败" + e.getMessage());
        }
    }
}
