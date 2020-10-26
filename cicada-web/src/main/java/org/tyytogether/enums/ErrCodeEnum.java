package org.tyytogether.enums;

import lombok.Getter;

@Getter
public enum ErrCodeEnum {
    UNKNOWN_EXCEPTION(1);

    int errCode;

    ErrCodeEnum(int errCode) {
        this.errCode = errCode;
    }
}
