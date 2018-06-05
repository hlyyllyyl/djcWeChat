package com.decisioncustom.service.impl;

import com.decisioncustom.mapper.TUserMapper;
import com.decisioncustom.domain.TUser;
import com.decisioncustom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class UserServiceImpl extends ICrudServiceImpl<TUser,Long> implements IUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<TUser> getAllUser() {
      List<TUser> users = userMapper.getAllUserItems();
        return users;
    }

    @Override
    public List<TUser> getAllTeachers() {
        List<TUser> theachers  = userMapper.getAllTeacherItems();
        return theachers;
    }

}
