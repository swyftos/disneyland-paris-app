package com.urbanairship.android.framework.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/EventType;", "", "(Ljava/lang/String;I)V", "CHANNEL_CREATED", "DEEP_LINK_RECEIVED", "DISPLAY_MESSAGE_CENTER", "DISPLAY_PREFERENCE_CENTER", "MESSAGE_CENTER_UPDATED", "PUSH_TOKEN_RECEIVED", "FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED", "BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED", "FOREGROUND_PUSH_RECEIVED", "BACKGROUND_PUSH_RECEIVED", "NOTIFICATION_STATUS_CHANGED", "PENDING_EMBEDDED_UPDATED", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventType[] $VALUES;
    public static final EventType CHANNEL_CREATED = new EventType("CHANNEL_CREATED", 0);
    public static final EventType DEEP_LINK_RECEIVED = new EventType("DEEP_LINK_RECEIVED", 1);
    public static final EventType DISPLAY_MESSAGE_CENTER = new EventType("DISPLAY_MESSAGE_CENTER", 2);
    public static final EventType DISPLAY_PREFERENCE_CENTER = new EventType("DISPLAY_PREFERENCE_CENTER", 3);
    public static final EventType MESSAGE_CENTER_UPDATED = new EventType("MESSAGE_CENTER_UPDATED", 4);
    public static final EventType PUSH_TOKEN_RECEIVED = new EventType("PUSH_TOKEN_RECEIVED", 5);
    public static final EventType FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED = new EventType("FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED", 6);
    public static final EventType BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED = new EventType("BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED", 7);
    public static final EventType FOREGROUND_PUSH_RECEIVED = new EventType("FOREGROUND_PUSH_RECEIVED", 8);
    public static final EventType BACKGROUND_PUSH_RECEIVED = new EventType("BACKGROUND_PUSH_RECEIVED", 9);
    public static final EventType NOTIFICATION_STATUS_CHANGED = new EventType("NOTIFICATION_STATUS_CHANGED", 10);
    public static final EventType PENDING_EMBEDDED_UPDATED = new EventType("PENDING_EMBEDDED_UPDATED", 11);

    private static final /* synthetic */ EventType[] $values() {
        return new EventType[]{CHANNEL_CREATED, DEEP_LINK_RECEIVED, DISPLAY_MESSAGE_CENTER, DISPLAY_PREFERENCE_CENTER, MESSAGE_CENTER_UPDATED, PUSH_TOKEN_RECEIVED, FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED, BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED, FOREGROUND_PUSH_RECEIVED, BACKGROUND_PUSH_RECEIVED, NOTIFICATION_STATUS_CHANGED, PENDING_EMBEDDED_UPDATED};
    }

    @NotNull
    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    private EventType(String str, int i) {
    }

    static {
        EventType[] eventTypeArr$values = $values();
        $VALUES = eventTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTypeArr$values);
    }
}
