package com.urbanairship.liveupdate.notification;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.liveupdate.LiveUpdateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 '2\u00020\u0001:\u0001'B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", "", "name", "", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "type", "dismissalDate", "", "timestamp", "content", "Lcom/urbanairship/json/JsonMap;", "(Ljava/lang/String;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Ljava/lang/String;Ljava/lang/Long;JLcom/urbanairship/json/JsonMap;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEvent", "()Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Ljava/lang/String;Ljava/lang/Long;JLcom/urbanairship/json/JsonMap;)Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LiveUpdatePayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonMap content;
    private final Long dismissalDate;
    private final LiveUpdateEvent event;
    private final String name;
    private final long timestamp;
    private final String type;

    public static /* synthetic */ LiveUpdatePayload copy$default(LiveUpdatePayload liveUpdatePayload, String str, LiveUpdateEvent liveUpdateEvent, String str2, Long l, long j, JsonMap jsonMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveUpdatePayload.name;
        }
        if ((i & 2) != 0) {
            liveUpdateEvent = liveUpdatePayload.event;
        }
        LiveUpdateEvent liveUpdateEvent2 = liveUpdateEvent;
        if ((i & 4) != 0) {
            str2 = liveUpdatePayload.type;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            l = liveUpdatePayload.dismissalDate;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            j = liveUpdatePayload.timestamp;
        }
        long j2 = j;
        if ((i & 32) != 0) {
            jsonMap = liveUpdatePayload.content;
        }
        return liveUpdatePayload.copy(str, liveUpdateEvent2, str3, l2, j2, jsonMap);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final LiveUpdateEvent getEvent() {
        return this.event;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final JsonMap getContent() {
        return this.content;
    }

    @NotNull
    public final LiveUpdatePayload copy(@NotNull String name, @NotNull LiveUpdateEvent event, @Nullable String type, @Nullable Long dismissalDate, long timestamp, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(content, "content");
        return new LiveUpdatePayload(name, event, type, dismissalDate, timestamp, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdatePayload)) {
            return false;
        }
        LiveUpdatePayload liveUpdatePayload = (LiveUpdatePayload) other;
        return Intrinsics.areEqual(this.name, liveUpdatePayload.name) && this.event == liveUpdatePayload.event && Intrinsics.areEqual(this.type, liveUpdatePayload.type) && Intrinsics.areEqual(this.dismissalDate, liveUpdatePayload.dismissalDate) && this.timestamp == liveUpdatePayload.timestamp && Intrinsics.areEqual(this.content, liveUpdatePayload.content);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.event.hashCode()) * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.dismissalDate;
        return ((((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveUpdatePayload(name=" + this.name + ", event=" + this.event + ", type=" + this.type + ", dismissalDate=" + this.dismissalDate + ", timestamp=" + this.timestamp + ", content=" + this.content + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LiveUpdatePayload(@NotNull String name, @NotNull LiveUpdateEvent event, @Nullable String str, @Nullable Long l, long j, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.event = event;
        this.type = str;
        this.dismissalDate = l;
        this.timestamp = j;
        this.content = content;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final LiveUpdateEvent getEvent() {
        return this.event;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final JsonMap getContent() {
        return this.content;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", "json", "Lcom/urbanairship/json/JsonMap;", "", "fromJson$urbanairship_live_update_release", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLiveUpdatePayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatePayload.kt\ncom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/liveupdate/util/JsonExtensionsKt\n*L\n1#1,67:1\n1#2:68\n36#3,11:69\n36#3,11:80\n57#3,11:91\n57#3,11:102\n36#3,11:113\n*S KotlinDebug\n*F\n+ 1 LiveUpdatePayload.kt\ncom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion\n*L\n57#1:69,11\n58#1:80,11\n59#1:91,11\n60#1:102,11\n61#1:113,11\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final LiveUpdatePayload fromJson$urbanairship_live_update_release(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JsonMap map = JsonValue.parseString(json).getMap();
                if (map != null) {
                    return LiveUpdatePayload.INSTANCE.fromJson(map);
                }
                return null;
            } catch (Exception e) {
                UALog.w(e, "Failed to parse live update payload: " + json, new Object[0]);
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:134:0x02ea  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x02f0  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x03a6  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x03b4  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x03bf  */
        /* JADX WARN: Removed duplicated region for block: B:210:0x04c9  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x0565  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0212  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final com.urbanairship.liveupdate.notification.LiveUpdatePayload fromJson(com.urbanairship.json.JsonMap r22) throws java.lang.IllegalArgumentException, com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.notification.LiveUpdatePayload.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.liveupdate.notification.LiveUpdatePayload");
        }
    }
}
