package com.disney.p026id.android;

import com.oneid.common.ConstantsKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m1836d2 = {"Lcom/disney/id/android/OneIDListener;", "", ConstantsKt.ON_LOGOUT, "", "onTokenRefreshFailure", "onTokenRefreshSuccess", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface OneIDListener {
    void onLogout();

    void onTokenRefreshFailure();

    void onTokenRefreshSuccess();
}
