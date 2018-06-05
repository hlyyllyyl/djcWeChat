package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TSystemDictionary;
import com.decisioncustom.service.ISystemDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SystemDictionaryServiceImpl
		extends ICrudServiceImpl<TSystemDictionary,Long> implements ISystemDictionaryService {
}
