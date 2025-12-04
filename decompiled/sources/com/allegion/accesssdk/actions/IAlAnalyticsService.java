package com.allegion.accesssdk.actions;

import android.util.Pair;

/* loaded from: classes2.dex */
interface IAlAnalyticsService {
    void trackEvent(String str, String str2, Pair pair);

    void trackFail(String str, String str2, Pair pair);

    void trackSuccess(String str, String str2, Pair pair);
}
