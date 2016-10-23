/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.test.service.impl;

import java.math.BigDecimal;
import mx.gaby.common.base.service.impl.BaseServiceImpl;
import mx.gaby.test.dao.TestDAO;
import mx.gaby.test.entity.Contacto;
import mx.gaby.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iam_g
 */
@Service
@Transactional(readOnly = true)
public class TestServiceImpl extends BaseServiceImpl<Contacto, Long> implements TestService {
    
    private TestDAO testDAO;
    
    @Autowired
    public TestServiceImpl(TestDAO testDAO) {
        super(testDAO);
        
        this.testDAO = testDAO;
    }
    
    public Contacto getContacto(Long id) {
        return testDAO.getContacto(id);
    }
}
