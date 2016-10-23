/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gaby.test.service;

import java.math.BigDecimal;
import mx.gaby.common.base.service.BaseService;
import mx.gaby.test.entity.Contacto;

/**
 *
 * @author iam_g
 */
public interface TestService extends BaseService<Contacto, Long> {
    
    Contacto getContacto(Long id);
}
