package com.oneid.common;

import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/oneid/common/EventId;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "CreateAccount", "GetSessionData", "LaunchProfile", "Login", "Logout", "LaunchIdentityFlow", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EventId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventId[] $VALUES;
    private final String id;
    public static final EventId CreateAccount = new EventId("CreateAccount", 0, "createAccount");
    public static final EventId GetSessionData = new EventId("GetSessionData", 1, "getSessionData");
    public static final EventId LaunchProfile = new EventId("LaunchProfile", 2, "launchProfile");
    public static final EventId Login = new EventId("Login", 3, FirebaseAnalytics.Event.LOGIN);
    public static final EventId Logout = new EventId("Logout", 4, WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT);
    public static final EventId LaunchIdentityFlow = new EventId("LaunchIdentityFlow", 5, "launchIdentityFlow");

    private static final /* synthetic */ EventId[] $values() {
        return new EventId[]{CreateAccount, GetSessionData, LaunchProfile, Login, Logout, LaunchIdentityFlow};
    }

    @NotNull
    public static EnumEntries<EventId> getEntries() {
        return $ENTRIES;
    }

    private EventId(String str, int i, String str2) {
        this.id = str2;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    static {
        EventId[] eventIdArr$values = $values();
        $VALUES = eventIdArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventIdArr$values);
    }

    public static EventId valueOf(String str) {
        return (EventId) Enum.valueOf(EventId.class, str);
    }

    public static EventId[] values() {
        return (EventId[]) $VALUES.clone();
    }
}
