package com.example.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wj.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
