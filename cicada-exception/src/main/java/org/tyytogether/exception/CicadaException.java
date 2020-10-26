package org.tyytogether.exception;

import lombok.Getter;

@Getter
public class CicadaException extends RuntimeException{
    String nameSpace;
    int errCode;
    String errMessage;

    public CicadaException(String nameSpace, int errCode, String errMessage) {
        super(errMessage);
        this.nameSpace = nameSpace;
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
}
