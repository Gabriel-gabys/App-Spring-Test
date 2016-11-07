/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gaby.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import mx.com.gaby.dto.ResultAsyncDTO;
import mx.com.pendulum.carga.util.Md5Converter;
import org.apache.commons.io.IOUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author iam_g
 */
@Service
public class AsynchronousService {

    private AsyncResult<ResultAsyncDTO> result = new AsyncResult<ResultAsyncDTO>(new ResultAsyncDTO());
    private ResultAsyncDTO resultDto = new ResultAsyncDTO();
    boolean enProceso;

    public AsynchronousService() {

    }

    @Async
    public void sendMails(int totalMails) {
        for (int i = 1; i <= totalMails; i++) {
            try {
                serializeFile();
                sendMail(i);
                result = new AsyncResult<ResultAsyncDTO>(new ResultAsyncDTO(i, "Enviados " + i + " de " + totalMails, totalMails, true));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void serializeFile() {
        try {
            File file = new File("C:\\Users\\iam_g\\Downloads\\alto.pdf");
            InputStream isNew = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(isNew);
            String codigoMd5 = Md5Converter.calculaMD5(bytes);

            Long maxMemory = Runtime.getRuntime().maxMemory();
            int[] matrix = new int[(int) (maxMemory + 1)];
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i] = i + 1;
            }

            System.out.println("Serializando archivo: [Tamaño: " + file.length() + "][" + maxMemory + "]" + "[" + file.getName() + "][" + codigoMd5 + "][" + bytes.length + "]");
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException: " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }
    }

    private void sendMail(int num) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Mail " + num + " enviado.");
    }

    public AsyncResult<ResultAsyncDTO> getResult() {
        return result;
    }

    public ResultAsyncDTO getMailsSender() throws ExecutionException {
        return result.get();
    }

    public void procesar() {
        final Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println("Uncaught exception: " + ex);
                System.out.println("TErminar procesamiento aquí: " + ex);

                resultDto.setProcesando(false);
                resultDto.setIndex(0);
                resultDto.setMessage("Uncaught exception - Error de procesamiento dentro del hilo");
                resultDto.setTotalRecords(0);
            }
        };

        try {
            /*Thread t = */
            (new Thread(
                    new Runnable() {
                public void run() {
                    Thread.currentThread().setUncaughtExceptionHandler(h);

                    enProceso = true;
                    resultDto.setProcesando(true);
                    resultDto.setTotalRecords(100);

                    try {
                        int h = 0;
                        for (h = 1; h <= 100; h++) {
                            resultDto.setIndex(h);
                            resultDto.setMessage("Enviados " + h + " de 100");

                            System.out.println(h + ".- Ejecutando ...");

                            try {
                                for (int i = 1; i <= 100; i++) {
                                    Long maxMemory = Runtime.getRuntime().maxMemory();
                                    int[] matrix = new int[(int) (maxMemory + 1)];
                                    for (int j = 0; j < matrix.length; ++j) {
                                        matrix[j] = j + 1;
                                    }
                                }
                            } catch (OutOfMemoryError e) {
                                System.out.println(" : Memory Use : " + e.getMessage());
                            }
                        }

                        Thread.sleep(2000);

                        resultDto.setProcesando(false);
                    } catch (InterruptedException ie) {
                        System.out.println("InterruptedException run");

                        resultDto.setProcesando(false);
                        resultDto.setIndex(0);
                        resultDto.setMessage("InterruptedException - Error de procesamiento dentro del hilo");
                        resultDto.setTotalRecords(0);
                    }
                }
            }
            )).start();
            //t.setUncaughtExceptionHandler(h);
            //t.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            resultDto.setProcesando(false);
            resultDto.setIndex(0);
            resultDto.setMessage("Exception - Error de procesamiento dentro del hilo");
            resultDto.setTotalRecords(0);
        }

    }

    public ResultAsyncDTO getEstatus() throws ExecutionException {
        return resultDto;
    }
}
