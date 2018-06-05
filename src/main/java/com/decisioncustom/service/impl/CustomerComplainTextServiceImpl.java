package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TCustomerComplainText;
import com.decisioncustom.service.ICustomerComplainTextService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public  class CustomerComplainTextServiceImpl extends ICrudServiceImpl<TCustomerComplainText,Long>
        implements ICustomerComplainTextService {

}
