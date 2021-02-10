package com.example.wj.controller;

import com.example.wj.pojo.AdminMenu;
import com.example.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Autowired AdminMenuService adminMenuService;

    @GetMapping("api/menu")
    @ResponseBody
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }
}
