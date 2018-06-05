package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TTextIntro;
import com.decisioncustom.service.ITextIntroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public  class TextIntroServiceImpl extends ICrudServiceImpl<TTextIntro,Long> implements ITextIntroService {
}
