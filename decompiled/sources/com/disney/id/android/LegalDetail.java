package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JN\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006$"}, d2 = {"Lcom/disney/id/android/LegalDetail;", "", "code", "", "requiresActiveConsent", "", "accepted", "text", "links", "", "Lcom/disney/id/android/PlainTextLink;", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/util/List;)V", "getAccepted", "()Z", "setAccepted", "(Z)V", "getCode", "()Ljava/lang/String;", "getLinks", "()Ljava/util/List;", "getRequiresActiveConsent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/util/List;)Lcom/disney/id/android/LegalDetail;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LegalDetail {
    private boolean accepted;

    @Nullable
    private final String code;

    @Nullable
    private final List<PlainTextLink> links;

    @Nullable
    private final Boolean requiresActiveConsent;

    @Nullable
    private final String text;

    public static /* synthetic */ LegalDetail copy$default(LegalDetail legalDetail, String str, Boolean bool, boolean z, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legalDetail.code;
        }
        if ((i & 2) != 0) {
            bool = legalDetail.requiresActiveConsent;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            z = legalDetail.accepted;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str2 = legalDetail.text;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            list = legalDetail.links;
        }
        return legalDetail.copy(str, bool2, z2, str3, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getRequiresActiveConsent() {
        return this.requiresActiveConsent;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAccepted() {
        return this.accepted;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final List<PlainTextLink> component5() {
        return this.links;
    }

    @NotNull
    public final LegalDetail copy(@Nullable String code, @Nullable Boolean requiresActiveConsent, boolean accepted, @Nullable String text, @Nullable List<PlainTextLink> links) {
        return new LegalDetail(code, requiresActiveConsent, accepted, text, links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegalDetail)) {
            return false;
        }
        LegalDetail legalDetail = (LegalDetail) other;
        return Intrinsics.areEqual(this.code, legalDetail.code) && Intrinsics.areEqual(this.requiresActiveConsent, legalDetail.requiresActiveConsent) && this.accepted == legalDetail.accepted && Intrinsics.areEqual(this.text, legalDetail.text) && Intrinsics.areEqual(this.links, legalDetail.links);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.requiresActiveConsent;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.accepted)) * 31;
        String str2 = this.text;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<PlainTextLink> list = this.links;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LegalDetail(code=" + this.code + ", requiresActiveConsent=" + this.requiresActiveConsent + ", accepted=" + this.accepted + ", text=" + this.text + ", links=" + this.links + ")";
    }

    public LegalDetail(@Nullable String str, @Nullable Boolean bool, boolean z, @Nullable String str2, @Nullable List<PlainTextLink> list) {
        this.code = str;
        this.requiresActiveConsent = bool;
        this.accepted = z;
        this.text = str2;
        this.links = list;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final Boolean getRequiresActiveConsent() {
        return this.requiresActiveConsent;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final void setAccepted(boolean z) {
        this.accepted = z;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final List<PlainTextLink> getLinks() {
        return this.links;
    }
}
