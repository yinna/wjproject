package com.example.wj.service;

import com.example.wj.dao.AdminRoleMenuDAO;
import com.example.wj.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdminRoleMenuService {
    @Autowired AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDAO.findAllByRid(rid);
    }

    public List<AdminRoleMenu> findAllByRid(List<Integer> rids){
        System.out.println(adminRoleMenuDAO.findAllByRid(rids));
        return adminRoleMenuDAO.findAllByRid(rids);
    }
}
