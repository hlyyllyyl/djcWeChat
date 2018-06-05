package com.decisioncustom.service.impl;

import com.decisioncustom.mapper.BaseMapper;
import com.decisioncustom.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BaseServiceImpl<T> implements IBaseService<T> {
	
	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	@Transactional
	public void add(T t) {
		baseMapper.save(t);
	}

	@Override
	@Transactional
	public void del(Serializable id) {
		baseMapper.remove(id);
	}

	@Override
	@Transactional
	public void update(T t) {
		baseMapper.update(t);
	}

	@Override
	public T getOne(Serializable id) {
		return baseMapper.getOne(id);
	}

	@Override
	public List<T> getAll() {
		return baseMapper.getAll();
	}

}
