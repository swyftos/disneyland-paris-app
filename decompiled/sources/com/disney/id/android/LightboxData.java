package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/disney/id/android/LightboxData;", "", "cancelled", "", "accountCreated", "didReauth", "didLogout", "updateProfileDelta", "", "", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "emailVerificationErrorCode", "accountDeleted", "(ZZZZLjava/util/Map;Lcom/disney/id/android/NewslettersResult;Ljava/lang/String;Z)V", "getAccountCreated", "()Z", "getAccountDeleted", "getCancelled", "getDidLogout", "getDidReauth", "getEmailVerificationErrorCode", "()Ljava/lang/String;", "getNewslettersResult", "()Lcom/disney/id/android/NewslettersResult;", "getUpdateProfileDelta", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LightboxData {
    private final boolean accountCreated;
    private final boolean accountDeleted;
    private final boolean cancelled;
    private final boolean didLogout;
    private final boolean didReauth;

    @Nullable
    private final String emailVerificationErrorCode;

    @Nullable
    private final NewslettersResult newslettersResult;

    @Nullable
    private final Map<String, Object> updateProfileDelta;

    /* renamed from: component1, reason: from getter */
    public final boolean getCancelled() {
        return this.cancelled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAccountCreated() {
        return this.accountCreated;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDidReauth() {
        return this.didReauth;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDidLogout() {
        return this.didLogout;
    }

    @Nullable
    public final Map<String, Object> component5() {
        return this.updateProfileDelta;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final NewslettersResult getNewslettersResult() {
        return this.newslettersResult;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getEmailVerificationErrorCode() {
        return this.emailVerificationErrorCode;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAccountDeleted() {
        return this.accountDeleted;
    }

    @NotNull
    public final LightboxData copy(boolean cancelled, boolean accountCreated, boolean didReauth, boolean didLogout, @Nullable Map<String, ? extends Object> updateProfileDelta, @Nullable NewslettersResult newslettersResult, @Nullable String emailVerificationErrorCode, boolean accountDeleted) {
        return new LightboxData(cancelled, accountCreated, didReauth, didLogout, updateProfileDelta, newslettersResult, emailVerificationErrorCode, accountDeleted);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LightboxData)) {
            return false;
        }
        LightboxData lightboxData = (LightboxData) other;
        return this.cancelled == lightboxData.cancelled && this.accountCreated == lightboxData.accountCreated && this.didReauth == lightboxData.didReauth && this.didLogout == lightboxData.didLogout && Intrinsics.areEqual(this.updateProfileDelta, lightboxData.updateProfileDelta) && Intrinsics.areEqual(this.newslettersResult, lightboxData.newslettersResult) && Intrinsics.areEqual(this.emailVerificationErrorCode, lightboxData.emailVerificationErrorCode) && this.accountDeleted == lightboxData.accountDeleted;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.cancelled) * 31) + Boolean.hashCode(this.accountCreated)) * 31) + Boolean.hashCode(this.didReauth)) * 31) + Boolean.hashCode(this.didLogout)) * 31;
        Map<String, Object> map = this.updateProfileDelta;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        NewslettersResult newslettersResult = this.newslettersResult;
        int iHashCode3 = (iHashCode2 + (newslettersResult == null ? 0 : newslettersResult.hashCode())) * 31;
        String str = this.emailVerificationErrorCode;
        return ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.accountDeleted);
    }

    @NotNull
    public String toString() {
        return "LightboxData(cancelled=" + this.cancelled + ", accountCreated=" + this.accountCreated + ", didReauth=" + this.didReauth + ", didLogout=" + this.didLogout + ", updateProfileDelta=" + this.updateProfileDelta + ", newslettersResult=" + this.newslettersResult + ", emailVerificationErrorCode=" + this.emailVerificationErrorCode + ", accountDeleted=" + this.accountDeleted + ")";
    }

    public LightboxData(boolean z, boolean z2, boolean z3, boolean z4, @Nullable Map<String, ? extends Object> map, @Nullable NewslettersResult newslettersResult, @Nullable String str, boolean z5) {
        this.cancelled = z;
        this.accountCreated = z2;
        this.didReauth = z3;
        this.didLogout = z4;
        this.updateProfileDelta = map;
        this.newslettersResult = newslettersResult;
        this.emailVerificationErrorCode = str;
        this.accountDeleted = z5;
    }

    public /* synthetic */ LightboxData(boolean z, boolean z2, boolean z3, boolean z4, Map map, NewslettersResult newslettersResult, String str, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, z3, z4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : newslettersResult, (i & 64) != 0 ? null : str, (i & 128) != 0 ? false : z5);
    }

    public final boolean getCancelled() {
        return this.cancelled;
    }

    public final boolean getAccountCreated() {
        return this.accountCreated;
    }

    public final boolean getDidReauth() {
        return this.didReauth;
    }

    public final boolean getDidLogout() {
        return this.didLogout;
    }

    @Nullable
    public final Map<String, Object> getUpdateProfileDelta() {
        return this.updateProfileDelta;
    }

    @Nullable
    public final NewslettersResult getNewslettersResult() {
        return this.newslettersResult;
    }

    @Nullable
    public final String getEmailVerificationErrorCode() {
        return this.emailVerificationErrorCode;
    }

    public final boolean getAccountDeleted() {
        return this.accountDeleted;
    }
}
