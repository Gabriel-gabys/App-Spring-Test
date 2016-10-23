/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.common.base.dao;

/**
 *
 * @author iam_g
 */
public interface BaseDAO<T, K> {
    
    T getData(K id);
}
