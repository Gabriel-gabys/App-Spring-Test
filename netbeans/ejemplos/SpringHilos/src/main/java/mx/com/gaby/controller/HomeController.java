/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gaby.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import mx.com.gaby.dto.ResultAsyncDTO;
import mx.com.gaby.service.AsynchronousService;
import mx.com.pendulum.carga.util.Md5Converter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iam_g
 */
@Controller
public class HomeController {

    @Autowired
    private AsynchronousService testAsynch;

    @RequestMapping("/index")
    public ModelAndView index() {
        System.out.println("INDEX");
        ModelAndView modelAndview = new ModelAndView();
        
        testAsynch.procesar();

        modelAndview.setViewName("index");

        return modelAndview;
    }

    @RequestMapping("/async")
    public ModelAndView async() throws ExecutionException {
        System.out.println("ASYNC");

        testAsynch.sendMails(50);
        //System.out.println("1: " + testAsynch.getMailsSender());

        /*sleepALittle(10000);

        System.out.println("2: " + testAsynch.getMailsSender());

        stopSendMails();*/
        ModelAndView modelAndview = new ModelAndView();

        modelAndview.setViewName("index");

        return modelAndview;
    }
    
    @RequestMapping("/async2")
    public ModelAndView async2() throws ExecutionException {
        System.out.println("ASYNC2");

        testAsynch.procesar();
        
        ModelAndView modelAndview = new ModelAndView();

        modelAndview.setViewName("index");

        return modelAndview;
    }
    
    @RequestMapping("/response2")
    @ResponseBody
    public ResultAsyncDTO getStatusThread2() throws ExecutionException {
        ResultAsyncDTO data = testAsynch.getEstatus();
        
        System.out.println("Resultado: " + data);
        
        return data;
    }

    @RequestMapping("/response")
    @ResponseBody
    public ResultAsyncDTO getStatusThread() throws ExecutionException {
        ResultAsyncDTO data = new ResultAsyncDTO();
        
        data = testAsynch.getMailsSender();
        
        System.out.println("Resultado: " + data);
        
        return data;
    }

    @RequestMapping
    private void stopSendMails() {
        testAsynch.getResult().cancel(true);

        System.out.println("CLose redirect");
    }

    private void sleepALittle(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/redir")
    public String redirectPage() {
        return "redir";
    }

    @RequestMapping(value = "/views/async", method = RequestMethod.GET)
    public Callable<String> getViewAsyncWay() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "redir";
            }
        };
    }
}
