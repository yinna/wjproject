package com.example.wj.service;

import com.example.wj.dao.AdminMenuDAO;
import com.example.wj.pojo.AdminMenu;
import com.example.wj.pojo.AdminRoleMenu;
import com.example.wj.pojo.AdminUserRole;
import com.example.wj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired AdminMenuDAO adminMenuDAO;
    @Autowired UserService userService;
    @Autowired AdminUserRoleService adminUserRoleService;
    @Autowired AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getMenusByCurrentUser(){
        // 从数据库中获取当前用户
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipals().toString();
        System.out.println("rrrr");
        System.out.println("菜单接口这里"+username);
        User user = userService.getByName(username);

        //获取当前用户对应的所有角色的 id 列表
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        System.out.println("用户ID是："+user.getId());
        System.out.println(rids);

        // 查询出这些角色对应的所有菜单项
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        //  distinct 查询多角色下菜单重叠的情况
        List<AdminMenu> menus = adminMenuDAO.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        //处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    // 处理菜单树，遍历菜单项，根据每一项的 id 查询该项出所有的子项，并放进 children 属性，剔除掉所有子项，只保留第一层的父项
    public void handleMenus(List<AdminMenu> menus){
        for (AdminMenu menu : menus){
            List<AdminMenu> children = getAllByParentId(menu.getId());
            menu.setChildren(children);
        }
        Iterator<AdminMenu> iterator = menus.iterator();
        while(iterator.hasNext()){
            AdminMenu adminMenu = iterator.next();
            if (adminMenu.getParentId() != 0){
                iterator.remove();
            }
        }
    }

    public List<AdminMenu> getAllByParentId(int panrentId){
        return adminMenuDAO.findAllByParentId(panrentId);
    }
}
