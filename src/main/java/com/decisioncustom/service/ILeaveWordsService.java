package com.decisioncustom.service;


import com.decisioncustom.domain.TLeaveWords;
import com.decisioncustom.query.LeaveWordsQuery;

import java.util.List;

public interface ILeaveWordsService extends ICrudService<TLeaveWords,Long>{
    /**
     * 查询所有客户留言
     * @return
     */
    List<TLeaveWords> getAllLeaveWordsByQuery(LeaveWordsQuery leaveWordsQuery);

    /*查询客户留言*/
    List<TLeaveWords> selectByCustomerId(Long customerId);
}
