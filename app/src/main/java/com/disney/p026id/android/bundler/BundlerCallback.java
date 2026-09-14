package com.disney.p026id.android.bundler;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\b"}, m1836d2 = {"Lcom/disney/id/android/bundler/BundlerCallback;", "BundlerCallbackData", "", "onFailure", "", "data", "(Ljava/lang/Object;)V", "onSuccess", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface BundlerCallback<BundlerCallbackData> {
    void onFailure(BundlerCallbackData data);

    void onSuccess(BundlerCallbackData data);
}
