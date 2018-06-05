package com.decisioncustom.listener;

import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TOperatingRecord;
import com.decisioncustom.service.IOperatingRecordService;
import com.decisioncustom.utils.refreshStockPrice.RefreshStockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class stockPriceTimeListener {

    @Autowired
    private IOperatingRecordService operatingRecordService;

    public void refreshStockPrice() {
                Map<Object, Object> hashMap = new HashMap<Object, Object>();
                List<TOperatingRecord> operatingRecordList = operatingRecordService.findAll();
                for (TOperatingRecord operatingRecord:operatingRecordList){
                    String stockCode = operatingRecord.getStockCode();
                    hashMap.put("q","sz"+stockCode);
                    String str = "http://qt.gtimg.cn";
                    String method ="GET";
                    String net = null;
                    try {
                        net = RefreshStockPrice.net(str, hashMap, method);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String[] strs =net.split("~");
                    BigDecimal newPrice =  new BigDecimal(strs[3].toString());
                    Long operatingRecordId = operatingRecord.getId();
                    TOperatingRecord newOp = operatingRecordService.findOne(operatingRecordId);

                    List<TCustomer> customers= new ArrayList<>();
                    newOp.setCustomers(customers);

                    newOp.setLatestClosingPrice(newPrice);
                    operatingRecordService.updateStockPrice(newOp);
                }
        }
}
