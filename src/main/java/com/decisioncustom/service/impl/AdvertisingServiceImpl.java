package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TAdvertising;
import com.decisioncustom.mapper.TAdvertisingMapper;
import com.decisioncustom.service.IAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class AdvertisingServiceImpl extends ICrudServiceImpl<TAdvertising,Long> implements IAdvertisingService {

    @Autowired
    private TAdvertisingMapper advertisingMapper;

    @Override
    public List<TAdvertising> selectAdByAdType(Long adType) {
        return advertisingMapper.selectAdByAdType(adType);
    }

    @Override
    public List<TAdvertising> selectAdByName(String name) {
        return advertisingMapper.selectAdByName(name);
    }


}
