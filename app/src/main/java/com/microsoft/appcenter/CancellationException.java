package com.microsoft.appcenter;

/* JADX INFO: loaded from: classes4.dex */
public class CancellationException extends Exception {
    public CancellationException() {
        super("Request cancelled because Channel is disabled.");
    }
}
