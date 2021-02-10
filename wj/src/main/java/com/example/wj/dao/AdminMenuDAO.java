package com.example.wj.dao;

import com.example.wj.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminMenuDAO extends JpaRepository<AdminMenu,Integer> {
    List<AdminMenu> findAllByParentId(int parentId);
    List<AdminMenu> findAllById(List<Integer> menuIds);
}
