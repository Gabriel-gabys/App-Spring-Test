/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.test.dao;

import java.math.BigDecimal;
import mx.gaby.common.base.dao.BaseDAO;
import mx.gaby.test.entity.Contacto;

/**
 *
 * @author iam_g
 */
public interface TestDAO extends BaseDAO<Contacto, Long> {
    
    public Contacto getContacto(Long id);
}
