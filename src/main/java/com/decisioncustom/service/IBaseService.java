package com.decisioncustom.service;


import java.io.Serializable;
import java.util.List;


public interface IBaseService<T> {
	/*添加一条数据*/
	void add(T t);
	/* 删除一条数据 */
	void del(Serializable id);
	/* 修改一条数据*/
	void update(T t);
	/* 获取一条数据*/
	T getOne(Serializable id);
	/*获取所有数据*/
	List<T> getAll();
}