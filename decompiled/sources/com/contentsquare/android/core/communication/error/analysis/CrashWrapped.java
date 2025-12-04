package com.contentsquare.android.core.communication.error.analysis;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/android/core/communication/error/analysis/CrashWrapped;", "", "timestamp", "", "data", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "(JLcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;)V", "getData", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "getTimestamp", "()J", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CrashWrapped {

    @NotNull
    private final MobileStacktrace.Crash data;
    private final long timestamp;

    public CrashWrapped(long j, MobileStacktrace.Crash data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.timestamp = j;
        this.data = data;
    }

    public static /* synthetic */ CrashWrapped copy$default(CrashWrapped crashWrapped, long j, MobileStacktrace.Crash crash, int i, Object obj) {
        if ((i & 1) != 0) {
            j = crashWrapped.timestamp;
        }
        if ((i & 2) != 0) {
            crash = crashWrapped.data;
        }
        return crashWrapped.copy(j, crash);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final MobileStacktrace.Crash getData() {
        return this.data;
    }

    @NotNull
    public final CrashWrapped copy(long timestamp, MobileStacktrace.Crash data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new CrashWrapped(timestamp, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CrashWrapped)) {
            return false;
        }
        CrashWrapped crashWrapped = (CrashWrapped) other;
        return this.timestamp == crashWrapped.timestamp && Intrinsics.areEqual(this.data, crashWrapped.data);
    }

    @NotNull
    public final MobileStacktrace.Crash getData() {
        return this.data;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.data.hashCode() + (Long.hashCode(this.timestamp) * 31);
    }

    @NotNull
    public String toString() {
        return "CrashWrapped(timestamp=" + this.timestamp + ", data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
