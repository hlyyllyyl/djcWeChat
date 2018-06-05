package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TSystemDictionaryItem;
import com.decisioncustom.mapper.TSystemDictionaryItemMapper;
import com.decisioncustom.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SystemDictionaryItemServiceImpl
	extends ICrudServiceImpl<TSystemDictionaryItem,Long> implements ISystemDictionaryItemService {

	@Autowired
    TSystemDictionaryItemMapper dictionaryItemMapper;
	@Override
	public List<TSystemDictionaryItem> listOne(Long id) {
		List<TSystemDictionaryItem> listOne = dictionaryItemMapper.listOne(id);
		return listOne;
	}

	@Override
	public TSystemDictionaryItem getItemByName(String name) {
		return dictionaryItemMapper.getItemByName(name);
	}

}
