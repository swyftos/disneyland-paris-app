package com.amazonaws.internal;

import com.amazonaws.async.Callback;

/* loaded from: classes2.dex */
public abstract class ReturningRunnable<R> {
    private final String operationDescription;

    public abstract R run() throws Exception;

    public ReturningRunnable() {
        this.operationDescription = null;
    }

    public ReturningRunnable(String str) {
        this.operationDescription = str;
    }

    public R await() throws Exception {
        return run();
    }

    public void async(final Callback<R> callback) {
        new Thread(new Runnable() { // from class: com.amazonaws.internal.ReturningRunnable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    callback.onResult(ReturningRunnable.this.run());
                } catch (Exception e) {
                    if (ReturningRunnable.this.operationDescription != null) {
                        callback.onError(new Exception(ReturningRunnable.this.operationDescription, e));
                    } else {
                        callback.onError(e);
                    }
                }
            }
        }).start();
    }
}
