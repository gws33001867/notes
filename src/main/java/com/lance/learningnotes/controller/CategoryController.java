package com.lance.learningnotes.controller;


import com.lance.learningnotes.entity.Category;
import com.lance.learningnotes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public List<Category> list(){
        return categoryService.list();
    }


}

