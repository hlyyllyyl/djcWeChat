package com.decisioncustom.service;


import com.decisioncustom.query.BaseQuery;
import com.decisioncustom.utils.page.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface ICrudService<T, ID extends Serializable> {

    T createSelective(T resource);

    T create(T resource);

    T update(T resource);

    T updateSelective(T resource);

    void delete(Serializable id);

    T findOne(ID id);

    List<T> findAll();

    PageInfo<T> getPageInfo(BaseQuery query);
}
