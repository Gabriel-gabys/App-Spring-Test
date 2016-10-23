/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.common.base.service.impl;

import mx.gaby.common.base.dao.BaseDAO;
import mx.gaby.common.base.service.BaseService;

/**
 *
 * @author iam_g
 */
public abstract class BaseServiceImpl<T, K> implements BaseService<T, K> {
    
    private BaseDAO<T, K> baseDao;
    
    public BaseServiceImpl(BaseDAO<T, K> baseDao) {
        this.baseDao = baseDao;
    }
    
    @Override
    public T getRecord(K id) {
        return baseDao.getData(id);
    }
}
