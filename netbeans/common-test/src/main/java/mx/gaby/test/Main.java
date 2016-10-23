/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.gaby.test;

import mx.gaby.test.entity.Contacto;
import mx.gaby.test.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author iam_g
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("...");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/mx/gaby/test/config/app-config.xml");
        
        TestService myClass = (TestService) applicationContext.getBean("testServiceImpl");
        
        Contacto c = myClass.getContacto(2L);
        
        System.out.println("..." + c.getEmail());
    }
}