package com.decisioncustom.mapper;


import com.decisioncustom.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {
	/*添加一条数据*/
	void save(T t);
	/* 删除一条数据 */
	void remove(Serializable id);
	/*修改一条数据*/
	void update(T t);
	/*获取一条数据*/
	T getOne(Serializable id);
	/*获取所有数据*/
	List<T> getAll();

	List<T> getDataByQuery(BaseQuery query);
}
