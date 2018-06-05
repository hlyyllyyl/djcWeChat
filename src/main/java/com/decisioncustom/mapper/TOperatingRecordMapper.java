package com.decisioncustom.mapper;


import com.decisioncustom.domain.TOperatingRecord;
import com.decisioncustom.domain.TOperatingRecordCustomer;
import com.decisioncustom.domain.TOperatingRecordEmployee;

import java.io.Serializable;
import java.util.List;

public interface TOperatingRecordMapper extends CrudMapper<TOperatingRecord>{
    //通过roleid删除中间表关联关系
    void removeRecordEmployees(Serializable id);
    //保存中间表关联关系
    void saveRecordEmployees(List<TOperatingRecordEmployee> operatingRecordEmployees);

    //保存中间表关联关系
    void saveRecordCustomers(List<TOperatingRecordCustomer> operatingRecordCustomers);

    //通过roleid删除中间表关联关系
    void removeRecordCustomers(Serializable id);

    List<TOperatingRecord> selectAll();
    /*更新股票实时价格*/
    int updateStockPrice(TOperatingRecord record);
}
