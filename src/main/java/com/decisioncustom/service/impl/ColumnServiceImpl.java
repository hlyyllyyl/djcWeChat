package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TArticle;
import com.decisioncustom.domain.TColumn;
import com.decisioncustom.mapper.TArticleMapper;
import com.decisioncustom.mapper.TColumnMapper;
import com.decisioncustom.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnServiceImpl
		extends ICrudServiceImpl<TColumn,Long> implements IColumnService {

	@Autowired
	private TColumnMapper columnMapper;

	@Autowired
	private TArticleMapper articleMapper;

	@Override
	public List<TColumn> selectParentColumn() {
		return columnMapper.selectParentColumn();
	}

	@Override
	public List<TColumn> selectChildrenColumn(Long parentId) {
		return columnMapper.selectChildrenColumn(parentId);
	}

	@Override
	public List<TColumn> selectAllColumn() {
		List<TColumn> parentColumnList= columnMapper.selectParentColumn();

		for (TColumn parent :parentColumnList){
			Long parentId = parent.getId();
			TColumn column = columnMapper.selectTopColumn(parentId);
			List<TColumn> childrenColumn= columnMapper.selectChildrenColumn(parentId);
			if(column!=null){
				List<TArticle> articleList= articleMapper.getArticleByColumn(column.getId());
				 List<TArticle> articles  = new ArrayList<>();
				for (int i = 0; i <articleList.size(); i++) {
					if(i<6){
						articles.add(articleList.get(i));
					}
				}
				/*parent.setArticleList(articles);*/
			}
			parent.setChildrenColumn(childrenColumn);
		}
		return parentColumnList;
	}

	@Override
	public TColumn selectTopColumnByName(String columnName) {
		return columnMapper.selectTopColumnByName(columnName);
	}
}
