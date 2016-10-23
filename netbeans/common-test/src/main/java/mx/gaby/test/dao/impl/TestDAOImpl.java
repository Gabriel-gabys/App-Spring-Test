/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.test.dao.impl;

import mx.gaby.common.base.dao.impl.BaseDAOImpl;
import mx.gaby.test.entity.Contacto;
import mx.gaby.test.dao.TestDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iam_g
 */
//@Component
@Repository
public class TestDAOImpl extends BaseDAOImpl<Contacto, Long> implements TestDAO {
    
    public TestDAOImpl() {
        super(Contacto.class);
    }
    
    @Override
    public Contacto getContacto(Long id) {
        return this.getData(id);
    }
}
