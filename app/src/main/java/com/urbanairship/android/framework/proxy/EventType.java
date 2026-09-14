package com.urbanairship.android.framework.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/EventType;", "", "(Ljava/lang/String;I)V", "CHANNEL_CREATED", "DEEP_LINK_RECEIVED", "DISPLAY_MESSAGE_CENTER", "DISPLAY_PREFERENCE_CENTER", "MESSAGE_CENTER_UPDATED", "PUSH_TOKEN_RECEIVED", "FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED", "BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED", "FOREGROUND_PUSH_RECEIVED", "BACKGROUND_PUSH_RECEIVED", "NOTIFICATION_STATUS_CHANGED", "PENDING_EMBEDDED_UPDATED", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum EventType {
    CHANNEL_CREATED,
    DEEP_LINK_RECEIVED,
    DISPLAY_MESSAGE_CENTER,
    DISPLAY_PREFERENCE_CENTER,
    MESSAGE_CENTER_UPDATED,
    PUSH_TOKEN_RECEIVED,
    FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED,
    BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED,
    FOREGROUND_PUSH_RECEIVED,
    BACKGROUND_PUSH_RECEIVED,
    NOTIFICATION_STATUS_CHANGED,
    PENDING_EMBEDDED_UPDATED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    @NotNull
    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }
}
