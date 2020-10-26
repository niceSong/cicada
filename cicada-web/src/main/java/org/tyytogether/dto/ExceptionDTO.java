package org.tyytogether.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ExceptionDTO {
    int errCode;
    String nameSpace;
    String errMessage;
    String stackTrace;

    public ExceptionDTO(int errCode, String nameSpace, String errMessage, String stackTrace) {
        this.errCode = errCode;
        this.nameSpace = nameSpace;
        this.errMessage = errMessage;
        this.stackTrace = stackTrace;
    }
}
