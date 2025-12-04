package com.disney.id.android.services;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/disney/id/android/services/BaseGCResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/services/GCResponseError;", "getError", "()Lcom/disney/id/android/services/GCResponseError;", "setError", "(Lcom/disney/id/android/services/GCResponseError;)V", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseGCResponse<T> {

    @Nullable
    private T data;

    @Nullable
    private GCResponseError error;

    @Nullable
    public final T getData() {
        return this.data;
    }

    public final void setData(@Nullable T t) {
        this.data = t;
    }

    @Nullable
    public final GCResponseError getError() {
        return this.error;
    }

    public final void setError(@Nullable GCResponseError gCResponseError) {
        this.error = gCResponseError;
    }
}
