package com.urbanairship.liveupdate.data;

import androidx.room.Entity;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "live_update_content")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;J)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LiveUpdateContent {
    private final JsonMap content;
    private final String name;
    private final long timestamp;

    public static /* synthetic */ LiveUpdateContent copy$default(LiveUpdateContent liveUpdateContent, String str, JsonMap jsonMap, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveUpdateContent.name;
        }
        if ((i & 2) != 0) {
            jsonMap = liveUpdateContent.content;
        }
        if ((i & 4) != 0) {
            j = liveUpdateContent.timestamp;
        }
        return liveUpdateContent.copy(str, jsonMap, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final JsonMap getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final LiveUpdateContent copy(@NotNull String name, @NotNull JsonMap content, long timestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        return new LiveUpdateContent(name, content, timestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdateContent)) {
            return false;
        }
        LiveUpdateContent liveUpdateContent = (LiveUpdateContent) other;
        return Intrinsics.areEqual(this.name, liveUpdateContent.name) && Intrinsics.areEqual(this.content, liveUpdateContent.content) && this.timestamp == liveUpdateContent.timestamp;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestamp);
    }

    @NotNull
    public String toString() {
        return "LiveUpdateContent(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LiveUpdateContent(@NotNull String name, @NotNull JsonMap content, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.content = content;
        this.timestamp = j;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final JsonMap getContent() {
        return this.content;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
