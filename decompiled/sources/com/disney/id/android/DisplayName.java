package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/disney/id/android/DisplayName;", "", "displayName", "", "proposedDisplayName", "proposedStatus", "moderatedStatusDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getModeratedStatusDate", "getProposedDisplayName", "getProposedStatus", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DisplayName {

    @Nullable
    private final String displayName;

    @Nullable
    private final String moderatedStatusDate;

    @Nullable
    private final String proposedDisplayName;

    @Nullable
    private final String proposedStatus;

    public static /* synthetic */ DisplayName copy$default(DisplayName displayName, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = displayName.displayName;
        }
        if ((i & 2) != 0) {
            str2 = displayName.proposedDisplayName;
        }
        if ((i & 4) != 0) {
            str3 = displayName.proposedStatus;
        }
        if ((i & 8) != 0) {
            str4 = displayName.moderatedStatusDate;
        }
        return displayName.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getProposedDisplayName() {
        return this.proposedDisplayName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getProposedStatus() {
        return this.proposedStatus;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getModeratedStatusDate() {
        return this.moderatedStatusDate;
    }

    @NotNull
    public final DisplayName copy(@Nullable String displayName, @Nullable String proposedDisplayName, @Nullable String proposedStatus, @Nullable String moderatedStatusDate) {
        return new DisplayName(displayName, proposedDisplayName, proposedStatus, moderatedStatusDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayName)) {
            return false;
        }
        DisplayName displayName = (DisplayName) other;
        return Intrinsics.areEqual(this.displayName, displayName.displayName) && Intrinsics.areEqual(this.proposedDisplayName, displayName.proposedDisplayName) && Intrinsics.areEqual(this.proposedStatus, displayName.proposedStatus) && Intrinsics.areEqual(this.moderatedStatusDate, displayName.moderatedStatusDate);
    }

    public int hashCode() {
        String str = this.displayName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.proposedDisplayName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.proposedStatus;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.moderatedStatusDate;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DisplayName(displayName=" + this.displayName + ", proposedDisplayName=" + this.proposedDisplayName + ", proposedStatus=" + this.proposedStatus + ", moderatedStatusDate=" + this.moderatedStatusDate + ")";
    }

    public DisplayName(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.displayName = str;
        this.proposedDisplayName = str2;
        this.proposedStatus = str3;
        this.moderatedStatusDate = str4;
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final String getProposedDisplayName() {
        return this.proposedDisplayName;
    }

    @Nullable
    public final String getProposedStatus() {
        return this.proposedStatus;
    }

    @Nullable
    public final String getModeratedStatusDate() {
        return this.moderatedStatusDate;
    }
}
