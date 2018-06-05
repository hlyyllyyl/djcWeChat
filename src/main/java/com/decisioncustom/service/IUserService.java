package com.decisioncustom.service;


import com.decisioncustom.domain.TUser;

import java.util.List;

public interface IUserService extends ICrudService<TUser,Long> {
    TUser getUserById(Long userId);
    /**
     * 查询所有用户
     * @return
     */
    List<TUser> getAllUser();

    /**
     * 查询所有老师
     * @return
     */
    List<TUser> getAllTeachers();
}
