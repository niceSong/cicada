package org.tyytogetheyy.exception;

import org.tyytogether.annotation.CicadaBean;
import org.tyytogether.annotation.ExceptionInfo;
import org.tyytogether.exception.CicadaException;

@CicadaBean(namespace = "test")
public interface TestException {
    @ExceptionInfo(errCode = 1000)
    CicadaException fuckException(String errMsg);
}
