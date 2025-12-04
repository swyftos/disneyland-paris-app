package com.urbanairship.contacts;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/contacts/StableContactInfo;", "", "contactId", "", "namedUserId", "(Ljava/lang/String;Ljava/lang/String;)V", "getContactId", "()Ljava/lang/String;", "getNamedUserId", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class StableContactInfo {
    private final String contactId;
    private final String namedUserId;

    public static /* synthetic */ StableContactInfo copy$default(StableContactInfo stableContactInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stableContactInfo.contactId;
        }
        if ((i & 2) != 0) {
            str2 = stableContactInfo.namedUserId;
        }
        return stableContactInfo.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getNamedUserId() {
        return this.namedUserId;
    }

    @NotNull
    public final StableContactInfo copy(@NotNull String contactId, @Nullable String namedUserId) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        return new StableContactInfo(contactId, namedUserId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StableContactInfo)) {
            return false;
        }
        StableContactInfo stableContactInfo = (StableContactInfo) other;
        return Intrinsics.areEqual(this.contactId, stableContactInfo.contactId) && Intrinsics.areEqual(this.namedUserId, stableContactInfo.namedUserId);
    }

    public int hashCode() {
        int iHashCode = this.contactId.hashCode() * 31;
        String str = this.namedUserId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "StableContactInfo(contactId=" + this.contactId + ", namedUserId=" + this.namedUserId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public StableContactInfo(@NotNull String contactId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        this.contactId = contactId;
        this.namedUserId = str;
    }

    @NotNull
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final String getNamedUserId() {
        return this.namedUserId;
    }
}
