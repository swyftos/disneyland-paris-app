package com.urbanairship.contacts;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/contacts/ContactIdUpdate;", "", "contactId", "", "namedUserId", "isStable", "", "resolveDateMs", "", "(Ljava/lang/String;Ljava/lang/String;ZJ)V", "getContactId", "()Ljava/lang/String;", "()Z", "getNamedUserId", "getResolveDateMs", "()J", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toContactInfo", "Lcom/urbanairship/contacts/StableContactInfo;", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContactIdUpdate {
    private final String contactId;
    private final boolean isStable;
    private final String namedUserId;
    private final long resolveDateMs;

    public static /* synthetic */ ContactIdUpdate copy$default(ContactIdUpdate contactIdUpdate, String str, String str2, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactIdUpdate.contactId;
        }
        if ((i & 2) != 0) {
            str2 = contactIdUpdate.namedUserId;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = contactIdUpdate.isStable;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = contactIdUpdate.resolveDateMs;
        }
        return contactIdUpdate.copy(str, str3, z2, j);
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

    /* renamed from: component3, reason: from getter */
    public final boolean getIsStable() {
        return this.isStable;
    }

    /* renamed from: component4, reason: from getter */
    public final long getResolveDateMs() {
        return this.resolveDateMs;
    }

    @NotNull
    public final ContactIdUpdate copy(@NotNull String contactId, @Nullable String namedUserId, boolean isStable, long resolveDateMs) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        return new ContactIdUpdate(contactId, namedUserId, isStable, resolveDateMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactIdUpdate)) {
            return false;
        }
        ContactIdUpdate contactIdUpdate = (ContactIdUpdate) other;
        return Intrinsics.areEqual(this.contactId, contactIdUpdate.contactId) && Intrinsics.areEqual(this.namedUserId, contactIdUpdate.namedUserId) && this.isStable == contactIdUpdate.isStable && this.resolveDateMs == contactIdUpdate.resolveDateMs;
    }

    public int hashCode() {
        int iHashCode = this.contactId.hashCode() * 31;
        String str = this.namedUserId;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isStable)) * 31) + Long.hashCode(this.resolveDateMs);
    }

    @NotNull
    public String toString() {
        return "ContactIdUpdate(contactId=" + this.contactId + ", namedUserId=" + this.namedUserId + ", isStable=" + this.isStable + ", resolveDateMs=" + this.resolveDateMs + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ContactIdUpdate(@NotNull String contactId, @Nullable String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        this.contactId = contactId;
        this.namedUserId = str;
        this.isStable = z;
        this.resolveDateMs = j;
    }

    @NotNull
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final String getNamedUserId() {
        return this.namedUserId;
    }

    public final boolean isStable() {
        return this.isStable;
    }

    public final long getResolveDateMs() {
        return this.resolveDateMs;
    }

    @NotNull
    public final StableContactInfo toContactInfo() {
        return new StableContactInfo(this.contactId, this.namedUserId);
    }
}
