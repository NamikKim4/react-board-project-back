package com.example.ch8_5.mapper;


import com.example.ch8_5.to.UserInfoTo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
interface UserInfoMapper {

    public abstract void insertUser(UserInfoTo userInfoTo) throws Exception;

    public abstract UserInfoTo selectUser(String userEmail)throws Exception;

    public abstract void updateUser(UserInfoTo userInfoTo)throws Exception;

    public abstract void deleteUser(String email)throws Exception;


}
