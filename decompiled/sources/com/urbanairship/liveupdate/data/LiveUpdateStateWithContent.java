package com.urbanairship.liveupdate.data;

import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateStateWithContent;", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "content", "Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "(Lcom/urbanairship/liveupdate/data/LiveUpdateState;Lcom/urbanairship/liveupdate/data/LiveUpdateContent;)V", "getContent", "()Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "getState", "()Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LiveUpdateStateWithContent {
    private final LiveUpdateContent content;
    private final LiveUpdateState state;

    public static /* synthetic */ LiveUpdateStateWithContent copy$default(LiveUpdateStateWithContent liveUpdateStateWithContent, LiveUpdateState liveUpdateState, LiveUpdateContent liveUpdateContent, int i, Object obj) {
        if ((i & 1) != 0) {
            liveUpdateState = liveUpdateStateWithContent.state;
        }
        if ((i & 2) != 0) {
            liveUpdateContent = liveUpdateStateWithContent.content;
        }
        return liveUpdateStateWithContent.copy(liveUpdateState, liveUpdateContent);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final LiveUpdateState getState() {
        return this.state;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final LiveUpdateContent getContent() {
        return this.content;
    }

    @NotNull
    public final LiveUpdateStateWithContent copy(@NotNull LiveUpdateState state, @Nullable LiveUpdateContent content) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new LiveUpdateStateWithContent(state, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdateStateWithContent)) {
            return false;
        }
        LiveUpdateStateWithContent liveUpdateStateWithContent = (LiveUpdateStateWithContent) other;
        return Intrinsics.areEqual(this.state, liveUpdateStateWithContent.state) && Intrinsics.areEqual(this.content, liveUpdateStateWithContent.content);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        LiveUpdateContent liveUpdateContent = this.content;
        return iHashCode + (liveUpdateContent == null ? 0 : liveUpdateContent.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveUpdateStateWithContent(state=" + this.state + ", content=" + this.content + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LiveUpdateStateWithContent(@NotNull LiveUpdateState state, @Nullable LiveUpdateContent liveUpdateContent) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.content = liveUpdateContent;
    }

    @NotNull
    public final LiveUpdateState getState() {
        return this.state;
    }

    @Nullable
    public final LiveUpdateContent getContent() {
        return this.content;
    }
}
