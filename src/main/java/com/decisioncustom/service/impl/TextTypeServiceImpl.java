package com.decisioncustom.service.impl;

import com.decisioncustom.domain.MTextType;
import com.decisioncustom.service.MTextTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public  class TextTypeServiceImpl extends ICrudServiceImpl<MTextType,Long> implements MTextTypeService {
}
