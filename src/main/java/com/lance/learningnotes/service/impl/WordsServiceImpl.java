package com.lance.learningnotes.service.impl;

import com.lance.learningnotes.common.UserInfoContext;
import com.lance.learningnotes.entity.Words;
import com.lance.learningnotes.mapper.WordsMapper;
import com.lance.learningnotes.service.WordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
@Service
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements WordsService {

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Words words) {
        String userId = UserInfoContext.getUser().getId().toString();
        words.setUserId(Integer.parseInt(userId));
        wordsMapper.insert(words);
    }
}
