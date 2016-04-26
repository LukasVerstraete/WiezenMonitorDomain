package com.lukas.verstraete.wiezendomain.util;

public class ServiceException extends RuntimeException {
    
    public ServiceException()
    {
        super();
    }
    
    public ServiceException(String message)
    {
        super(message);
    }
    
    public ServiceException(String message, Throwable exception)
    {
        super(message, exception);
    }
    
}
