package com.decisioncustom.service;


import com.decisioncustom.domain.TSystemDictionaryItem;

import java.util.List;

public interface ISystemDictionaryItemService extends ICrudService<TSystemDictionaryItem,Long> {

	List<TSystemDictionaryItem> listOne(Long id);

	/*通过名称查找对应数据字典*/
	TSystemDictionaryItem getItemByName(String name);
}
