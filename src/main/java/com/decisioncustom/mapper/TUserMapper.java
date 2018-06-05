package com.decisioncustom.mapper;


import com.decisioncustom.domain.TUser;

import java.util.List;

public interface TUserMapper extends CrudMapper<TUser> {
    /**
     * 查询所有用户
     * @return
     */
    List<TUser> getAllUserItems();

    /**
     * 查询所有老师
     * @return
     */
    List<TUser> getAllTeacherItems();
}
