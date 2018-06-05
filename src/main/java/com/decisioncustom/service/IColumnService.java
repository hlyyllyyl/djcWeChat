package com.decisioncustom.service;


import com.decisioncustom.domain.TColumn;

import java.util.List;

public interface IColumnService extends ICrudService<TColumn,Long>{
    /*查询所有父栏目*/
    List<TColumn> selectParentColumn();

    /*查询所有子栏目*/
   List<TColumn>  selectChildrenColumn(Long parentId);

    /*查询所有栏目*/
    List<TColumn> selectAllColumn();

    /*查询置顶栏目*/
    TColumn selectTopColumnByName(String columnName);
}
