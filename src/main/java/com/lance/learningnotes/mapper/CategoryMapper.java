package com.lance.learningnotes.mapper;

import com.lance.learningnotes.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> list(Integer userId);

}
