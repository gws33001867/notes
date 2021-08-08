package com.lance.learningnotes.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.lance.learningnotes.entity.Register;
import com.lance.learningnotes.entity.Users;
import com.lance.learningnotes.mapper.UsersMapper;
import com.lance.learningnotes.service.UsersService;
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
 * @since 2021-07-29
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(Register register) {
        String userName = register.getUserName();


        if(usersMapper.selectList(new QueryWrapper<Users>().eq("uname",userName)).size()>0){
            throw new RuntimeException("用户已存在");
        }
        Users users = new Users();
        users.setUname(userName);
        users.setPwd(register.getPassword());
        usersMapper.insert(users);
        return true;
    }
}
