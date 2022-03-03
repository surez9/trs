package com.cotiviti.trs.response;

import lombok.Data;

import java.util.Map;
/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
@Data
public class ServiceResponse {
    private boolean success;
    private String message;
    private Map<String, Object> data;

    public ServiceResponse()
    {

    }
    public ServiceResponse(boolean sucess, String message, Map<String, Object>   data) {
        this.success = sucess;
        this.message = message;
        this.data = data;
    }

    public ServiceResponse(boolean sucess, Map<String, Object>   data) {
        this.success = sucess;
        this.data = data;
    }


    public ServiceResponse(boolean sucess, String message) {
        this.success = sucess;
        this.message = message;
    }
}
