package com.disney.id.android;

import com.oneid.common.ConstantsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/disney/id/android/OneIDListener;", "", ConstantsKt.ON_LOGOUT, "", "onTokenRefreshFailure", "onTokenRefreshSuccess", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OneIDListener {
    void onLogout();

    void onTokenRefreshFailure();

    void onTokenRefreshSuccess();
}
