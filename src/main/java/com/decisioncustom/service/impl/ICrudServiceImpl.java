package com.decisioncustom.service.impl;


import com.decisioncustom.mapper.CrudMapper;
import com.decisioncustom.query.BaseQuery;
import com.decisioncustom.service.ICrudService;
import com.decisioncustom.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class ICrudServiceImpl<T, ID extends Serializable> implements
        ICrudService<T, ID> {

    @Autowired
    CrudMapper<T> crudMapper;

    @Override
    @Transactional(readOnly = false)
    public T createSelective(T resource) {
        System.out.println("save;;;;;;;;;;;;;;;;;;;;");
        crudMapper.insertSelective(resource);
        return resource;
    }

    @Override
    @Transactional(readOnly = false)
    public T create(T resource) {
        crudMapper.insert(resource);
        return resource;
    }

    @Override
    @Transactional(readOnly = false)
    public T update(T resource) {
        crudMapper.updateByPrimaryKeySelective(resource);
        return resource;
    }

    @Override
    @Transactional(readOnly = false)
    public T updateSelective(T resource) {
        crudMapper.updateByPrimaryKeySelective(resource);
        return resource;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Serializable id) {
        crudMapper.deleteByPrimaryKey(id);
    }

    @Override
    public T findOne(ID id) {
        return crudMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return crudMapper.selectAll();
    }

    @Override
    public PageInfo<T> getPageInfo(BaseQuery query){
        //获取数据的总数
        int total = crudMapper.getCountByQuery(query);
        //总数小于一条，直接返回空的，不再进行查询
        if(total<1){
        }
        //查询数据,完成分页
        List<T> rows = crudMapper.getDataByQuery(query);

        return  new PageInfo<>(rows,total);
    }
}
