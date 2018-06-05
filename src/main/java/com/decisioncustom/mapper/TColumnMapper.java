package com.decisioncustom.mapper;


import com.decisioncustom.domain.TColumn;

import java.util.List;


public interface TColumnMapper extends CrudMapper<TColumn>{

    /*查询所有父栏目*/
    List<TColumn> selectParentColumn();

    /*查询所有父栏目*/
    List<TColumn> selectChildrenColumn(Long parentId);

    /*查询置顶栏目*/
    TColumn selectTopColumn(Long parentId);

    /*查询置顶栏目*/
    TColumn selectTopColumnByName(String columnName);
}
