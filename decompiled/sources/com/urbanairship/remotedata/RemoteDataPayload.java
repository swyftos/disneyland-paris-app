package com.urbanairship.remotedata;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataPayload;", "", "type", "", "timestamp", "", "data", "Lcom/urbanairship/json/JsonMap;", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Ljava/lang/String;JLcom/urbanairship/json/JsonMap;Lcom/urbanairship/remotedata/RemoteDataInfo;)V", "getData", "()Lcom/urbanairship/json/JsonMap;", "getRemoteDataInfo", "()Lcom/urbanairship/remotedata/RemoteDataInfo;", "getTimestamp", "()J", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class RemoteDataPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonMap data;
    private final RemoteDataInfo remoteDataInfo;
    private final long timestamp;
    private final String type;

    public static /* synthetic */ RemoteDataPayload copy$default(RemoteDataPayload remoteDataPayload, String str, long j, JsonMap jsonMap, RemoteDataInfo remoteDataInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteDataPayload.type;
        }
        if ((i & 2) != 0) {
            j = remoteDataPayload.timestamp;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            jsonMap = remoteDataPayload.data;
        }
        JsonMap jsonMap2 = jsonMap;
        if ((i & 8) != 0) {
            remoteDataInfo = remoteDataPayload.remoteDataInfo;
        }
        return remoteDataPayload.copy(str, j2, jsonMap2, remoteDataInfo);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final RemoteDataPayload emptyPayload(@NotNull String str) {
        return INSTANCE.emptyPayload(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final JsonMap getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }

    @NotNull
    public final RemoteDataPayload copy(@NotNull String type, long timestamp, @NotNull JsonMap data, @Nullable RemoteDataInfo remoteDataInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        return new RemoteDataPayload(type, timestamp, data, remoteDataInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteDataPayload)) {
            return false;
        }
        RemoteDataPayload remoteDataPayload = (RemoteDataPayload) other;
        return Intrinsics.areEqual(this.type, remoteDataPayload.type) && this.timestamp == remoteDataPayload.timestamp && Intrinsics.areEqual(this.data, remoteDataPayload.data) && Intrinsics.areEqual(this.remoteDataInfo, remoteDataPayload.remoteDataInfo);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + this.data.hashCode()) * 31;
        RemoteDataInfo remoteDataInfo = this.remoteDataInfo;
        return iHashCode + (remoteDataInfo == null ? 0 : remoteDataInfo.hashCode());
    }

    @NotNull
    public String toString() {
        return "RemoteDataPayload(type=" + this.type + ", timestamp=" + this.timestamp + ", data=" + this.data + ", remoteDataInfo=" + this.remoteDataInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public RemoteDataPayload(@NotNull String type, long j, @NotNull JsonMap data, @Nullable RemoteDataInfo remoteDataInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        this.type = type;
        this.timestamp = j;
        this.data = data;
        this.remoteDataInfo = remoteDataInfo;
    }

    public /* synthetic */ RemoteDataPayload(String str, long j, JsonMap jsonMap, RemoteDataInfo remoteDataInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, jsonMap, (i & 8) != 0 ? null : remoteDataInfo);
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final JsonMap getData() {
        return this.data;
    }

    @Nullable
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataPayload$Companion;", "", "()V", "emptyPayload", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "type", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final RemoteDataPayload emptyPayload(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            JsonMap EMPTY_MAP = JsonMap.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(EMPTY_MAP, "EMPTY_MAP");
            return new RemoteDataPayload(type, 0L, EMPTY_MAP, null);
        }
    }
}
