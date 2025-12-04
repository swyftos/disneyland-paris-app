package com.urbanairship.android.layout.util;

import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/util/PagerScrollEvent;", "", ViewProps.POSITION, "", "isInternalScroll", "", "(IZ)V", "()Z", "getPosition", "()I", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PagerScrollEvent {
    private final boolean isInternalScroll;
    private final int position;

    public static /* synthetic */ PagerScrollEvent copy$default(PagerScrollEvent pagerScrollEvent, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pagerScrollEvent.position;
        }
        if ((i2 & 2) != 0) {
            z = pagerScrollEvent.isInternalScroll;
        }
        return pagerScrollEvent.copy(i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsInternalScroll() {
        return this.isInternalScroll;
    }

    @NotNull
    public final PagerScrollEvent copy(int position, boolean isInternalScroll) {
        return new PagerScrollEvent(position, isInternalScroll);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerScrollEvent)) {
            return false;
        }
        PagerScrollEvent pagerScrollEvent = (PagerScrollEvent) other;
        return this.position == pagerScrollEvent.position && this.isInternalScroll == pagerScrollEvent.isInternalScroll;
    }

    public int hashCode() {
        return (Integer.hashCode(this.position) * 31) + Boolean.hashCode(this.isInternalScroll);
    }

    @NotNull
    public String toString() {
        return "PagerScrollEvent(position=" + this.position + ", isInternalScroll=" + this.isInternalScroll + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PagerScrollEvent(int i, boolean z) {
        this.position = i;
        this.isInternalScroll = z;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean isInternalScroll() {
        return this.isInternalScroll;
    }
}
