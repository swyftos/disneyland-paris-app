package com.urbanairship.liveupdate;

import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.liveupdate.data.LiveUpdateContent;
import com.urbanairship.liveupdate.data.LiveUpdateState;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdate;", "", "name", "", "type", "content", "Lcom/urbanairship/json/JsonMap;", "lastContentUpdateTime", "", "lastStateChangeTime", "dismissalTime", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JJLjava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastContentUpdateTime", "()J", "getLastStateChangeTime", "getName", "()Ljava/lang/String;", "getType", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LiveUpdate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonMap content;
    private final Long dismissalTime;
    private final long lastContentUpdateTime;
    private final long lastStateChangeTime;
    private final String name;
    private final String type;

    public LiveUpdate(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long j, long j2, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.type = type;
        this.content = content;
        this.lastContentUpdateTime = j;
        this.lastStateChangeTime = j2;
        this.dismissalTime = l;
    }

    public /* synthetic */ LiveUpdate(String str, String str2, JsonMap jsonMap, long j, long j2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, jsonMap, j, j2, (i & 32) != 0 ? null : l);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final JsonMap getContent() {
        return this.content;
    }

    public final long getLastContentUpdateTime() {
        return this.lastContentUpdateTime;
    }

    public final long getLastStateChangeTime() {
        return this.lastStateChangeTime;
    }

    @Nullable
    public final Long getDismissalTime() {
        return this.dismissalTime;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdate$Companion;", "", "()V", "from", "Lcom/urbanairship/liveupdate/LiveUpdate;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "content", "Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "from$urbanairship_live_update_release", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final LiveUpdate from$urbanairship_live_update_release(@NotNull LiveUpdateState state, @NotNull LiveUpdateContent content) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(content, "content");
            return new LiveUpdate(state.getName(), state.getType(), content.getContent(), content.getTimestamp(), state.getTimestamp(), state.getDismissalDate());
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(LiveUpdate.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.liveupdate.LiveUpdate");
        LiveUpdate liveUpdate = (LiveUpdate) other;
        return Intrinsics.areEqual(this.name, liveUpdate.name) && Intrinsics.areEqual(this.type, liveUpdate.type) && Intrinsics.areEqual(this.content, liveUpdate.content) && this.lastContentUpdateTime == liveUpdate.lastContentUpdateTime && this.lastStateChangeTime == liveUpdate.lastStateChangeTime && Intrinsics.areEqual(this.dismissalTime, liveUpdate.dismissalTime);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.type, this.content, Long.valueOf(this.lastContentUpdateTime), Long.valueOf(this.lastStateChangeTime), this.dismissalTime);
    }
}
