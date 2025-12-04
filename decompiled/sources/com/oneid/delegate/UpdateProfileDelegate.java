package com.oneid.delegate;

import com.disney.id.android.GuestCallbackData;
import com.disney.id.android.OneIDCallback;
import com.disney.id.android.OneIDError;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.oneid.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/oneid/delegate/UpdateProfileDelegate;", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/GuestCallbackData;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "<init>", "(Lcom/facebook/react/bridge/Promise;)V", "onFailure", "", "data", "onSuccess", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateProfileDelegate implements OneIDCallback<GuestCallbackData> {
    private final Promise promise;

    public UpdateProfileDelegate(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.promise = promise;
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onFailure(@NotNull GuestCallbackData data) {
        String message;
        Intrinsics.checkNotNullParameter(data, "data");
        Promise promise = this.promise;
        OneIDError error = data.getError();
        if (error == null || (message = error.getMessage()) == null) {
            message = "An unknown error has occurred updating Headless Profile";
        }
        promise.reject(ConstantsKt.ONEID_TAG, message, (Throwable) null);
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onSuccess(@NotNull GuestCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.promise.resolve(Boolean.TRUE);
    }
}
