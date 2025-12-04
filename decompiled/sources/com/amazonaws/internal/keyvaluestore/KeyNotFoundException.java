package com.amazonaws.internal.keyvaluestore;

/* loaded from: classes2.dex */
public class KeyNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public KeyNotFoundException(String str, Throwable th) {
        super(str, th);
    }

    public KeyNotFoundException(String str) {
        super(str);
    }

    public KeyNotFoundException(Throwable th) {
        super(th);
    }
}
