package com.disney.p026id.android;

import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m1836d2 = {"Lcom/disney/id/android/OneIDConfigCallback;", "", OneIDTrackerEvent.EVENT_PARAM_SUCCESS, "", "siteConfig", "Lorg/json/JSONObject;", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface OneIDConfigCallback {
    void success(@Nullable JSONObject siteConfig);
}
