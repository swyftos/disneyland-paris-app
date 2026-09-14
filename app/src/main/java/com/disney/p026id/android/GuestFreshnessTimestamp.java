package com.disney.p026id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1836d2 = {"Lcom/disney/id/android/GuestFreshnessTimestamp;", "", "guestLastRetrieved", "", "(J)V", "getGuestLastRetrieved", "()J", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class GuestFreshnessTimestamp {
    private final long guestLastRetrieved;

    public static /* synthetic */ GuestFreshnessTimestamp copy$default(GuestFreshnessTimestamp guestFreshnessTimestamp, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guestFreshnessTimestamp.guestLastRetrieved;
        }
        return guestFreshnessTimestamp.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuestLastRetrieved() {
        return this.guestLastRetrieved;
    }

    @NotNull
    public final GuestFreshnessTimestamp copy(long guestLastRetrieved) {
        return new GuestFreshnessTimestamp(guestLastRetrieved);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GuestFreshnessTimestamp) && this.guestLastRetrieved == ((GuestFreshnessTimestamp) other).guestLastRetrieved;
    }

    public int hashCode() {
        return Long.hashCode(this.guestLastRetrieved);
    }

    @NotNull
    public String toString() {
        return "GuestFreshnessTimestamp(guestLastRetrieved=" + this.guestLastRetrieved + ")";
    }

    public GuestFreshnessTimestamp(long j) {
        this.guestLastRetrieved = j;
    }

    public final long getGuestLastRetrieved() {
        return this.guestLastRetrieved;
    }
}
