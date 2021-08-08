package com.lance.learningnotes.service;

import com.lance.learningnotes.entity.Register;
import com.lance.learningnotes.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lance shan
 * @since 2021-07-29
 */
public interface UsersService extends IService<Users> {

    boolean register(Register register);

}
