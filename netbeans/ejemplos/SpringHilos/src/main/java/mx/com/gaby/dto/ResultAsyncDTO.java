/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gaby.dto;

/**
 *
 * @author iam_g
 */
public class ResultAsyncDTO {
    
    private Integer index;
    private Integer totalRecords;
    private String message;
    private boolean procesando;

    public ResultAsyncDTO() {
    }
    
    public ResultAsyncDTO(Integer index, String message, Integer totalRecords, boolean  procesando) {
        this.index = index;
        this.totalRecords = totalRecords;
        this.message = message;
        this.procesando = procesando;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getMessage() {
        return message;
    }

    public boolean isProcesando() {
        return procesando;
    }

    public void setProcesando(boolean procesando) {
        this.procesando = procesando;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultAsyncDTO{" + "index=" + index + ", totalRecords=" + totalRecords + ", message=" + message + ", procesando=" + procesando + '}';
    }
}
