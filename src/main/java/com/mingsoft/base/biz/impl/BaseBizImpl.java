/**
The MIT License (MIT) * Copyright (c) 2018 铭飞科技(mingsoft.net)

 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mingsoft.base.biz.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mingsoft.base.biz.IBaseBiz;
import com.mingsoft.base.constant.e.TableEnum;
import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.util.PageUtil;

import net.mingsoft.base.elasticsearch.bean.BaseMapping;

/**
 * @ClassName:  BaseAction   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 铭飞开发团队
 * @date:   2018年3月19日 下午3:28:27   
 *     
 * @Copyright: 2018 www.mingsoft.net Inc. All rights reserved.
 */
public abstract class BaseBizImpl<E extends Serializable> implements IBaseBiz {

	private IBaseDao<E> baseDao;

	protected final Logger LOG = Logger.getLogger(this.getClass());

	@Override
	public int saveEntity(BaseEntity entity) {
		return getDao().saveEntity(entity);
	}

	@Override
	public void deleteEntity(int id) {
		// TODO Auto-generated method stub
		getDao().deleteEntity(id);
	}

	@Override
	public void updateEntity(BaseEntity entity) {

		// TODO Auto-generated method stub
		getDao().updateEntity(entity);
	}

	@Override
	public List<E> queryAll() {
		// TODO Auto-generated method stub
		return getDao().queryAll();
	}

	@Override
	@Deprecated
	public List<E> queryByPage(PageUtil page, String orderBy, boolean order) {
		// TODO Auto-generated method stub
		return getDao().queryByPage(page.getPageNo(), page.getPageSize(), orderBy, order);
	}


	@Override
	@Deprecated
	public int queryCount() {
		return getDao().queryCount();
	}

	@Override
	public BaseEntity getEntity(int id) {
		return getDao().getEntity(id);
	}

	@Override
	public List queryBySQL(String table, List fields, Map wheres, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return getDao().queryBySQL(table, fields, wheres, begin, end, null);
	}

	@Override
	public int countBySQL(String table, Map wheres) {
		// TODO Auto-generated method stub
		return getDao().countBySQL(table, wheres);
	}

	@Override
	public List queryBySQL(String table, List fields, Map wheres) {
		// TODO Auto-generated method stub
		return getDao().queryBySQL(table, fields, wheres, null, null, null);
	}

	@Override
	public void updateBySQL(String table, Map fields, Map wheres) {
		// TODO Auto-generated method stub
		getDao().updateBySQL(table, fields, wheres);
	}

	@Override
	public void deleteBySQL(String table, Map wheres) {
		// TODO Auto-generated method stub
		getDao().deleteBySQL(table, wheres);
	}

	@Override
	public void insertBySQL(String table, Map fields) {
		// TODO Auto-generated method stub
		getDao().insertBySQL(table, fields);
	}

	@Override
	public void createTable(String table, Map fileds) {
		// TODO Auto-generated method stub
		getDao().createTable(table, fileds);
	}

	@Override
	public void alterTable(String table, Map fileds, String type) {
		// TODO Auto-generated method stub
		getDao().alterTable(table, fileds, type);
	}

	public void alterTable(String table, Map fileds, TableEnum type) {
		// TODO Auto-generated method stub
		getDao().alterTable(table, fileds, type.toString());
	}

	@Override
	public void dropTable(String table) {
		// TODO Auto-generated method stub
		getDao().dropTable(table);
	}

	@Override
	public Object excuteSql(String sql) {
		// TODO Auto-generated method stub
		return getDao().excuteSql(sql);
	}

	/**
	 * 不需要重写此方法，自动会
	 * 
	 * @return
	 */
	protected abstract IBaseDao<E> getDao();

	@Override
	public void saveBatch(List list) {
		getDao().saveBatch(list);
	}

	@Override
	public void delete(int[] ids) {
		getDao().delete(ids);
	}

	@Override
	public void deleteEntity(BaseEntity entity) {
		// TODO Auto-generated method stub
		getDao().deleteByEntity(entity);
	}

	@Override
	public E getEntity(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().getByEntity(entity);
	}

	@Override
	public List<E> query(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().query(entity);
	}

	@Override
	public List<BaseMapping> queryForSearchMapping(BaseMapping base) {
		// TODO Auto-generated method stub
		return getDao().queryForSearchMapping(base);
	}
	
	
}