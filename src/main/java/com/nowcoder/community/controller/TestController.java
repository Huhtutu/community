package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    @ResponseBody
    public String test()
    {
        return "hello 唔西迪西";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse resp){
        //获取请求数据
        System.out.println((req.getMethod()));
        System.out.println((req.getServletPath()));
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String element = enumeration.nextElement();
            String header = req.getHeader(element);
            System.out.println((element + " " + header));
        }

        System.out.println(req.getParameter("code"));

        //返回响应数据
        resp.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = resp.getWriter();
        ){
            writer.write("<h1>糊涂涂<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get请求
    //students
    @RequestMapping(path = ("/students"),method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "page",required = false,defaultValue = "15")int page){
        System.out.println("current-->"+current);
        System.out.println("page-->"+page);
        return "some Student";
    }

    //restful
    @RequestMapping(path = ("/student/{id}"),method = RequestMethod.GET)
    @ResponseBody
    public String aStudent(@PathVariable("id") int id){
        System.out.println("id-->"+id);
        return "a student!";
    }

    //设置ModelandView
    @RequestMapping(path = ("/person"))
    public ModelAndView getPerson()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","玛卡巴卡");
        modelAndView.addObject("age",10);
        modelAndView.setViewName("/test/view.html");
        return modelAndView;
    }

    //返回Json格式数据  单个对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp()
    {
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","Jack");
        emp.put("salary",6000.00);
        emp.put("no","s001");
        return  emp;
    }

    //返回Json格式数据  多个对象
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps()
    {
        List<Map<String,Object>> emps = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","Jack");
        emp.put("salary",6000.00);
        emp.put("no","s001");
        emps.add(emp);

        emp = new HashMap<>();
        emp.put("name","Sasa");
        emp.put("salary",5000.00);
        emp.put("no","s0012");
        emps.add(emp);

        emp = new HashMap<>();
        emp.put("name","Andy");
        emp.put("salary",7000.00);
        emp.put("no","s003");
        emps.add(emp);
        return  emps;
    }
}
