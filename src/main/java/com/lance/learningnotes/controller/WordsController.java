package com.lance.learningnotes.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lance.learningnotes.common.UserInfoContext;
import com.lance.learningnotes.entity.Category;
import com.lance.learningnotes.entity.Words;
import com.lance.learningnotes.service.WordsService;
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
@RequestMapping("/words")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @PostMapping("save")
    public void insert(@RequestBody Words words){
        wordsService.insert(words);
    }
    @PostMapping("list")
    public List<Words> list(){
        QueryWrapper<Words> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",UserInfoContext.getUser().getId());
        return wordsService.list(queryWrapper);
    }
    @PostMapping("update")
    public boolean update(@RequestBody Words words){
        return wordsService.updateById(words);
    }
    @PostMapping("delete")
    public boolean delete(@RequestBody Words words){
        QueryWrapper<Words> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",UserInfoContext.getUser().getId())
                .eq("id",words.getId());
        return wordsService.remove(queryWrapper);
    }


}

