package com.lance.learningnotes.service;

import com.lance.learningnotes.entity.Words;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
public interface WordsService extends IService<Words> {

    void insert(Words words);
}
