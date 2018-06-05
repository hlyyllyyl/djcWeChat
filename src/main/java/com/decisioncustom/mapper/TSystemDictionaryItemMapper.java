package com.decisioncustom.mapper;

import com.decisioncustom.domain.TSystemDictionaryItem;

import java.util.List;


public interface TSystemDictionaryItemMapper extends CrudMapper<TSystemDictionaryItem>{

	List<TSystemDictionaryItem> listOne(Long id);

	/*通过名称查找对应数据字典*/
	TSystemDictionaryItem getItemByName(String name);
}
