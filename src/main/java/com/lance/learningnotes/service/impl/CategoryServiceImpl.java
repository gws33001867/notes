package com.lance.learningnotes.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lance.learningnotes.common.UserInfoContext;
import com.lance.learningnotes.entity.Category;
import com.lance.learningnotes.mapper.CategoryMapper;
import com.lance.learningnotes.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        Integer userId = UserInfoContext.getUser().getId();
        return categoryMapper.list(userId);
    }
}
