package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public class AlRuntimeException extends RuntimeException {
    public static final String PRODUCER_ID = "MaSdkAndroid";
    public String errorCode;
    public String status;
    public String title;
    public String type;

    public AlRuntimeException() {
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
    }

    public AlRuntimeException(String str) {
        super(str);
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
    }

    public AlRuntimeException(String str, Throwable th) {
        super(str, th);
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
    }

    public AlRuntimeException(Throwable th) {
        super(th);
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
    }

    public AlRuntimeException(@NotNull AlErrorCode alErrorCode, @NotNull String str, String str2) {
        super(str);
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
        this.errorCode = alErrorCode.getValue();
        this.title = str;
        this.status = str2;
        this.type = alErrorCode.getUrl();
    }

    public AlRuntimeException(@NotNull AlErrorCode alErrorCode, @NotNull String str, String str2, Throwable th) {
        super(str, th);
        this.errorCode = "";
        this.title = "";
        this.type = "";
        this.status = "";
        this.errorCode = alErrorCode.getValue();
        this.title = str;
        this.status = str2;
        this.type = alErrorCode.getUrl();
    }
}
