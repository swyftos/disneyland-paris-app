package com.microsoft.appcenter.crashes.model;

/* loaded from: classes4.dex */
public class NativeException extends RuntimeException {
    public NativeException() {
        super("Native exception read from a minidump file");
    }
}
