package com.oneid.model;

import com.disney.p026id.android.lightbox.WebToNativeBridgeBase;
import com.urbanairship.reactnative.ReactMessageView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1836d2 = {"Lcom/oneid/model/EventType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Login", "Logout", "Close", "dlp-mobile_react-native-oneid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum EventType {
    Login("login"),
    Logout(WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT),
    Close(ReactMessageView.EVENT_CLOSE);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String type;

    @NotNull
    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }

    EventType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
