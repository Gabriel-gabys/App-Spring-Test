/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.common.base.dao.impl;

import java.io.Serializable;
import mx.gaby.common.base.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 *
 * @author iam_g
 */
public abstract class BaseDAOImpl<T, K> implements BaseDAO<T, K> {
    
    @Autowired
    public HibernateTemplate hibernateTemplate;
    
    private Class clazz;

    public BaseDAOImpl() {

    }

    public BaseDAOImpl(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public T getData(K id) {
        return (T) this.getHibernateTemplate().get(this.clazz, (Serializable) id);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    
}
