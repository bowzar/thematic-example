package com.yulintu.thematic.example.employee.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

//    @GetMapping("/echo/{msg}")
//    @ResponseBody
//    public String echo(@PathVariable String msg) {
//
//        return String.format("收到消息: %s", msg);
//    }
}
