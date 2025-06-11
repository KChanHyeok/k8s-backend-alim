package com.welab.k8s_backend_alim.common.exception;

public class BadParameter extends ClientError{
    public BadParameter(String message){
        this.errorCode = "BadParameter";
        this.errorMessage = message;
    }
}
