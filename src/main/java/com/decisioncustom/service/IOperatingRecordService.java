package com.decisioncustom.service;


import com.decisioncustom.domain.TOperatingRecord;

public interface IOperatingRecordService extends ICrudService<TOperatingRecord,Long>{
    /*更新股票实时价格*/
    TOperatingRecord updateStockPrice(TOperatingRecord record);
}
