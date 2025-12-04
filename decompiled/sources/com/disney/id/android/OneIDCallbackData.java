package com.disney.id.android;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/OneIDCallbackData;", "", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(ZLcom/disney/id/android/OneIDError;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getSuccess", "()Z", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class OneIDCallbackData {

    @Nullable
    private final OneIDError error;
    private final boolean success;

    public OneIDCallbackData(boolean z, @Nullable OneIDError oneIDError) {
        this.success = z;
        this.error = oneIDError;
    }

    public /* synthetic */ OneIDCallbackData(boolean z, OneIDError oneIDError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError);
    }

    @Nullable
    public OneIDError getError() {
        return this.error;
    }

    public boolean getSuccess() {
        return this.success;
    }
}
