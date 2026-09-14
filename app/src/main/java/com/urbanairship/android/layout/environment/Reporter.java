package com.urbanairship.android.layout.environment;

import com.urbanairship.android.layout.event.ReportingEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/android/layout/environment/Reporter;", "", "onVisibilityChanged", "", "isVisible", "", "isForegrounded", "report", "event", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface Reporter {
    void onVisibilityChanged(boolean isVisible, boolean isForegrounded);

    void report(@NotNull ReportingEvent event);
}
