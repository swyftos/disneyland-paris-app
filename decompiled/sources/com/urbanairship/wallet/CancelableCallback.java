package com.urbanairship.wallet;

import android.os.Looper;
import com.urbanairship.CancelableOperation;

/* loaded from: classes5.dex */
class CancelableCallback extends CancelableOperation {
    private Callback callback;
    private Pass pass;
    private int status;

    public CancelableCallback(Callback callback, Looper looper) {
        super(looper);
        this.callback = callback;
    }

    @Override // com.urbanairship.CancelableOperation
    protected void onRun() {
        Callback callback = this.callback;
        if (callback != null) {
            Pass pass = this.pass;
            if (pass != null) {
                callback.onResult(pass);
            } else {
                callback.onError(this.status);
            }
        }
    }

    @Override // com.urbanairship.CancelableOperation
    protected void onCancel() {
        this.callback = null;
        this.pass = null;
    }

    void setResult(int i, Pass pass) {
        if (isCancelled()) {
            return;
        }
        this.status = i;
        this.pass = pass;
    }
}
