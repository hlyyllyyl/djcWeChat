package com.decisioncustom.service;


import com.decisioncustom.domain.TAdvertising;

import java.util.List;

public interface IAdvertisingService extends ICrudService<TAdvertising,Long> {
    /*根据类型查询所有广告*/
    List<TAdvertising> selectAdByAdType(Long adType);

    /*根据类型名称查询所有广告*/
    List<TAdvertising> selectAdByName(String name);
}
