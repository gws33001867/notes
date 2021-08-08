package com.lance.learningnotes.common;

import com.lance.learningnotes.entity.Users;

public class UserInfoContext {
    private static ThreadLocal<Users> userInfo = new ThreadLocal<Users>();

    public UserInfoContext() {
    }

    public static Users getUser(){
        return (Users) userInfo.get();
    }

    public static void setUser(Users user){
        userInfo.set(user);
    }
    public static void remove(){
        userInfo.remove();
    }
}
