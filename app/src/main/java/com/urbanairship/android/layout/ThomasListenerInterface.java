package com.urbanairship.android.layout;

import androidx.annotation.RestrictTo;
import com.dlp.BluetoothManager;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000fÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/android/layout/ThomasListenerInterface;", "", "onDismiss", "", "cancel", "", "onReportingEvent", "event", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "onStateChanged", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/json/JsonSerializable;", "onVisibilityChanged", "isVisible", "isForegrounded", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ThomasListenerInterface {
    void onDismiss(boolean cancel);

    void onReportingEvent(@NotNull ReportingEvent event);

    void onStateChanged(@NotNull JsonSerializable state);

    void onVisibilityChanged(boolean isVisible, boolean isForegrounded);
}
